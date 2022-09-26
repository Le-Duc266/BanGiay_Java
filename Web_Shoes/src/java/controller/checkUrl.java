/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao1.NhanvienDao;
import entities.NhanVien;
import javax.servlet.http.HttpSession;


/**
 *
 * @author DELL
 */
public class checkUrl {
    private NhanvienDao nhanviendao;

    public checkUrl() {
        nhanviendao = new NhanvienDao();

    }
    public boolean check(HttpSession session){
         String name=(String) session.getAttribute("user");
           NhanVien nhanvien=nhanviendao.checkName(name);
        if(session.getAttribute("user") != null && nhanvien.getMaChucVu().getMaChucVu()==1){
            return true;
        }else {
            return false;
        }
    }
}
