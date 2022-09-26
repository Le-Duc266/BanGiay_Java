/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.NhanHang;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author PC
 */
public class NhanHangDAO {
    Session ss = null;

    public NhanHangDAO() {
    }

    public List<NhanHang> getAlls() {
        ss = HibernateUtil.getSessionFactory().openSession();
        Query q = ss.createQuery("from NhanHang");
        List<NhanHang> dm = q.list();
        ss.close();
        return dm;
    }

    public NhanHang getById(int maNhanHang) {
        ss = HibernateUtil.getSessionFactory().openSession();
        return (NhanHang) ss.get(NhanHang.class, maNhanHang);
    }

    public void Insert(NhanHang dmuc) {
        ss = HibernateUtil.getSessionFactory().openSession();
        ss.getTransaction().begin();
        ss.save(dmuc);
        ss.getTransaction().commit();
    }
    public void Update(NhanHang nhanhang) {
        ss = HibernateUtil.getSessionFactory().openSession();
        ss.getTransaction().begin();
        ss.update(nhanhang);
        ss.getTransaction().commit();
    }

    public void Delete(int id) {
        ss = HibernateUtil.getSessionFactory().openSession();
        NhanHang dmsp = getById(id);
        ss.getTransaction().begin();
        ss.delete(dmsp);
        ss.getTransaction().commit();
    }
}
