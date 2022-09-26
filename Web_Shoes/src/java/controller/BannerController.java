/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.BannerDAO;
import entities.Banner;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Admin
 */
@Controller
@RequestMapping(value = "admin/banner")
public class BannerController {
private checkUrl c;
    ServletContext servletContext;

    BannerDAO bn = null;

    public BannerController() {
        bn = new BannerDAO();
        c = new checkUrl();
    }

    @RequestMapping(value = "listBan", method = RequestMethod.GET)
    public String BannerView(Model model,HttpSession session) {
       
         if (c.check(session)) {
             model.addAttribute("bn", bn.getAlls());
        return "admin/banner/listBanner";
        } else {
            session.removeAttribute("user");
            return "admin/login";
        }
    }

    @RequestMapping(value = "saveBan", method = RequestMethod.POST)
    public String saveBanner(Banner b, MultipartFile anhBannerURL, HttpServletRequest request,HttpSession session) {
        if (c.check(session)) {
        try {
            String uploadRootPath = request.getServletContext().getRealPath("/") + "resources/images/banner/";
            File destination = new File(uploadRootPath + "/" + anhBannerURL.getOriginalFilename());
            anhBannerURL.transferTo(destination);
            b.setAnhBanner(anhBannerURL.getOriginalFilename());
        } catch (IOException | IllegalStateException ex) {
            Logger.getLogger(BannerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(b);
        if (b.getMaBanner() == 0) {
            bn.Insert(b);
        } else {

            bn.Update(b);
        }
        return "redirect:listBan";
        } else {
            session.removeAttribute("user");
            return "admin/login";
        }
    }

    @RequestMapping(value = "/updateBanner", method = RequestMethod.GET)
    public String updateban(Model model, int maBanner,HttpSession session) {
         if (c.check(session)) {
        model.addAttribute("bn", bn.getById(maBanner));
        return "updateBanner";
        } else {
            session.removeAttribute("user");
            return "admin/login";
        }
    }

    @RequestMapping(value = "/deleteBanner", method = RequestMethod.GET)
    public String deleteBan(int maBanner,HttpSession session) {
         if (c.check(session)) {
        bn.Delete(maBanner);
        return "redirect:listBan";
        } else {
            session.removeAttribute("user");
            return "admin/login";
        }
    }
    
     @RequestMapping(value = "/deleteAnh", method = RequestMethod.POST)
    public String deleteAnh(int maAnh,String tenAnhCu, HttpServletRequest req,HttpSession session) {
       if (c.check(session)) {
        bn.Delete(maAnh);
        
        String uploadRootPath = req.getServletContext().getRealPath("/") + "resources/images/banner/";
        File filecu = new File(uploadRootPath + "\\" + tenAnhCu);
        if (filecu.exists()) {
                filecu.delete();
            }
         return "redirect:listBan";
         } else {
            session.removeAttribute("user");
            return "admin/login";
        }
    }
}

