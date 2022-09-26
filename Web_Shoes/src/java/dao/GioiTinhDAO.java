/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.GioiTinh;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author PC
 */
public class GioiTinhDAO {
    Session ss = null;

    public GioiTinhDAO() {
    }

    public List<GioiTinh> getAlls() {
        ss = HibernateUtil.getSessionFactory().openSession();
        Query q = ss.createQuery("from GioiTinh");
        List<GioiTinh> dm = q.list();
        ss.close();
        return dm;
    }

    public GioiTinh getById(int maDanhMuc) {
        ss = HibernateUtil.getSessionFactory().openSession();
        return (GioiTinh) ss.get(GioiTinh.class, maDanhMuc);
    }

    public void Insert(GioiTinh dmuc) {
        ss = HibernateUtil.getSessionFactory().openSession();
        ss.getTransaction().begin();
        ss.save(dmuc);
        ss.getTransaction().commit();
    }
    public void Update(GioiTinh danhmuc) {
        ss = HibernateUtil.getSessionFactory().openSession();
        ss.getTransaction().begin();
        ss.update(danhmuc);
        ss.getTransaction().commit();
    }

    public void Delete(int id) {
        ss = HibernateUtil.getSessionFactory().openSession();
        GioiTinh dmsp = getById(id);
        ss.getTransaction().begin();
        ss.delete(dmsp);
        ss.getTransaction().commit();
    }

}
