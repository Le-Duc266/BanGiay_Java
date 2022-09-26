/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.joins.AnhSanPhamJoin;
import entities.AnhSanPham;
import entities.AnhSanPhamPK;
import entities.SanPham;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author PC
 */
public class AnhSanPhamDAO {

    Session ss = null;

    public List<AnhSanPhamJoin> listById(int maSanPham, int maMau) {
        ss = HibernateUtil.getSessionFactory().openSession();
        SQLQuery query = ss.createSQLQuery("Select * from AnhSanPham asp  "
                + "where asp.MaSanPham = :maSanPham and asp.MaMau = :maMau ");
        query.addEntity(AnhSanPhamJoin.class);
        query.setParameter("maSanPham", maSanPham);
        query.setParameter("maMau", maMau);
        List results = query.list();
        ss.close();
        return results;
        
    }

    public int getIdAnhMoiNhat() {
        ss = HibernateUtil.getSessionFactory().openSession();
        SQLQuery query = ss.createSQLQuery("SELECT IDENT_CURRENT('AnhSanPham')");
        int results = Integer.parseInt(query.uniqueResult().toString());
        ss.close();
        return results;
    }

    public void insertAnhSP(String linkAnh, int maSanPham, int maMau) {
        ss = HibernateUtil.getSessionFactory().openSession();
        SQLQuery query = ss.createSQLQuery("insert AnhSanPham VALUES(:linkAnh,:maSanPham,:maMau) ");
        query.setParameter("linkAnh", linkAnh);
        query.setParameter("maSanPham", maSanPham);
        query.setParameter("maMau", maMau);
        ss.getTransaction().begin();
        query.executeUpdate();
        ss.getTransaction().commit();
        ss.close();
    }

    public int kiemTraCoAnhChua(int maSanPham, int maMau) {
        ss = HibernateUtil.getSessionFactory().openSession();
        SQLQuery query = ss.createSQLQuery("SELECT COUNT(asp.MaSanPham) FROM AnhSanPham asp where asp.MaSanPham = :maSanPham and asp.MaMau = :maMau ");
        query.setParameter("maSanPham", maSanPham);
        query.setParameter("maMau", maMau);
        int results = Integer.parseInt(query.uniqueResult().toString());
        ss.close();
        return results;
    }


    public int getAnhChinh(int maSanPham, int maMau) {
        ss = HibernateUtil.getSessionFactory().openSession();
        SQLQuery query = ss.createSQLQuery("SELECT  top 1 asp.MaAnhSP FROM AnhSanPham asp where asp.MaSanPham = :maSanPham and asp.MaMau = :maMau ");
        query.setParameter("maSanPham", maSanPham);
        query.setParameter("maMau", maMau);
        int results = Integer.parseInt(query.uniqueResult().toString());
        ss.close();
        return results;
    }
    
    public void updateAnhChinh(String tenAnh, int maSanPham, int maMau) {
        ss = HibernateUtil.getSessionFactory().openSession();
        SQLQuery query = ss.createSQLQuery("UPDATE ChiTietSanPham SET AnhChinh = :tenAnh where ChiTietSanPham.MaSanPham = :maSanPham and ChiTietSanPham.MaMau = :maMau ");
        query.setParameter("tenAnh", tenAnh);
        query.setParameter("maSanPham", maSanPham);
        query.setParameter("maMau", maMau);
        ss.getTransaction().begin();
        query.executeUpdate();
        ss.getTransaction().commit();
        ss.close();
    }
    
    public void Update(AnhSanPham anhSanPham) {
        ss = HibernateUtil.getSessionFactory().openSession();
        ss.getTransaction().begin();
        ss.update(anhSanPham);
        ss.getTransaction().commit();
    }
    
    public AnhSanPhamJoin getById(int maAnhSP) {
        ss = HibernateUtil.getSessionFactory().openSession();
        SQLQuery query = ss.createSQLQuery("Select * from AnhSanPham asp  "
                + "where asp.maAnhSP = :maAnhSP ");
        query.addEntity(AnhSanPhamJoin.class);
        query.setParameter("maAnhSP", maAnhSP);
        AnhSanPhamJoin results = (AnhSanPhamJoin) query.uniqueResult();
        ss.close();
        return results;
    }
    
    public void Delete(int maAnhSP) {
        ss = HibernateUtil.getSessionFactory().openSession();
        SQLQuery query = ss.createSQLQuery("DELETE FROM AnhSanPham WHERE maAnhSP = :maAnhSP");
        query.setParameter("maAnhSP", maAnhSP);
        ss.getTransaction().begin();
        query.executeUpdate();
        ss.getTransaction().commit();
    }
}
