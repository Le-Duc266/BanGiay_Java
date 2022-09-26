/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AnhSanPhamDAO;
import dao.ChiTietSanPhamDAO;
import dao.KichThuocDAO;
import dao.MauSacDAO;
import dao.SanPhamDAO;
import dao.SoLuongSanPhamDAO;
import entities.AnhSanPham;
import entities.AnhSanPhamPK;
import entities.ChiTietSanPham;
import entities.MauSanPham;
import entities.SanPham;
import entities.ChiTietSanPhamPK;
import entities.SizeSanPham;
import entities.SoLuongSanPham;
import entities.SoLuongSanPhamPK;
import entities.joins.ChiTietSanPhamJoin;
import entities.joins.SoLuongSanPhamJoin;
import entities.joins.AnhSanPhamJoin;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author PC
 */
@Controller
@RequestMapping(value = "admin/chitietsanpham")
public class ChiTietSanPhamController {

    ChiTietSanPhamDAO ct = null;
    SanPhamDAO spd = null;
    MauSacDAO ms = null;
    SoLuongSanPhamDAO slspd = null;
    AnhSanPhamDAO aspd = null;
    KichThuocDAO ktd = null;
   
private checkUrl c;
    public ChiTietSanPhamController() {
        ct = new ChiTietSanPhamDAO();
        spd = new SanPhamDAO();
        ms = new MauSacDAO();
        slspd = new SoLuongSanPhamDAO();
        aspd = new AnhSanPhamDAO();
        ktd = new KichThuocDAO();
         c = new checkUrl();
    }

    @RequestMapping(value = "listChiTietSanPham", method = RequestMethod.GET)
    public String colorView(Model model,HttpSession session) {
        if (c.check(session)) {
        List<ChiTietSanPhamJoin> lctsp = ct.listsChiTietSanPhamAdmin();
        //chuyển ra view
        model.addAttribute("ctsanPhams", lctsp);
        return "admin/chitietsanpham/listChiTietSanPham";
        } else {
            session.removeAttribute("user");
            return "admin/login";
        }
    }

    @RequestMapping(value = "insertChiTietSanPham", method = RequestMethod.GET)
    public String insert(Model model,HttpSession session) {
        if (c.check(session)) {
        List<SanPham> lsp = spd.getAlls();
        List<MauSanPham> msp = ms.getAlls();
        //chuyển ra view
        model.addAttribute("sanPhams", lsp);
        model.addAttribute("mauSanPhams", msp);
        return "admin/chitietsanpham/insertChiTietSanPham";
        } else {
            session.removeAttribute("user");
            return "admin/login";
        }
    }

