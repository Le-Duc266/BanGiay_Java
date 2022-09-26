/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.ChiTietSanPham;
import entities.ChiTietSanPhamPK;
import entities.joins.ChiTietSanPhamJoin;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**
 *
 * @author PC
 */
public class ChiTietSanPhamDAO {

    Session ss = null;

    public ChiTietSanPhamDAO() {
    }

    public List<ChiTietSanPham> getAlls() {
        ss = HibernateUtil.getSessionFactory().openSession();
        Query q = ss.createQuery("from ChiTietSanPham");
        List<ChiTietSanPham> ls = q.list();
        ss.close();
        return ls;
    }

    public List<ChiTietSanPhamJoin> listsChiTietSanPhamByMaSanPham(int maSanPham) {
        ss = HibernateUtil.getSessionFactory().openSession();
        SQLQuery query = ss.createSQLQuery(
                "Select c.*, s.TenSanPham as TenSanPham ,m.TenMau as TenMau , d.TenDanhMuc as TenDanhMuc ,n.TenNhanHang as TenNhanHang ,g.TenGioiTinh as TenGioiTinh from ChiTietSanPham c "
                + "INNER JOIN MauSanPham m ON m.MaMau = c.MaMau "
                + "INNER JOIN SanPham s ON c.MaSanPham = s.MaSanPham "
                + "INNER JOIN DanhMucSanPham d ON s.MaDanhMuc = d.MaDanhMuc "
                + "INNER JOIN NhanHang n ON s.MaNhanHang = n.MaNhanHang "
                + "INNER JOIN GioiTinh g ON s.MaGioiTinh = g.MaGioiTinh "
                + "where c.MaSanPham = :maSanPham ");
        query.addEntity(ChiTietSanPhamJoin.class);
        query.setParameter("maSanPham", maSanPham);
        List<ChiTietSanPhamJoin> results = query.list();
        ss.close();
        return results;
    }

    public List<ChiTietSanPhamJoin> listsChiTietSanPhamAdmin() {
        ss = HibernateUtil.getSessionFactory().openSession();
        SQLQuery query = ss.createSQLQuery(
                "Select c.*, s.TenSanPham as TenSanPham ,m.TenMau as TenMau , d.TenDanhMuc as TenDanhMuc ,n.TenNhanHang as TenNhanHang ,g.TenGioiTinh as TenGioiTinh from ChiTietSanPham c "
                + "INNER JOIN MauSanPham m ON m.MaMau = c.MaMau "
                + "INNER JOIN SanPham s ON c.MaSanPham = s.MaSanPham "
                + "INNER JOIN DanhMucSanPham d ON s.MaDanhMuc = d.MaDanhMuc "
                + "INNER JOIN NhanHang n ON s.MaNhanHang = n.MaNhanHang "
                + "INNER JOIN GioiTinh g ON s.MaGioiTinh = g.MaGioiTinh ");
        query.addEntity(ChiTietSanPhamJoin.class);
        List<ChiTietSanPhamJoin> results = query.list();
        ss.close();
        return results;
    }

    public ChiTietSanPham getById(ChiTietSanPhamPK ct) {
        ss = HibernateUtil.getSessionFactory().openSession();
        return (ChiTietSanPham) ss.get(ChiTietSanPham.class, ct);
    }

    public ChiTietSanPhamJoin getByIdJoins(int maSanPham, int maMau) {
        ss = HibernateUtil.getSessionFactory().openSession();
        SQLQuery query = ss.createSQLQuery("Select c.*, s.TenSanPham as TenSanPham ,m.TenMau as TenMau , d.TenDanhMuc as TenDanhMuc ,n.TenNhanHang as TenNhanHang ,g.TenGioiTinh as TenGioiTinh from ChiTietSanPham c "
                + "INNER JOIN sanpham s ON c.MaSanPham = s.MaSanPham  "
                + "INNER JOIN MauSanPham m ON c.MaMau = m.MaMau "
                + "INNER JOIN DanhMucSanPham d ON s.MaDanhMuc = d.MaDanhMuc "
                + "INNER JOIN NhanHang n ON s.MaNhanHang = n.MaNhanHang "
                + "INNER JOIN GioiTinh g ON s.MaGioiTinh = g.MaGioiTinh "
                + "where c.MaSanPham = :maSanPham and c.MaMau = :maMau ");
        query.addEntity(ChiTietSanPhamJoin.class);
        query.setParameter("maSanPham", maSanPham);
        query.setParameter("maMau", maMau);
        ChiTietSanPhamJoin results = (ChiTietSanPhamJoin) query.uniqueResult();
        ss.close();
        return results;
    }

    public void updateGiaSP(double giaTien, boolean status, int maSanPham, int maMau) {
        ss = HibernateUtil.getSessionFactory().openSession();
        SQLQuery query = ss.createSQLQuery("UPDATE ChiTietSanPham SET GiaTien = :giaTien, Status = :status where ChiTietSanPham.MaSanPham = :maSanPham and ChiTietSanPham.MaMau = :maMau ");
        query.setParameter("giaTien", giaTien);
        query.setParameter("status", status);
        query.setParameter("maSanPham", maSanPham);
        query.setParameter("maMau", maMau);
        ss.getTransaction().begin();
        query.executeUpdate();
        ss.getTransaction().commit();
        ss.close();
    }

    public void Insert(ChiTietSanPham dmuc) {
        ss = HibernateUtil.getSessionFactory().openSession();
        ss.getTransaction().begin();
        ss.save(dmuc);
        ss.getTransaction().commit();
        ss.close();
    }

    public void Update(ChiTietSanPham danhmuc) {
        ss = HibernateUtil.getSessionFactory().openSession();
        ss.getTransaction().begin();
        ss.update(danhmuc);
        ss.getTransaction().commit();
    }

//    public void Delete(int id) {
//        ss = HibernateUtil.getSessionFactory().openSession();
//        ChiTietSanPham dmsp = getById(id);
//        ss.getTransaction().begin();
//        ss.delete(dmsp);
//        ss.getTransaction().commit();
//    }
}
