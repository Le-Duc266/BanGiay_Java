/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao1.NhanvienDao;
import entities.ChucVu;
import org.springframework.stereotype.Controller;
import entities.NhanVien;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author DELL
 */
@Controller
@RequestMapping(value = "admin")
public class LoginBackendController {

    private NhanvienDao nhanviendao;

    public LoginBackendController() {
        nhanviendao = new NhanvienDao();

    }

    @RequestMapping(value = "/login")
    public String initBackendLogin() {
        return "admin/login";
    }

    @RequestMapping(value = "/backendLogin")
    public String loginBackend(NhanVien nhanvien, ModelMap mm, HttpSession session) {
        boolean result = false;
        
        result = nhanviendao.loginStudent(nhanvien);
        

        if (result) {

            session.setAttribute("user", nhanvien.getTenDangNhap());
            String name = (String) session.getAttribute("user");

            nhanvien = nhanviendao.checkName(name);
          
            if (nhanvien.getMaChucVu().getMaChucVu()== 1) {
                return "redirect: index";
            } else {
                mm.put("message", "không có quyền.");
                return "admin/login";
            }

        } else {
            mm.put("message", "Sai thông tin đăng nhập.");
            return "admin/login";
        }
    }

    @RequestMapping(value = "/backendSigup", method = RequestMethod.POST)
    public String backendSigup(ModelMap mm,NhanVien nhanvien) {
       
               
               boolean result=nhanviendao.Insert(nhanvien);
                
               
                if(result){
                     mm.put("success", "tạo tài khoản thành công");
                   
                }else{
                    mm.put("error", "tạo tài khoản thất bại");
                     
                }
            
        return "admin/login";
    }

    @RequestMapping(value = "/logoutBackend")
    public String logoutBackend( HttpSession session, ModelMap mm, HttpServletRequest request) {

        if (session.getAttribute("user") != null) {
            session.removeAttribute("user");
        }
        return "admin/login";
    }
    
}
