/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.SizeSanPham;
import entities.SoLuongSanPham;
import entities.joins.SoLuongSanPhamJoin;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**
 *
 * @author PC
 */
public class SoLuongSanPhamDAO {

    Session ss = null;

    public SoLuongSanPhamDAO() {
    }

    public List<SoLuongSanPham> getAlls() {
        ss = HibernateUtil.getSessionFactory().openSession();
        Query q = ss.createQuery("from SoLuongSanPham");
        List<SoLuongSanPham> dm = q.list();
        ss.close();
        return dm;
    }

    public List<SoLuongSanPhamJoin> getByChiTietSanPham(int maSanPham, int maMau) {
        ss = HibernateUtil.getSessionFactory().openSession();
        SQLQuery query = ss.createSQLQuery("Select slsp.*, sizeSP.Size from SoLuongSanPham slsp "
                + "INNER JOIN SizeSanPham sizeSP ON slsp.MaSize = sizeSP.MaSize "
                + "where slsp.MaSanPham = :maSanPham and slsp.MaMau = :maMau ");
        query.addEntity(SoLuongSanPhamJoin.class);
        query.setParameter("maSanPham", maSanPham);
        query.setParameter("maMau", maMau);
        List results = query.list();
        ss.close();
        return results;
    }
    public SoLuongSanPhamJoin getSoluong(int maSanPham, int maMau,int maSize) {
        ss = HibernateUtil.getSessionFactory().openSession();
        SQLQuery query = ss.createSQLQuery("Select asp.*, sizeSP.Size from SoLuongSanPham asp  "
                + "INNER JOIN SizeSanPham sizeSP ON asp.MaSize = sizeSP.MaSize "
                + "where  asp.MaSanPham = :maSanPham and asp.MaMau = :maMau  and asp.maSize=:maSize");
        query.addEntity(SoLuongSanPhamJoin.class);
        query.setParameter("maSanPham", maSanPham);
        query.setParameter("maMau", maMau);
        query.setParameter("maSize", maSize);
        SoLuongSanPhamJoin results = (SoLuongSanPhamJoin) query.uniqueResult();
        ss.close();
        return results;
    }
    
    public List<SizeSanPham> getSizesByChiTietSanPham(int maSanPham, int maMau) {
        ss = HibernateUtil.getSessionFactory().openSession();
        SQLQuery query = ss.createSQLQuery("select * from SizeSanPham sizes where sizes.MaSize not in "
                + "( select sl.MaSize from SoLuongSanPham sl where sl.MaSanPham = :maSanPham and sl.MaMau = :maMau) ");
        query.addEntity(SizeSanPham.class);
        query.setParameter("maSanPham", maSanPham);
        query.setParameter("maMau", maMau);
        List results = query.list();
        ss.close();
        return results;
    }

    public SoLuongSanPham getById(int maDanhMuc) {
        ss = HibernateUtil.getSessionFactory().openSession();
        return (SoLuongSanPham) ss.get(SoLuongSanPham.class, maDanhMuc);
    }

    public void Insert(SoLuongSanPham dmuc) {
        ss = HibernateUtil.getSessionFactory().openSession();
        ss.getTransaction().begin();
        ss.save(dmuc);
        ss.getTransaction().commit();
        ss.close();
    }

    public void Update(SoLuongSanPham danhmuc) {
        ss = HibernateUtil.getSessionFactory().openSession();
        ss.getTransaction().begin();
        ss.update(danhmuc);
        ss.getTransaction().commit();
    }

    public void Delete(int id) {
        ss = HibernateUtil.getSessionFactory().openSession();
        SoLuongSanPham dmsp = getById(id);
        ss.getTransaction().begin();
        ss.delete(dmsp);
        ss.getTransaction().commit();
    }
}
