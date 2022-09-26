/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao1;

import dao.HibernateUtil;
import entities.AnhSanPham;
import entities.AnhSanPhamPK;
import entities.ChiTietSanPham;
import entities.DanhMucSanPham;
import entities.KhuyenMai;
import entities.SanPham;
import entities.SanPhamEntity;
import java.util.Collection;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;

/**
 *
 * @author DELL
 */
public class SanPhamDao {

    Session ss = null;

    public SanPhamDao() {
//         ss = HibernateUtil.getSessionFactory().openSession();
    }

    

    public List<SanPham> getSanPham() {

        ss = HibernateUtil.getSessionFactory().openSession();
        Query q = ss.createQuery("from SanPham");
        List dm = q.list();
        ss.close();
        return dm;
    }

    public List<SanPham> oderById(int n) {
        List<SanPham> products = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query query = session
                    .createQuery("from SanPham s ORDER BY s.maSanPham DESC ");
            query.setMaxResults(n);
            products = query.list();
            transaction.commit();
        } catch (Exception e) {
            products = null;
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return products;

    }

    public List<SanPham> search(String name) {
        List<SanPham> products = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            products = session.createQuery("from SanPham p where p.tenSanPham like :name").setParameter("name", "%" + name + "%").list();
            transaction.commit();
        } catch (Exception e) {
            products = null;
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return products;
    }

    public List<SanPham> limit(int n) {
        List<SanPham> products = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query query = session
                    .createQuery("from SanPham");
            query.setMaxResults(n);
            products = query.list();
            transaction.commit();
        } catch (Exception e) {
            products = null;
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return products;
    }

    public List<SanPham> SanPhamLienQuan(int maSanPham, DanhMucSanPham maDanhMuc) {
        List<SanPham> products = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query q = session
                    .createQuery("from SanPham where not maSanPham=:maSanPham and  maDanhMuc=:maDanhMuc");
            q.setParameter("maSanPham", maSanPham);
            q.setParameter("maDanhMuc", maDanhMuc);
            q.setMaxResults(20);
            products = q.list();

            transaction.commit();
        } catch (Exception e) {
            products = null;
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return products;
    }

    public List<SanPham> getDanhMuc(DanhMucSanPham maDanhMuc) {
        List<SanPham> products = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            products = session
                    .createQuery("from SanPham where maDanhMuc=:maDanhMuc").setParameter("maDanhMuc", maDanhMuc).list();
            transaction.commit();
        } catch (Exception e) {
            products = null;
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return products;
    }

    public SanPham getByIdSp(int maSanPham) {
        SanPham product = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            product = (SanPham) session
                    .createQuery("from SanPham where maSanPham=:maSanPham").setParameter("maSanPham", maSanPham).uniqueResult();
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

    public List<KhuyenMai> getKhuyenMai() {

        ss = HibernateUtil.getSessionFactory().openSession();
        Query q = ss.createQuery("from KhuyenMai");
        List dm = q.list();
        ss.close();
        return dm;
    }

    public List<SanPham> getByIdDanhMuc(DanhMucSanPham maDanhMuc) {
        List<SanPham> dm = null;
        ss = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = ss.beginTransaction();
            dm = ss.createQuery("from SanPham where maDanhMuc=:maDanhMuc").setParameter("maDanhMuc", maDanhMuc)
                    .list();

            transaction.commit();

        } catch (Exception e) {
            dm = null;
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            ss.close();
        }
        return dm;
    }

   

  
    

}
