/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.GioiTinhDAO;
import entities.GioiTinh;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Admin
 */
@Controller
@RequestMapping(value = "admin/sex")
public class SexController {
    GioiTinhDAO gt =null;
private checkUrl c;
    public SexController() {
        gt = new GioiTinhDAO();
        c = new checkUrl();
    }
    @RequestMapping(value = "listSex", method = RequestMethod.GET)
    public String sexView(Model model,HttpSession session) {
        if (c.check(session)) {model.addAttribute("g", gt.getAlls());
        return "admin/sex/listSex";
        } else {
            session.removeAttribute("user");
            return "admin/login";
        }
    }

    @RequestMapping(value = "saveSex", method = RequestMethod.POST)
    public String saveSex(Model model,HttpSession session, GioiTinh g) {
        if (g.getMaGioiTinh() == 0) {
            gt.Insert(g);
        } else {
            gt.Update(g);
        }
        return "redirect:listSex";
    }

    @RequestMapping(value = "/updateSex", method = RequestMethod.GET)
    public String updateSex(Model model,HttpSession session, int madanhmuc) {
        model.addAttribute("gt", gt.getById(madanhmuc));
        return "updateSex";
    }

    
}
