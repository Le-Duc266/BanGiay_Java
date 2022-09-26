/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.google.gson.Gson;
import dao1.DanhMucDAO;
import dao.HibernateUtil;
import dao1.KhuyenmaiDao;
import dao1.SanPhamDao;
import entities.ChiTietKhuyenMai;
import entities.DanhMucSanPham;
import entities.DanhmucEntity;
import entities.KhuyenMai;
import entities.SanPham;
import entities.SanPhamEntity;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(value = "admin/khuyenmai")
public class KhuyenmaiController {

    SessionFactory sessionFactory;
    DanhMucDAO dmuc = null;
    SanPhamDao spham = null;
    KhuyenmaiDao kmai = null;
private checkUrl c;
    public KhuyenmaiController() {
        dmuc = new DanhMucDAO();
        spham = new SanPhamDao();
        kmai = new KhuyenmaiDao();
        c = new checkUrl();
    }

    @RequestMapping(value = "/insertKhuyenmai")
    public String insertKuyenmai(Model model,HttpSession session) {
         List<DanhMucSanPham> danhmuc =dmuc.getAlls();
         List<SanPham> result =spham.getSanPham();
         model.addAttribute("danhmuc", danhmuc);
         model.addAttribute("sanpham", result);
        return "admin/khuyenmai/insertKhuyenmai";
    }

//    @RequestMapping(value = "/laydanhmuc", method = RequestMethod.GET)
//    @ResponseBody
//    public List<DanhmucEntity> laydanhmuc(Model model,HttpSession session) {
//        return dmuc.getAll();
//    }
//
//    @RequestMapping(value = "/laysanpham", method = RequestMethod.GET)
//    @ResponseBody 
//    public List<SanPhamEntity> laysanpham(Model model,HttpSession session) {
//        return spham.getAll();
//    }

    @RequestMapping(value = "/insertKM", method = RequestMethod.POST)
    public String insertKM(Integer maKhuyenMai, String tenKhuyenMai, Integer giaGiam, String thoiGianBatDau, String thoiGianKetThuc, String moTa, Boolean kmtheo, int[] khuyenmaidanhmuc,int[] khuyenMaisanpham, ModelMap mm,Model model,HttpSession session) throws ParseException {
         if (c.check(session)) {List<DanhMucSanPham> danhmuc =dmuc.getAlls();
         List<SanPham> sanpham =spham.getSanPham();
         model.addAttribute("danhmuc", danhmuc);
         model.addAttribute("sanpham", sanpham);
        boolean result = false;
        KhuyenMai khuyenMai = new KhuyenMai();

        if (kmtheo == true) {

            khuyenMai.setMaKhuyenMai(maKhuyenMai);
            khuyenMai.setTenKhuyenMai(tenKhuyenMai);
            khuyenMai.setGiaGiam(giaGiam);
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm");
            khuyenMai.setThoiGianBatDau(format.parse(thoiGianBatDau));
            khuyenMai.setThoiGianKetThuc(format.parse(thoiGianKetThuc));
            khuyenMai.setKmtheo(kmtheo);
            khuyenMai.setMoTa(moTa);
            khuyenMai.setStatus(true);
            List<SanPham> a = null;
            System.out.println(format.parse(thoiGianBatDau));
            List<SanPham> ab = new ArrayList<>();

            for (int i = 0; i < khuyenmaidanhmuc.length; i++) {

                DanhMucSanPham danhMucSanPham = new DanhMucSanPham();
                danhMucSanPham.setMaDanhMuc(Integer.valueOf(khuyenmaidanhmuc[i]));
                a = spham.getByIdDanhMuc(danhMucSanPham);
                for (SanPham sanPham : a) {
                    List<SanPham> li = kmai.getByIdDanhMuc(sanPham.getMaSanPham(), khuyenMai.getThoiGianBatDau());

                    for (SanPham li1 : li) {
                        ab.add(li1);
                    }

                    khuyenMai.addKhuyenMai(sanPham);

                }

            }

            if (!ab.isEmpty()) {
                
                for (SanPham ab1 : ab) {
                    mm.put("error", "Sản Phẩm" + ab1.getTenSanPham() + " thuộc danh muc " + ab1.getMaDanhMuc().getTenDanhMuc() + " đã tồn tai");
                    break;
                    
                }
                return "admin/khuyenmai/insertKhuyenmai";

            } else {
                
                kmai.Insert(khuyenMai);
                return "redirect:listKhuyenMai";
            }
        }
        if (kmtheo == false) {

            khuyenMai.setMaKhuyenMai(maKhuyenMai);
            khuyenMai.setTenKhuyenMai(tenKhuyenMai);
            khuyenMai.setGiaGiam(giaGiam);
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm");
            khuyenMai.setThoiGianBatDau(format.parse(thoiGianBatDau));
            khuyenMai.setThoiGianKetThuc(format.parse(thoiGianKetThuc));
            khuyenMai.setKmtheo(kmtheo);
            khuyenMai.setMoTa(moTa);
            khuyenMai.setStatus(true);
            List<SanPham> ab = new ArrayList<>();
            for (int i = 0; i < khuyenMaisanpham.length; i++) {
                SanPham pham = new SanPham();
                pham.setMaSanPham(khuyenMaisanpham[i]);
                List<SanPham> li = kmai.getByIdDanhMuc(pham.getMaSanPham(), khuyenMai.getThoiGianBatDau());
                khuyenMai.addKhuyenMai(pham);
                for (SanPham li1 : li) {
                    ab.add(li1);
                }

            }
          
            if (!ab.isEmpty()) {
                for (SanPham ab1 : ab) {
                    mm.put("error","Sản Phẩm" + ab1.getTenSanPham() + " đã tồn tai");
                    break;
                }
                return "admin/khuyenmai/insertKhuyenmai";

            } else {
              
                kmai.Insert(khuyenMai);
                return "redirect:listKhuyenMai";
            }
            
        }

        return null;
        } else {
            session.removeAttribute("user");
            return "admin/login";
        }
    }

    @RequestMapping(value = "/detailKhuyenMai", method = RequestMethod.GET)
    public String detailKhuyenMai(Model model,HttpSession session, int maKhuyenMai) {
       if (c.check(session)) { KhuyenMai khuyenMai = kmai.getById(maKhuyenMai);
        model.addAttribute("c", khuyenMai);
        model.addAttribute("danhsach", khuyenMai.getSanPhamCollection());

        return "admin/khuyenmai/detailKhuyenMai";} else {
            session.removeAttribute("user");
            return "admin/login";
        }
    }
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(int maKhuyenMai,HttpSession session) {
       if (c.check(session)) { kmai.delete(maKhuyenMai);
        return "redirect:listKhuyenMai";} else {
            session.removeAttribute("user");
            return "admin/login";
        }
    }

    @RequestMapping(value = "listKhuyenMai", method = RequestMethod.GET)
    public String listKhuyenMai(Model model,HttpSession session) throws ParseException {
        if (c.check(session)) {List<KhuyenMai> list = kmai.getAlls();
        for (KhuyenMai list1 : list) {
            String date = new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date());
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm");
            Date batdau = format.parse(date);

            long def = batdau.getTime() - list1.getThoiGianKetThuc().getTime();

            long deff = def / (60 * 1000);

            if (deff > 0) {
                list1.setStatus(false);
                kmai.Update(list1);
            }
        }
        model.addAttribute("khuyenmai", list);

        return "admin/khuyenmai/listKhuyenMai";} else {
            session.removeAttribute("user");
            return "admin/login";
        }
    }

}
