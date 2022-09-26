/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao1;

import dao.HibernateUtil;
import entities.DanhMucSanPham;
import entities.DanhmucEntity;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;

/**
 *
 * @author Admin
 */
public class DanhMucDAO {

    Session ss = null;

    public DanhMucDAO() {
//         ss = HibernateUtil.getSessionFactory().openSession();
    }

    public List<DanhMucSanPham> getAlls() {
         ss = HibernateUtil.getSessionFactory().openSession();
        Query q = ss.createQuery("from DanhMucSanPham");
        List<DanhMucSanPham> dm = q.list();
        ss.close();
        return dm;
    }


   

    public DanhMucSanPham getById(int maDanhMuc) {
        ss = HibernateUtil.getSessionFactory().openSession();
        return (DanhMucSanPham) ss.get(DanhMucSanPham.class, maDanhMuc);
    }

    public void Insert(DanhMucSanPham dmuc) {
        ss = HibernateUtil.getSessionFactory().openSession();
        ss.getTransaction().begin();
        ss.save(dmuc);
        ss.getTransaction().commit();
    }

    public void Update(DanhMucSanPham danhmuc) {
        ss = HibernateUtil.getSessionFactory().openSession();
        ss.getTransaction().begin();
        ss.update(danhmuc);
        ss.getTransaction().commit();
    }

    public void Delete(int id) {
        ss = HibernateUtil.getSessionFactory().openSession();
        DanhMucSanPham dmsp = getById(id);
        ss.getTransaction().begin();
        ss.delete(dmsp);
        ss.getTransaction().commit();
    }

}
