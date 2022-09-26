/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao1.HoaDonDao;
import entities.HoaDon;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author DELL
 */
@Controller
@RequestMapping(value = "admin/hoadon")
public class HoaDonController {

    HoaDonDao hdDao = null;
private checkUrl c;
    public HoaDonController() {
        hdDao = new HoaDonDao();
        c = new checkUrl();
    }

    @RequestMapping(value = "listHoaDonDXL", method = RequestMethod.GET)
    public String listHoaDonDXL(Model model,HttpSession session) {
        if (c.check(session)) {
        List<HoaDon> list = hdDao.getAlls();

        model.addAttribute("hoadon", list);

        return "admin/hoadon/listHoaDonDXL";} else {
            session.removeAttribute("user");
            return "admin/login";
        }
    }
    @RequestMapping(value = "listHuyDon", method = RequestMethod.GET)
    public String listHuyDon(Model model,HttpSession session) {
        if (c.check(session)) {
        List<HoaDon> list = hdDao.getHoadonDaHuy();

        model.addAttribute("hoadon", list);

        return "admin/hoadon/listDonDaHuy";} else {
            session.removeAttribute("user");
            return "admin/login";
        }
    }
    @RequestMapping(value = "lisDonDaDuyet", method = RequestMethod.GET)
    public String lisDonDaDuyet(Model model,HttpSession session) {
        if (c.check(session)) {List<HoaDon> list = hdDao.getHoadonDaDuyet();

        model.addAttribute("hoadon", list);

        return "admin/hoadon/listDonDaDuyet";} else {
            session.removeAttribute("user");
            return "admin/login";
        }
    }
    @RequestMapping(value = "listDonDangGiao", method = RequestMethod.GET)
    public String ListDonDangGiao(Model model,HttpSession session) {
        if (c.check(session)) {List<HoaDon> list = hdDao.getHoadonDangGiao();

        model.addAttribute("hoadon", list);

        return "admin/hoadon/listDonDangGiao";} else {
            session.removeAttribute("user");
            return "admin/login";
        }
    }
    @RequestMapping(value = "listDonDaGiao", method = RequestMethod.GET)
    public String ListDonDaGiao(Model model,HttpSession session) {
        if (c.check(session)) {List<HoaDon> list = hdDao.getHoadonDaGiao();

        model.addAttribute("hoadon", list);

        return "admin/hoadon/listDonDaGiaoThanhCong";} else {
            session.removeAttribute("user");
            return "admin/login";
        }
    }

    @RequestMapping(value = "/updatetintrang")
    @ResponseBody
    public Boolean updatetintrang(@RequestParam int maHoaDon, @RequestParam int tinhTrang, ModelMap mm, HttpSession session
    ) {

        HoaDon hoaDon = hdDao.detail(maHoaDon);
        if (tinhTrang == 0) {
            hoaDon.setTinhTrang(0);
        } else if (tinhTrang == 1) {
            hoaDon.setTinhTrang(2);
        } else if (tinhTrang == 2) {
            hoaDon.setTinhTrang(3);
        } else if (tinhTrang == 3) {
            hoaDon.setTinhTrang(4);
        }
        boolean result = hdDao.UpdateStatus(hoaDon);

        return result;
        

    }
    @RequestMapping(value = "HoaDonDetail", method = RequestMethod.GET)
    public String HoaDonDetail(Model model, int maHoaDon, HttpSession session) {
        if (c.check(session)) {HoaDon hoaDon=hdDao.detail(maHoaDon);
        System.out.println(hoaDon.getChiTietHoaDonCollection());
        model.addAttribute("ha",hoaDon);
        model.addAttribute("hoadon",hoaDon.getChiTietHoaDonCollection());
        return "admin/hoadon/DetailHoaDon";
        } else {
            session.removeAttribute("user");
            return "admin/login";
        }
    }

}
