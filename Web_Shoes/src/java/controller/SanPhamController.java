/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import dao.AnhSanPhamDAO;
import dao.ChiTietSanPhamDAO;
import dao.DanhMucDAO;
import dao.GioiTinhDAO;
import dao.KichThuocDAO;
import dao.MauSacDAO;
import dao.NhanHangDAO;
import dao.SanPhamDAO;
import dao.SoLuongSanPhamDAO;
import entities.ChiTietSanPham;
import entities.ChiTietSanPhamPK;
import entities.DanhMucSanPham;
import entities.GioiTinh;
import entities.MauSanPham;
import entities.NhanHang;
import entities.SanPham;
import entities.joins.SanPhamJoin;
import entities.SizeSanPham;
import entities.SoLuongSanPham;
import entities.SoLuongSanPhamPK;
import entities.joins.ChiTietSanPhamJoin;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.FilenameUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author PC
 */
@Controller
@RequestMapping(value = "admin/sanpham")
public class SanPhamController {

    SanPhamDAO spd = null;
    NhanHangDAO nhd = null;
    DanhMucDAO dmd = null;
    GioiTinhDAO gtd = null;
    MauSacDAO ms =null;
    KichThuocDAO ktd = null;
    ChiTietSanPhamDAO ctspd = null;
    SoLuongSanPhamDAO slspd = null;
    AnhSanPhamDAO aspd = null;
private checkUrl c;
    public SanPhamController() {
        spd = new SanPhamDAO();
        nhd = new NhanHangDAO();
        dmd = new DanhMucDAO();
        gtd = new GioiTinhDAO();
        ms = new MauSacDAO();
        ktd = new KichThuocDAO();
        ctspd = new ChiTietSanPhamDAO();
        slspd =new SoLuongSanPhamDAO();
         aspd = new AnhSanPhamDAO();
         c = new checkUrl();
    }

    @RequestMapping(value = "listSanPham", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE + "; charset=utf-8")
    public String sanPhamView(Model model,HttpSession session) {

       if (c.check(session)) { List<SanPhamJoin> lsp = spd.getAllSanPhamJoins();
        //chuyển ra view
        model.addAttribute("sanPhams", lsp);
        return "admin/sanpham/listSanPham";} else {
            session.removeAttribute("user");
            return "admin/login";
        }
    }

    @RequestMapping(value = "insertSanPham", method = RequestMethod.GET)
    public String index(Model model,HttpSession session) {
        if (c.check(session)) {List<NhanHang> lnhanHang = nhd.getAlls();
        List<DanhMucSanPham> ldanhmuc = dmd.getAlls();
        List<GioiTinh> lgioiTinh = gtd.getAlls();
        List<MauSanPham> msp = ms.getAlls();
        List<SizeSanPham> sizesp = ktd.getAlls();
        //chuyển ra view
        model.addAttribute("danhMucs", ldanhmuc);
        model.addAttribute("nhanHangs", lnhanHang);
        model.addAttribute("gioiTinhs", lgioiTinh);
        model.addAttribute("mauSanPhams", msp);
        model.addAttribute("sizeSanPhams", sizesp);
        return "admin/sanpham/insertSanPham";} else {
            session.removeAttribute("user");
            return "admin/login";
        }
    }

    @RequestMapping(value = "/detailSanPham/{maSanPham}", method = RequestMethod.GET)
    public String detailSanPham(Model model,HttpSession session,SanPhamJoin sp,@PathVariable(value = "maSanPham") int maSanPham) {
        if (c.check(session)) {sp = spd.getById2(maSanPham);
        List<NhanHang> lnhanHang = nhd.getAlls();
        List<DanhMucSanPham> ldanhmuc = dmd.getAlls();
        List<GioiTinh> lgioiTinh = gtd.getAlls();
        List<MauSanPham> msp = ms.getByDetailSanPhams(maSanPham);
        List<ChiTietSanPhamJoin> lct = ctspd.listsChiTietSanPhamByMaSanPham(maSanPham);
        
        
        model.addAttribute("sp", sp);
        model.addAttribute("danhMucs", ldanhmuc);
        model.addAttribute("nhanHangs", lnhanHang);
        model.addAttribute("gioiTinhs", lgioiTinh);
        model.addAttribute("lct", lct);
        model.addAttribute("msp", msp);
        return "admin/sanpham/detailSanPham";} else {
            session.removeAttribute("user");
            return "admin/login";
        }
    }
    
