package com.hrevfdz.dao;

import com.hrevfdz.model.Suppliers;
import com.hrevfdz.service.PharmacyConexion;
import com.hrevfdz.service.PharmacyService;
import java.util.List;
import javax.persistence.Query;

public class SuppliersDAO extends PharmacyService<Suppliers> {

    public SuppliersDAO() {
        super(Suppliers.class);
    }

    @Override
    public List<Suppliers> findByCriteriaQuery() {
        return super.findByCriteriaQuery(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Suppliers> findByNativeQuery(String nq) throws Exception {
        return super.findByNativeQuery(nq); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Suppliers> findByQuery(String q) throws Exception {
        return super.findByQuery(q); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Suppliers findBy(String q) throws Exception {
        return super.findBy(q); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Suppliers> findAll() throws Exception {
        return super.findAll(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Delete(Suppliers t) throws Exception {
        return super.Delete(t); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Update(Suppliers t) throws Exception {
        return super.Update(t); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Create(Suppliers t) throws Exception {
        return super.Create(t); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Suppliers> findByName(String name) {
        List<Suppliers> lista = null;

        try {
            em = PharmacyConexion.getInstance().getFactory().createEntityManager();
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT s FROM Suppliers s WHERE s.nombre LIKE :name");
            query.setParameter("name", name + "%");
            lista = query.getResultList();
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }
}
