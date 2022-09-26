/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao1;

import dao.HibernateUtil;
import entities.MauSanPham;
import entities.SanPham;
import entities.SizeSanPham;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
    public MauSanPham getByIdMau(int maMau) {
        MauSanPham product = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            product = (MauSanPham) session
                    .createQuery("from MauSanPham where maMau=:maMau").setParameter("maMau", maMau).uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            product = null;
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return product;
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
    }

    public void Update(MauSanPham ms) {
        ss = HibernateUtil.getSessionFactory().openSession();
        ss.getTransaction().begin();
        ss.update(ms);
        ss.getTransaction().commit();
    }

    public void Delete(int id) {
        ss = HibernateUtil.getSessionFactory().openSession();
        MauSanPham ms = getById(id);
        ss.getTransaction().begin();
        ss.delete(ms);
        ss.getTransaction().commit();
    }

}
