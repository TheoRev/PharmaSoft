package com.hrevfdz.dao;

import com.hrevfdz.model.Payments;
import com.hrevfdz.service.PharmacyConexion;
import com.hrevfdz.service.PharmacyService;
import java.util.List;
import javax.persistence.Query;

public class PaymentsDAO extends PharmacyService<Payments> {

    public PaymentsDAO() {
        super(Payments.class);
    }

    @Override
    public List<Payments> findByCriteriaQuery() {
        return super.findByCriteriaQuery(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Payments> findByNativeQuery(String nq) throws Exception {
        return super.findByNativeQuery(nq); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Payments> findByQuery(String q) throws Exception {
        return super.findByQuery(q); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Payments> findAll() throws Exception {
        return super.findAll(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Delete(Payments t) throws Exception {
        return super.Delete(t); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Update(Payments t) throws Exception {
        return super.Update(t); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Create(Payments t) throws Exception {
        return super.Create(t); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Payments> findByNameProd(String name) {
        List<Payments> lista = null;
        try {
            em = PharmacyConexion.getInstance().getFactory().createEntityManager();
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT p FROM Payments p WHERE p.codStock.nombre LIKE :name");
//            Query query = em.createNativeQuery("SELECT p.* FROM pharmacy.stock_producto p \n"
//                    + "	JOIN pharmacy.stock_producto s\n"
//                    + "    ON p.cod_stock = s.cod_stock\n"
//                    + "	WHERE s.nombre ILIKE ?");
            query.setParameter("name", name + "%");
            lista = query.getResultList();
            em.close();
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

    public List<Payments> findByUsername(String name) {
        List<Payments> lista = null;
        try {
            em = PharmacyConexion.getInstance().getFactory().createEntityManager();
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT p FROM Payments p WHERE p.userId.username = :name");
            query.setParameter("name", name);
            lista = query.getResultList();
            em.close();
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

}
