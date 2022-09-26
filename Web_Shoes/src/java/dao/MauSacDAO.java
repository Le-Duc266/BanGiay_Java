/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.MauSanPham;
import entities.SizeSanPham;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**
 *
 * @author Admin
 */
public class MauSacDAO {

    Session ss = null;

    public MauSacDAO() {
    }

    public List<MauSanPham> getAlls() {
        ss = HibernateUtil.getSessionFactory().openSession();
        Query q = ss.createQuery("from MauSanPham");
        List<MauSanPham> ms = q.list();
        ss.close();
        return ms;
    }

    public List<MauSanPham> getByDetailSanPhams(int maSanPham) {
        ss = HibernateUtil.getSessionFactory().openSession();
        SQLQuery query = ss.createSQLQuery("select * from MauSanPham m where m.MaMau not in "
                + "( select ct.MaMau from ChiTietSanPham ct where ct.MaSanPham = :maSanPham)");
        query.addEntity(MauSanPham.class);
        query.setParameter("maSanPham", maSanPham);
        List results = query.list();
        ss.close();
        return results;
    }

    public MauSanPham getById(int maMau) {
        ss = HibernateUtil.getSessionFactory().openSession();
        return (MauSanPham) ss.get(MauSanPham.class, maMau);
    }

    public void Insert(MauSanPham ms) {
        ss = HibernateUtil.getSessionFactory().openSession();
        ss.getTransaction().begin();
        ss.save(ms);
        ss.getTransaction().commit();
        ss.close();
    }

    public void Update(MauSanPham ms) {
        ss = HibernateUtil.getSessionFactory().openSession();
        ss.getTransaction().begin();
        ss.update(ms);
        ss.getTransaction().commit();
        ss.close();
    }

    public void Delete(int id) {
        ss = HibernateUtil.getSessionFactory().openSession();
        MauSanPham ms = getById(id);
        ss.getTransaction().begin();
        ss.delete(ms);
        ss.getTransaction().commit();
        ss.close();
    }

}
