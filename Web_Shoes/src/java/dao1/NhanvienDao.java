/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao1;

import dao.HibernateUtil;
import entities.ChucVu;
import entities.NhanVien;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.NoResultException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author DELL
 */
public class NhanvienDao {

    Session ss;

    public NhanvienDao() {
    }

    public boolean loginStudent(NhanVien nhanVien) {

        ss = HibernateUtil.getSessionFactory().openSession();
        boolean userFound = false;

        Query query = ss.createQuery("from NhanVien n where n.tenDangNhap =? and n.matKhau = ?");
        query.setParameter(0, nhanVien.getTenDangNhap());
        query.setParameter(1, nhanVien.getMatKhau());
        List list = query.list();
        if ((list != null) && (list.size() > 0)) {

            userFound = true;
        }

        ss.close();
        return userFound;

    }

    public NhanVien checkName(String nhan) {
        ss = HibernateUtil.getSessionFactory().openSession();
        try {

            List<NhanVien> users = new ArrayList<NhanVien>();
            users = ss.createQuery("from NhanVien n where n.tenDangNhap =?")
                    .setParameter(0, nhan).list();
            if (users.size() > 0) {
                return users.get(0);
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean checkNametontai(String nhan) {

        ss = HibernateUtil.getSessionFactory().openSession();
        boolean userFound = false;

        Query query = ss.createQuery("from NhanVien n where n.tenDangNhap =?");
        query.setParameter(0, nhan);
       
        List list = query.list();
        if ((list != null) && (list.size() > 0)) {

            userFound = true;
        }

        ss.close();
        return userFound;
   
      
    }
    public boolean checkSoDTtontai(String soDT) {

        ss = HibernateUtil.getSessionFactory().openSession();
        boolean userFound = false;

        Query query = ss.createQuery("from NhanVien n where n.soDT =?");
        query.setParameter(0, soDT);
       
        List list = query.list();
        if ((list != null) && (list.size() > 0)) {

            userFound = true;
        }

        ss.close();
        return userFound;
   
      
    }
    public boolean checkEmailtontai(String email) {

        ss = HibernateUtil.getSessionFactory().openSession();
        boolean userFound = false;

        Query query = ss.createQuery("from NhanVien n where n.email =?");
        query.setParameter(0, email);
       
        List list = query.list();
        if ((list != null) && (list.size() > 0)) {

            userFound = true;
        }

        ss.close();
        return userFound;
   
      
    }
public List<NhanVien> getAlls() {
         ss = HibernateUtil.getSessionFactory().openSession();
        Query q = ss.createQuery("from NhanVien");
        List<NhanVien> dm = q.list();
        ss.close();
        return dm;
    }
    public boolean Insert(NhanVien nhanvien) {
       
        ss = HibernateUtil.getSessionFactory().openSession();
        ss.beginTransaction();
       ChucVu chucVu=new ChucVu();
       chucVu.setMaChucVu(2);
        nhanvien.setMaChucVu(chucVu);
        ss.save(nhanvien);
        ss.getTransaction().commit();
        ss.close();
        return true;
    

//        ss = HibernateUtil.getSessionFactory().openSession();
//        Transaction transaction = null;
//        try {
//            transaction = ss.beginTransaction();
//           nhanvien.setMaChucVu(2);
//            ss.save(nhanvien);
//            transaction.commit();
//            return true;
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//        } finally {
//            ss.close();
//        }
//        return false;
    }

}
