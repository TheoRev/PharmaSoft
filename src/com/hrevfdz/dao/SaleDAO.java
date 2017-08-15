package com.hrevfdz.dao;

import com.hrevfdz.model.Sale;
import com.hrevfdz.service.PharmacyConexion;
import java.util.List;

import com.hrevfdz.service.PharmacyService;
import java.util.Date;
import javax.persistence.Query;

public class SaleDAO extends PharmacyService<Sale> {

    public SaleDAO() {
        super(Sale.class);
    }

    @Override
    public boolean Create(Sale t) throws Exception {
        return super.Create(t);
    }

    @Override
    public boolean Update(Sale t) throws Exception {
        return super.Update(t);
    }

    @Override
    public boolean Delete(Sale t) throws Exception {
        return super.Delete(t);
    }

    @Override
    public List<Sale> findAll() throws Exception {
        super.setCod("codSale");
        return super.findAll();
    }

//    @Override
//    public Sale findBy(String q) throws Exception {
//        return super.findBy(q);
//    }
    @Override
    public List<Sale> findByQuery(String q) throws Exception {
        return super.findByQuery(q);
    }

    @Override
    public List<Sale> findByNativeQuery(String nq) throws Exception {
        return super.findByNativeQuery(nq);
    }

    public List<Sale> findByDate(Date fecha) {
        List<Sale> lista = null;
        try {
            if (fecha != null) {
                em = PharmacyConexion.getInstance().getFactory().createEntityManager();
                em.getTransaction().begin();
                Query query = em.createQuery("SELECT s FROM Sale s WHERE s.fecha = :fecha");
                query.setParameter("fecha", fecha);
                lista = query.getResultList();
                em.close();
            }
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

    public List<Sale> findByUser(String name) {
        List<Sale> lista = null;

        try {
            em = PharmacyConexion.getInstance().getFactory().createEntityManager();
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT s FROM Sale s WHERE s.userId.username = :name");
            query.setParameter("name", name);
            lista = query.getResultList();
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

    public List<Sale> findByNameProd(String name) {
        List<Sale> lista = null;

        try {
            em = PharmacyConexion.getInstance().getFactory().createEntityManager();
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT s FROM Sale s WHERE s.codStock.nombre LIKE :name");
            query.setParameter("name", name + "%");
            lista = query.getResultList();
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

}