    @RequestMapping(value = "/saveChiTietSanPham", method = RequestMethod.POST)
    public String saveChiTietSanPham(Model model,HttpSession session, ChiTietSanPham ctsp, ChiTietSanPhamPK ctsppk, int maSanPham, int maMau, Double giaTien) {
        if (c.check(session)) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String strDate = formatter.format(date);
        ctsppk = new ChiTietSanPhamPK(maSanPham, maMau);
        ctsp = new ChiTietSanPham(ctsppk, giaTien, strDate, true, "");
        //ct.Insert(ctsp);
        return "redirect:/admin/chitietsanpham/listChiTietSanPham";
        } else {
            session.removeAttribute("user");
            return "admin/login";
        }
    }

    @RequestMapping(value = "/updateChiTietSanPham", method = RequestMethod.POST)
    public String updateChiTietSanPham(Model model,HttpSession session, ChiTietSanPham ctsp, ChiTietSanPhamPK ctsppk, int maSanPham, int maMau, double giaTien, boolean status) {
if (c.check(session)) {
        ct.updateGiaSP(giaTien, status, maSanPham, maMau);
        String getDetail = "redirect:/admin/chitietsanpham/detailChiTietSanPham/" + maSanPham + "/" + maMau;
        return getDetail;
        } else {
            session.removeAttribute("user");
            return "admin/login";
        }
    }

    @RequestMapping(value = "/editChiTietSanPham/{maSanPham}/{maMau}", method = RequestMethod.GET)
    public String getChiTietSanPham(Model model,HttpSession session, ChiTietSanPhamJoin ctsp, ChiTietSanPhamPK ctsppk, @PathVariable(value = "maSanPham") int maSanPham, @PathVariable(value = "maMau") int maMau) {
        
        if (c.check(session)) {ctsp = ct.getByIdJoins(maSanPham, maMau);
        List<SanPham> lsp = spd.getAlls();
        List<MauSanPham> msp = ms.getAlls();

        //chuyển ra view
        model.addAttribute("ctsp", ctsp);
        model.addAttribute("sanPhams", lsp);
        model.addAttribute("mauSanPhams", msp);

        return "admin/chitietsanpham/updateChiTietSanPham";} else {
            session.removeAttribute("user");
            return "admin/login";
        }
    }

    @RequestMapping(value = "/detailChiTietSanPham/{maSanPham}/{maMau}", method = RequestMethod.GET)
    public String getdetailSanPham(Model model,HttpSession session, ChiTietSanPhamJoin ctsp, @PathVariable(value = "maSanPham") int maSanPham, @PathVariable(value = "maMau") int maMau, HttpServletRequest req) {
        if (c.check(session)) {
        ctsp = ct.getByIdJoins(maSanPham, maMau);
        List<SoLuongSanPhamJoin> slsp = slspd.getByChiTietSanPham(maSanPham, maMau);
        
        List<AnhSanPhamJoin> listAnh = aspd.listById(maSanPham, maMau);
        
        List<SizeSanPham> sizes = slspd.getSizesByChiTietSanPham(maSanPham, maMau);
        String uploadRootPath = req.getServletContext().getRealPath("images") + '\\';
//        //chuyển ra view
        model.addAttribute("ctsp", ctsp);
        model.addAttribute("slsp", slsp);
        model.addAttribute("listAnh", listAnh);
        model.addAttribute("uploadRootPath", uploadRootPath);
        model.addAttribute("sizes", sizes);
        return "admin/chitietsanpham/detailChiTietSanPham";} else {
            session.removeAttribute("user");
            return "admin/login";
        }
    }

    @RequestMapping(value = "/updateSoLuong", method = RequestMethod.POST)
    public String saveSoLuong(SoLuongSanPham soLuongSanPham, SoLuongSanPhamPK soLuongSanPhamPK, int maSanPham, int maMau, int maSize, int soLuongCu, int soLuongThem, boolean status) {
        soLuongSanPhamPK = new SoLuongSanPhamPK(maSize, maSanPham, maMau);
        int soLuong = soLuongCu + soLuongThem;
        soLuongSanPham = new SoLuongSanPham(soLuongSanPhamPK, soLuong, status);
        slspd.Update(soLuongSanPham);
        String getDetail = "redirect:/admin/chitietsanpham/detailChiTietSanPham/" + maSanPham + "/" + maMau;
        return getDetail;
    }

    @RequestMapping(value = "/saveSizes", method = RequestMethod.POST)
    public String saveSizes(SoLuongSanPham soLuongSanPham, SoLuongSanPhamPK soLuongSanPhamPK, int maSanPham, int maMau, int maSize) {
        soLuongSanPhamPK = new SoLuongSanPhamPK(maSize, maSanPham, maMau);
        soLuongSanPham = new SoLuongSanPham(soLuongSanPhamPK, 0, false);
        slspd.Insert(soLuongSanPham);
        String getDetail = "redirect:/admin/chitietsanpham/detailChiTietSanPham/" + maSanPham + "/" + maMau;
        return getDetail;
    }

    @RequestMapping(value = "/updateAnh", method = RequestMethod.POST)
    public String updateAnh(AnhSanPham anhSanPham, AnhSanPhamPK anhSanPhamPK, @RequestParam(value = "files") MultipartFile file, int maAnh, int maSanPham, int maMau, String tenAnhCu, HttpServletRequest req) {
        String uploadRootPath = req.getServletContext().getRealPath("images");
        String newFilename = "";
        String fileExtension = "";
        File filecu = new File(uploadRootPath + "\\" + tenAnhCu);
        tenAnhCu = FilenameUtils.removeExtension(filecu.getName());

        try {
            if (filecu.exists()) {
                filecu.delete();
            }
            fileExtension = "." + FilenameUtils.getExtension(file.getOriginalFilename());

            newFilename = tenAnhCu + fileExtension;

            File destination2 = new File(uploadRootPath + "\\" + newFilename);

            file.transferTo(destination2);
            anhSanPhamPK = new AnhSanPhamPK(maAnh, maSanPham, maMau);
            anhSanPham = new AnhSanPham(anhSanPhamPK, newFilename);
            aspd.Update(anhSanPham);
            
            if (aspd.getAnhChinh(maSanPham, maMau) == maAnh) {
                aspd.updateAnhChinh(newFilename, maSanPham, maMau);
            }

        } catch (IOException | IllegalStateException ex) {
            Logger.getLogger(ChiTietSanPhamController.class.getName()).log(Level.SEVERE, null, ex);
        }

        String getDetail = "redirect:/admin/chitietsanpham/detailChiTietSanPham/" + maSanPham + "/" + maMau;
        return getDetail;
    }

    @RequestMapping(value = "/saveImages", method = RequestMethod.POST)
    public String saveImages(AnhSanPham anhSanPham, @RequestParam(value = "files") MultipartFile[] files, int maSanPham, int maMau, Model model,HttpSession session, HttpServletRequest req) {

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

        String getDetail = "redirect:/admin/chitietsanpham/detailChiTietSanPham/" + maSanPham + "/" + maMau;
        return getDetail;
    }

    @RequestMapping(value = "/deleteAnh", method = RequestMethod.POST)
    public String deleteAnh(int maSanPham, int maMau, int maAnh,String tenAnhCu, HttpServletRequest req) {
        int getAnhChinh = aspd.getAnhChinh(maSanPham, maMau);
        aspd.Delete(maAnh);
        String uploadRootPath = req.getServletContext().getRealPath("images");
        File filecu = new File(uploadRootPath + "\\" + tenAnhCu);
        
        if (filecu.exists()) {
                filecu.delete();
            }
        
        if (getAnhChinh == maAnh) {
            getAnhChinh = aspd.getAnhChinh(maSanPham, maMau);
            AnhSanPhamJoin anhSanPham = aspd.getById(getAnhChinh);
            aspd.updateAnhChinh(anhSanPham.getLinkAnh(), maSanPham, maMau);
        }
        String getDetail = "redirect:/admin/chitietsanpham/detailChiTietSanPham/" + maSanPham + "/" + maMau;
        return getDetail;
    }

    // back page
    @RequestMapping(value = "/saveChiTietSanPham", params = "cancel", method = RequestMethod.POST)
    public String cancelSaveSanPham() {
        return "redirect:/admin/chitietsanpham/listChiTietSanPham";
    }

    @RequestMapping(value = "/updateChiTietSanPham", params = "cancel", method = RequestMethod.POST)
    public String cancelUpdateSanPham() {
        return "redirect:/admin/chitietsanpham/listChiTietSanPham";
    }
}