    @RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
    public String saveProduct(Model model,HttpSession session, String tenSanPham,int maDanhMuc,int maNhanHang,int maGioiTinh,String moTa,  String[] mauSanPham, String[] sizeSanPham,String mota) {
if (c.check(session)) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String strDate = formatter.format(date);
        //Lấy MaSanPhamMoi
        int maSanPham =spd.getSPMoi();
        
        maSanPham = maSanPham+1;
        SanPham sp=new SanPham();
        // Tạo SanPham
        sp.setMaSanPham(maSanPham);
        sp.setTenSanPham(tenSanPham);
        DanhMucSanPham anh=new DanhMucSanPham();
        anh.setMaDanhMuc(maDanhMuc);
        sp.setMaDanhMuc(anh);
        NhanHang nh=new NhanHang();
        nh.setMaNhanHang(maNhanHang);
        sp.setMaNhanHang(nh);
         GioiTinh gt=new GioiTinh();
        gt.setMaGioiTinh(maGioiTinh);
        sp.setMaGioiTinh(gt);
        sp.setMoTa(moTa);
        
        spd.Insert(sp);

        ChiTietSanPhamPK ctSpPK;
        ChiTietSanPham ctSP;

        SoLuongSanPhamPK slSpPK;
        SoLuongSanPham slSP;

        System.out.println(mauSanPham);
        if (mauSanPham.length != 1) {
            for (int i = 1; i < mauSanPham.length; i++) {//tăng i = 1 vì phải thêm để Chống lỗi null của array
                //Tạo khóa chính ChiTietSanPhamPK
                System.out.println("Ma mau: "+mauSanPham[i]);
                ctSpPK = new ChiTietSanPhamPK(maSanPham, Integer.parseInt(mauSanPham[i]));
                System.out.println("ChiTietSanPhamPK: "+ctSpPK);
                //Gán khóa chính ChiTietSanPhamPK để tạo ChiTietSanPham
                ctSP = new ChiTietSanPham(ctSpPK, 0.0, strDate, false,"");
                System.out.println("Chi tiet san pham : "+ctSP);
                ctspd.Insert(ctSP);
                if (sizeSanPham.length != 1) {
                    for (int j = 1; j < sizeSanPham.length; j++) {
                        System.out.println("-----Ma Size: "+sizeSanPham[j]);
                        //Tạo khóa chính SoLuongSanPhamPK
                        slSpPK = new SoLuongSanPhamPK(Integer.parseInt(sizeSanPham[j]), maSanPham, Integer.parseInt(mauSanPham[i]));
                        //Gán khóa chính SoLuongSanPhamPK để tạo SoLuongSanPham
                        slSP = new SoLuongSanPham(slSpPK, 0);
                        slspd.Insert(slSP);
                    }
                }
            }
        }


        return "redirect:/admin/sanpham/listSanPham";} else {
            session.removeAttribute("user");
            return "admin/login";
        }
    }
    
    @RequestMapping(value = "/insert2ChiTietSanPham", method = RequestMethod.POST)
    public String insert2ChiTietSanPham(Model model,HttpSession session, ChiTietSanPham ctsp, ChiTietSanPhamPK ctsppk , @RequestParam(value = "files") MultipartFile[] files, int maSanPham, int maMau, Double giaTien, HttpServletRequest req) {
        if (c.check(session)) {SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String strDate = formatter.format(date);
        ctsppk = new ChiTietSanPhamPK(maSanPham, maMau);
        ctsp = new ChiTietSanPham(ctsppk, giaTien, strDate, true, "");
        ctspd.Insert(ctsp);
        
        String newFilename = "";
        String fileExtension = "";
        int idAnhMoiNhat = aspd.getIdAnhMoiNhat();
        //upload ảnh
        for (MultipartFile file : files) {
            try {

                idAnhMoiNhat++;
                String uploadRootPath = req.getServletContext().getRealPath("images");

                fileExtension = "." + FilenameUtils.getExtension(file.getOriginalFilename());

                newFilename = "anh" + idAnhMoiNhat + fileExtension;

                File destination2 = new File(uploadRootPath + "\\" + newFilename);

                file.transferTo(destination2);

                aspd.insertAnhSP(newFilename, maSanPham, maMau);

                if (aspd.kiemTraCoAnhChua(maSanPham, maMau) == 1) {
                    aspd.updateAnhChinh(newFilename, maSanPham, maMau);
                }

            } catch (IOException | IllegalStateException ex) {
                Logger.getLogger(ChiTietSanPhamController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return "redirect:/admin/chitietsanpham/listChiTietSanPham";} else {
            session.removeAttribute("user");
            return "admin/login";
        }
    }
    
//    @RequestMapping(value = "/updateProduct", method = RequestMethod.POST)
//    public String updateProduct(Model model,HttpSession session, SanPham sp,int maSanPham,String mota) {
//        if (c.check(session)) {spd.Update(sp);
//        String getDetail = "redirect:/admin/sanpham/detailSanPham/" + maSanPham;
//        return getDetail;} else {
//            session.removeAttribute("user");
//            return "admin/login";
//        }
//    }
    
     @RequestMapping(value = "/updateProduct", method = RequestMethod.POST)
    public String updateProduct(Model model,int maSanPham,String tenSanPham,int maDanhMuc,int maNhanHang,int maGioiTinh,String moTa) {
        spd.Update(maSanPham, tenSanPham, maDanhMuc, maNhanHang, maGioiTinh, moTa);
        String getDetail = "redirect:/admin/sanpham/detailSanPham/" + maSanPham;
        return getDetail;
    }
}
