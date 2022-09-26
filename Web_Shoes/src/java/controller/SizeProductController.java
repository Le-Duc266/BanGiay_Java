/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.KichThuocDAO;
import entities.DanhMucSanPham;
import entities.SizeSanPham;
import java.util.List;
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
@RequestMapping(value = "admin/size")
public class SizeProductController {
    KichThuocDAO ktd = null;
    private checkUrl c;
    public SizeProductController() {
        ktd = new KichThuocDAO();
        c = new checkUrl();
    }
    
    @RequestMapping(value = "listSize", method = RequestMethod.GET)
    public String sizeView(Model model,HttpSession session) {
        if (c.check(session)) {model.addAttribute("kt", ktd.getAlls());
        return "admin/size/listSize";} else {
            session.removeAttribute("user");
            return "admin/login";
        }
    }
    
    @RequestMapping(value = "/saveSize", method = RequestMethod.POST)
    public String saveSize(Model model,HttpSession session, SizeSanPham sp) {
        if (sp.getMaSize() == 0) {
            ktd.Insert(sp);
        } else {
            ktd.Update(sp);
        }
        return "redirect:listSize";
    }
    @RequestMapping(value = "/updateSize", method = RequestMethod.GET)
    public String updateCate(Model model,HttpSession session, int maSize) {
        model.addAttribute("dmuc", ktd.getById(maSize));
        return "update-Size";
    }
}
