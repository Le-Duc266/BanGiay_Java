/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.SanPham;
import entities.joins.SanPhamJoin;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**
 *
 * @author PC
 */
public class SanPhamDAO {

    Session ss = null;

    public SanPhamDAO() {
    }

    public List<SanPham> getAlls() {
        ss = HibernateUtil.getSessionFactory().openSession();
        Query q = ss.createQuery("from SanPham");
        List<SanPham> kt = q.list();
        ss.close();
        return kt;
    }

    public List<SanPhamJoin> getAllSanPhamJoins() {
        ss = HibernateUtil.getSessionFactory().openSession();
        SQLQuery query = ss.createSQLQuery("Select s.*, d.TenDanhMuc ,n.TenNhanHang ,g.TenGioiTinh from sanpham s "
                + "INNER JOIN DanhMucSanPham d ON s.MaDanhMuc = d.MaDanhMuc "
                + "INNER JOIN NhanHang n ON s.MaNhanHang = n.MaNhanHang "
                + "INNER JOIN GioiTinh g ON s.MaGioiTinh = g.MaGioiTinh");
        query.addEntity(SanPhamJoin.class);
        List results = query.list();
        ss.close();
        return results;
    }

    public SanPham getById(int maSanPham) {
        ss = HibernateUtil.getSessionFactory().openSession();
        return (SanPham) ss.get(SanPham.class, maSanPham);
    }
    
    public SanPhamJoin getById2(int maSanPham) {
        ss = HibernateUtil.getSessionFactory().openSession();
        SQLQuery query = ss.createSQLQuery("Select s.*, d.TenDanhMuc ,n.TenNhanHang ,g.TenGioiTinh from sanpham s "
                + "INNER JOIN DanhMucSanPham d ON s.MaDanhMuc = d.MaDanhMuc "
                + "INNER JOIN NhanHang n ON s.MaNhanHang = n.MaNhanHang "
                + "INNER JOIN GioiTinh g ON s.MaGioiTinh = g.MaGioiTinh "
                + "where s.maSanPham = :maSanPham");
        query.addEntity(SanPhamJoin.class);
        query.setParameter("maSanPham", maSanPham);
        SanPhamJoin results = (SanPhamJoin) query.uniqueResult();
        ss.close();
        return results;
    }

    public void Insert(SanPham sp) {
        ss = HibernateUtil.getSessionFactory().openSession();
        ss.getTransaction().begin();
        ss.save(sp);
        ss.getTransaction().commit();
        ss.close();
    }

    public void Update(SanPham s) {
        ss = HibernateUtil.getSessionFactory().openSession();
        ss.getTransaction().begin();
        ss.update(s);
        ss.getTransaction().commit();
    }

    public void Delete(int id) {
        ss = HibernateUtil.getSessionFactory().openSession();
        SanPham kt = getById(id);
        ss.getTransaction().begin();
        ss.delete(kt);
        ss.getTransaction().commit();
    }

    public int getSPMoi() {
        ss = HibernateUtil.getSessionFactory().openSession();
        Query q = ss.createQuery("FROM SanPham ORDER BY maSanPham DESC").setMaxResults(1);
        List<SanPham> result = q.list();
        SanPham result2 = (SanPham) q.uniqueResult();
        String check = "" + result2;
        int id2;
        if (!check.equals("null")) {
            id2 = result2.getMaSanPham();
        } else {
            id2 = 0;
        }
        ss.close();
        return id2;
    }

    public void Update(int maSanPham, String tenSanPham, int maDanhMuc, int maNhanHang, int maGioiTinh, String moTa) {
        ss = HibernateUtil.getSessionFactory().openSession();
        SQLQuery query = ss.createSQLQuery("UPDATE SanPham SET MaDanhMuc = :maDanhMuc ,MaNhanHang = :maNhanHang ,MaGioiTinh = :maGioiTinh,TenSanPham = :tenSanPham ,MoTa = :moTa where MaSanPham = :maSanPham ");
        query.setParameter("tenSanPham", tenSanPham);
        query.setParameter("maDanhMuc", maDanhMuc);
        query.setParameter("maNhanHang", maNhanHang);
        query.setParameter("maGioiTinh", maGioiTinh);
        query.setParameter("moTa", moTa);
        query.setParameter("maSanPham", maSanPham);
        ss.getTransaction().begin();
        query.executeUpdate();
        ss.getTransaction().commit();
        ss.close();
    }
   
}
