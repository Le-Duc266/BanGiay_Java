/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.KichThuocDAO;
import dao.SoLuongSanPhamDAO;
import dao.MauSacDAO;
import dao.SanPhamDAO;
import entities.SoLuongSanPham;
import entities.MauSanPham;
import entities.SanPham;
import entities.SizeSanPham;
import entities.SoLuongSanPhamPK;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author PC
 */
@Controller
@RequestMapping(value = "admin/soluongsanpham")
public class SoLuongSanPhamController {

    SoLuongSanPhamDAO slspd = null;
    SanPhamDAO spd = null;
    MauSacDAO ms = null;
    KichThuocDAO ktd = null;
private checkUrl c;
    public SoLuongSanPhamController() {
        c = new checkUrl();
        slspd = new SoLuongSanPhamDAO();
        spd = new SanPhamDAO();
        ms = new MauSacDAO();
        ktd = new KichThuocDAO();
    }

    @RequestMapping(value = "listSoLuongSanPham", method = RequestMethod.GET)
    public String colorView(Model model,HttpSession session) {
        if (c.check(session)) {List<SoLuongSanPham> lslsp = slspd.getAlls();
        List<SanPham> lsp = spd.getAlls();
        List<MauSanPham> msp = ms.getAlls();
        List<SizeSanPham> sizesp = ktd.getAlls();
        String tenSanPham = "";
        String tenMau = "";
        String tenSize = "";


        //chuyển ra view
        return "admin/soluongsanpham/listSoLuongSanPham";} else {
            session.removeAttribute("user");
            return "admin/login";
        }
    }

    @RequestMapping(value = "insertSoLuongSanPham", method = RequestMethod.GET)
    public String insert(Model model,HttpSession session) {
        if (c.check(session)) {List<SanPham> lsp = spd.getAlls();
        List<MauSanPham> msp = ms.getAlls();
        List<SizeSanPham> sizesp = ktd.getAlls();

        //chuyển ra view
        model.addAttribute("sanPhams", lsp);
        model.addAttribute("mauSanPhams", msp);
        model.addAttribute("sizeSanPhams", sizesp);
        return "admin/soluongsanpham/insertSoLuongSanPham";} else {
            session.removeAttribute("user");
            return "admin/login";
        }
    }
    
    @RequestMapping(value = "/saveSoLuongSanPham", method = RequestMethod.POST)
    public String saveChiTietSanPham(Model model,HttpSession session, SoLuongSanPham slsp, SoLuongSanPhamPK slsppk, int maSanPham, int maMau,int maSize, int soLuong) {
        
        slsppk = new SoLuongSanPhamPK(maSize, maSanPham, maMau);
        slsp = new SoLuongSanPham(slsppk, soLuong, true);
        slspd.Insert(slsp);
        return "redirect:/admin/soluongsanpham/listSoLuongSanPham";
    }
}
