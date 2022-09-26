package controller;

import dao1.NhanhangDao;

import entities.NhanHang;
import java.io.File;

import java.io.IOException;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author DELL
 */
@Controller
@RequestMapping(value = "admin/nhanhang")
public class NhanHangController {

    NhanhangDao nhdao = null;
    private checkUrl c;

    public NhanHangController() {
        nhdao = new NhanhangDao();
        c = new checkUrl();
    }

    @RequestMapping(value = "listNhanHang", method = RequestMethod.GET)
    public String categoryView(Model model, HttpSession session) {
        
            if (c.check(session)) {
                List<NhanHang> list = nhdao.getAlls();

                model.addAttribute("nhanhang", list);
                return "admin/nhanhang/listNhanHang";
            } else {
                session.removeAttribute("user");
                return "admin/login";
            }
        }

        @RequestMapping(value = "/saveNhanHang", method = RequestMethod.POST)
        public String saveNhanHang
        (NhanHang nhanhang, MultipartFile anhBannerURL
        , HttpServletRequest request
        
            ) {
       
        if (nhanhang.getMaNhanHang() == 0) {
                try {
                    String uploadRootPath = request.getServletContext().getRealPath("/") + "resources/images/nhanhang/";
                    File destination = new File(uploadRootPath + "/" + anhBannerURL.getOriginalFilename());
                    anhBannerURL.transferTo(destination);
                    nhanhang.setHinhNhanHang(anhBannerURL.getOriginalFilename());
                } catch (IOException | IllegalStateException ex) {
                    Logger.getLogger(NhanHangController.class.getName()).log(Level.SEVERE, null, ex);
                }
                nhdao.Insert(nhanhang);
            } else {
                if (!anhBannerURL.isEmpty()) {
                    try {
                        String uploadRootPath = request.getServletContext().getRealPath("/") + "resources/images/nhanhang/";
                        File destination = new File(uploadRootPath + "/" + anhBannerURL.getOriginalFilename());
                        anhBannerURL.transferTo(destination);
                        nhanhang.setHinhNhanHang(anhBannerURL.getOriginalFilename());
                    } catch (IOException | IllegalStateException ex) {
                        Logger.getLogger(NhanHangController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    nhdao.Update(nhanhang);
                } else {
                    System.out.println(nhanhang.getHinhNhanHang());
                    nhdao.Update(nhanhang);
                }
            }
            return "redirect:listNhanHang";
        }

        @RequestMapping(value = "/updateNhanHang", method = RequestMethod.GET)
        public String updateCate
        (Model model, HttpSession session
        , int maNhanHang
        
            ) {
        model.addAttribute("nhanhang", nhdao.getById(maNhanHang));
            return "update-nhanhang";
        }

        @RequestMapping(value = "/delete")
        @ResponseBody
        public Boolean delete
        (@RequestParam
        int maNhanhang
        
            ) {

        if (nhdao.delete(maNhanhang)) {
                return true;
            } else {
                return false;
            }

        }

    }
