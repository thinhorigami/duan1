/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;


import Domainmodel.KhuyenMai;
import Utilities.hibernateConfig;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class KhuyenMaiRepository {

    Session session = hibernateConfig.getFACTORY().openSession();

    public ArrayList<KhuyenMai> getList() {
        Query q = session.createQuery("From KhuyenMai");// truy vấn trên entity(HQL)
        ArrayList<KhuyenMai> list = (ArrayList<KhuyenMai>) q.getResultList();
        return list;
    }

    public Boolean add(KhuyenMai khuyenMai) {
        Transaction transaction = null;
        try (Session session = hibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(khuyenMai);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    public KhuyenMai getOne(String id) {
        KhuyenMai khuyenMai = null;
        try (Session session = hibernateConfig.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM KhuyenMai WHERE id=:id", KhuyenMai.class);
            query.setParameter("id", id);
            khuyenMai = (KhuyenMai) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return khuyenMai;
    }
    
    public boolean delete(KhuyenMai km) {
        Transaction transaction = null;
        try (Session session = hibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(km);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }
    
    public Boolean update(KhuyenMai km) {
        Transaction transaction = null;
        try (Session session = hibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(km);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return false;
        }
        
    }
}
