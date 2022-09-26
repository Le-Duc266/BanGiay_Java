/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Banner;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Admin
 */
public class BannerDAO {
    Session ss = null;

    public BannerDAO() {
    }
    
    public List<Banner> getAlls() {
        ss = HibernateUtil.getSessionFactory().openSession();
        Query q = ss.createQuery("from Banner");
        List<Banner> b = q.list();
        ss.close();
        return b;
    }

    public Banner getById(int maBanner) {
        ss = HibernateUtil.getSessionFactory().openSession();
        return (Banner) ss.get(Banner.class, maBanner);
    }

    public void Insert(Banner bn) {
        ss = HibernateUtil.getSessionFactory().openSession();
        ss.getTransaction().begin();
        ss.save(bn);
        ss.getTransaction().commit();
    }
    public void Update(Banner bn) {
        ss = HibernateUtil.getSessionFactory().openSession();
        ss.getTransaction().begin();
        ss.update(bn);
        ss.getTransaction().commit();
    }

    public void Delete(int id) {
        ss = HibernateUtil.getSessionFactory().openSession();
        Banner bnsp = getById(id);
        ss.getTransaction().begin();
        ss.delete(bnsp);
        ss.getTransaction().commit();
    }
}
