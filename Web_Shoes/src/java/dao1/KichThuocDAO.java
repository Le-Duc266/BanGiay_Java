/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao1;

import dao.HibernateUtil;
import entities.SizeSanPham;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
 public SizeSanPham getByIdSize(int maSize) {
        SizeSanPham product = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            product = (SizeSanPham) session
                    .createQuery("from SizeSanPham where maSize=:maSize").setParameter("maSize", maSize).uniqueResult();
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
