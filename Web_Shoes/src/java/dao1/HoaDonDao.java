/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao1;

import dao.HibernateUtil;
import entities.ChiTietHoaDon;
import entities.ChiTietHoaDonPK;
import entities.HoaDon;
import entities.SanPham;
import entities.SoLuongSanPham;
import entities.SoLuongSanPhamPK;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author DELL
 */
public class HoaDonDao {

    Session ss = null;

    public HoaDonDao() {
//         ss = HibernateUtil.getSessionFactory().openSession();
    }
     public List<HoaDon> getAlls() {
         ss = HibernateUtil.getSessionFactory().openSession();
        Query q = ss.createQuery("from HoaDon where tinhTrang=1");
        List<HoaDon> dm = q.list();
        ss.close();
        return dm;
    }
     public List<HoaDon> getHoadonDaDuyet() {
         ss = HibernateUtil.getSessionFactory().openSession();
        Query q = ss.createQuery("from HoaDon where tinhTrang=2");
        List<HoaDon> dm = q.list();
        ss.close();
        return dm;
    }
    public List<HoaDon> getHoadonDangGiao() {
         ss = HibernateUtil.getSessionFactory().openSession();
        Query q = ss.createQuery("from HoaDon where tinhTrang=3");
        List<HoaDon> dm = q.list();
        ss.close();
        return dm;
    }
    public List<HoaDon> getHoadonDaGiao() {
         ss = HibernateUtil.getSessionFactory().openSession();
        Query q = ss.createQuery("from HoaDon where tinhTrang=4");
        List<HoaDon> dm = q.list();
        ss.close();
        return dm;
    }
    public List<HoaDon> getHoadonDaHuy() {
         ss = HibernateUtil.getSessionFactory().openSession();
        Query q = ss.createQuery("from HoaDon where tinhTrang=0");
        List<HoaDon> dm = q.list();
        ss.close();
        return dm;
    }
    
    public int getMaHoaDon() {
        ss = HibernateUtil.getSessionFactory().openSession();
        SQLQuery query = ss.createSQLQuery("SELECT IDENT_CURRENT('HoaDon')");
        int results = Integer.parseInt(query.uniqueResult().toString());
        ss.close();
        return results;
    }
    public HoaDon detail(int maHoaDon) {
        HoaDon products = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query q = session
                    .createQuery("from HoaDon where  maHoaDon=:maHoaDon");
            q.setParameter("maHoaDon", maHoaDon);
            products = (HoaDon) q.uniqueResult();
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

    public HoaDon getById(int maHoaDon) {
        ss = HibernateUtil.getSessionFactory().openSession();
        return (HoaDon) ss.get(HoaDon.class, maHoaDon);
    }

    public int getLatestDonHang() {
        ss = HibernateUtil.getSessionFactory().openSession();
        Query q = ss.createQuery("select maHoaDon from HoaDon order by maHoaDon desc");
        int maHoaDon = (int) q.list().get(0);
        ss.close();
       
        return maHoaDon;
    }
     public int getIdAnhMoiNhat() {
        ss = HibernateUtil.getSessionFactory().openSession();
        SQLQuery query = ss.createSQLQuery("SELECT IDENT_CURRENT('HoaDon')");
        int results = Integer.parseInt(query.uniqueResult().toString());
        ss.close();
        return results;
    }
     
    public void Insert(HoaDon sp) {
        ss = HibernateUtil.getSessionFactory().openSession();
        ss.getTransaction().begin();
        ss.save(sp);
        ss.getTransaction().commit();
    }

    public boolean Insertchitiet(ChiTietHoaDon sp) {
        ss = HibernateUtil.getSessionFactory().openSession();
        ss.getTransaction().begin();
        ChiTietHoaDonPK id = (ChiTietHoaDonPK) ss.save(sp);
        ss.getTransaction().commit();
        ss.close();
        if (null != id) {
            return true;
        } else {
            return false;
        }

    }
public void UpdateSoLuong(SoLuongSanPham s) {
        ss = HibernateUtil.getSessionFactory().openSession();
        ss.getTransaction().begin();
        ss.update(s);
        ss.getTransaction().commit();
    }

    public void Update(HoaDon s) {
        ss = HibernateUtil.getSessionFactory().openSession();
        ss.getTransaction().begin();
        ss.update(s);
        ss.getTransaction().commit();
        
    }
    public boolean UpdateStatus(HoaDon s) {
        ss = HibernateUtil.getSessionFactory().openSession();
        ss.getTransaction().begin();
        ss.update(s);
        ss.getTransaction().commit();
       
        return true;
    }
    public void Delete(int id) {
        ss = HibernateUtil.getSessionFactory().openSession();
        HoaDon kt = getById(id);
        ss.getTransaction().begin();
        ss.delete(kt);
        ss.getTransaction().commit();
    }
}
