/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DanhMucDAO;
import entities.DanhMucSanPham;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author DELL
 */
@Controller
@RequestMapping(value = "admin/category")
public class CategoryController {

    private checkUrl c;
    DanhMucDAO dmuc = null;

    public CategoryController() {
        dmuc = new DanhMucDAO();
        c = new checkUrl();
    }

    @RequestMapping(value = "listCate", method = RequestMethod.GET)
    public String categoryView(Model model, HttpSession session) {
        if (c.check(session)) {
            model.addAttribute("danhmuc", dmuc.getAlls());
            return "admin/category/listCate";
        } else {
            session.removeAttribute("user");
            return "admin/login";
        }
    }

    @RequestMapping(value = "saveCate", method = RequestMethod.POST)
    public String saveCate(Model model, DanhMucSanPham d, HttpSession session) {
        if (c.check(session)) {

            if (d.getMaDanhMuc() == 0) {
                dmuc.Insert(d);
            } else {
                dmuc.Update(d);
            }
            return "redirect:listCate";
        } else {
            session.removeAttribute("user");
            return "admin/login";
        }
    }

    @RequestMapping(value = "/updateCate", method = RequestMethod.GET)
    public String updateCate(Model model, int madanhmuc, HttpSession session) {
        if (c.check(session)) {
        
        model.addAttribute("dmuc", dmuc.getById(madanhmuc));
        return "update-cat";
        } else {
            session.removeAttribute("user");
            return "admin/login";
        }
    }
    
    

}
