/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.SizeSanPham;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Admin
 */
public class KichThuocDAO {

    Session ss = null;

    public KichThuocDAO() {
    }

    public List<SizeSanPham> getAlls() {
        ss = HibernateUtil.getSessionFactory().openSession();
        Query q = ss.createQuery("from SizeSanPham");
        List<SizeSanPham> kt = q.list();
        ss.close();
        return kt;
    }

    public SizeSanPham getById(int maSize) {
        ss = HibernateUtil.getSessionFactory().openSession();
        return (SizeSanPham) ss.get(SizeSanPham.class, maSize);
    }

    public void Insert(SizeSanPham sp) {
        ss = HibernateUtil.getSessionFactory().openSession();
        ss.getTransaction().begin();
        ss.save(sp);
        ss.getTransaction().commit();
    }

    public void Update(SizeSanPham s) {
        ss = HibernateUtil.getSessionFactory().openSession();
        ss.getTransaction().begin();
        ss.update(s);
        ss.getTransaction().commit();
    }

    public void Delete(int id) {
        ss = HibernateUtil.getSessionFactory().openSession();
        SizeSanPham kt = getById(id);
        ss.getTransaction().begin();
        ss.delete(kt);
        ss.getTransaction().commit();
    }

}
