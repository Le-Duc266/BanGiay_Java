/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao1.NhanvienDao;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author DELL
 */
@Controller
@RequestMapping(value = "admin/taikhoan")
public class TaiKhoanController {
    NhanvienDao bn = null;
    private checkUrl c;
    public TaiKhoanController() {
        bn = new NhanvienDao();
        c = new checkUrl();
    }
    @RequestMapping(value = "/listTaiKhoan", method = RequestMethod.GET)
    public String listTaiKhoan(Model model,HttpSession session) {
        if (c.check(session)) {model.addAttribute("bn", bn.getAlls());
        return "admin/taikhoan/listTaiKhoan";
        } else {
            session.removeAttribute("user");
            return "admin/login";
        }
    }

}
