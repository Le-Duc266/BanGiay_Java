/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao1;

import dao.HibernateUtil;
import entities.ChiTietKhuyenMai;
import entities.KhuyenMai;
import entities.SanPham;
import entities.SanPhamEntity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;

/**
 *
 * @author DELL
 */
public class KhuyenmaiDao {

    Session ss = null;

    public KhuyenmaiDao() {
//         ss = HibernateUtil.getSessionFactory().openSession();
    }

    public void Insert(KhuyenMai khuyenMai) {

        ss = HibernateUtil.getSessionFactory().openSession();
        ss.getTransaction().begin();
        ss.save(khuyenMai);
        ss.getTransaction().commit();
        ss.close();
    }

    public List<KhuyenMai> getAlls() {
        ss = HibernateUtil.getSessionFactory().openSession();
        Query q = ss.createQuery("from KhuyenMai");
        List<KhuyenMai> dm = q.list();
        ss.close();
        return dm;
    }


    public List<SanPham> getByIdDanhMuc(int maSanPham, Date thoigianbatdau) {
        ss = HibernateUtil.getSessionFactory().openSession();
        String q1 = "select s.* FROM SanPham s,ChiTietKhuyenMai c, KhuyenMai k,DanhMucSanPham d where c.maKhuyenMai = k.maKhuyenMai and c.maSanPham=s.maSanPham and s.maDanhMuc=d.maDanhMuc and c.maSanPham=:maSanPham and k.thoiGianKetThuc>:thoigianbatdau";
        SQLQuery q = ss.createSQLQuery(q1);
        q.setParameter("maSanPham", maSanPham);
        q.setParameter("thoigianbatdau", thoigianbatdau);
        
        List<SanPham> result = q.addEntity(SanPham.class).list();
        ss.close();
        return result;
    }

    public KhuyenMai getById(int maKhuyenMai) {
        ss = HibernateUtil.getSessionFactory().openSession();
        return (KhuyenMai) ss.get(KhuyenMai.class, maKhuyenMai);
    }

    public boolean delete(int id) {
        ss = HibernateUtil.getSessionFactory().openSession();
        ss.beginTransaction();
        KhuyenMai p = (KhuyenMai) ss.get(KhuyenMai.class, id);
        ss.delete(p);
        ss.getTransaction().commit();
        ss.close();
        return true;
    }
    public void Update(KhuyenMai khuyenMai) {
        ss = HibernateUtil.getSessionFactory().openSession();
        ss.getTransaction().begin();
        ss.update(khuyenMai);
        ss.getTransaction().commit();
    }
}
