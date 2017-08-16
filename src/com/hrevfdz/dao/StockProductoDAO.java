package com.hrevfdz.dao;

import java.util.List;

import com.hrevfdz.model.StockProducto;
import com.hrevfdz.service.PharmacyConexion;
import com.hrevfdz.service.PharmacyService;
import javax.persistence.Query;

public class StockProductoDAO extends PharmacyService<StockProducto> {

    public StockProductoDAO() {
        super(StockProducto.class);
    }

    @Override
    public boolean Create(StockProducto t) throws Exception {
        return super.Create(t);
    }

    @Override
    public boolean Update(StockProducto t) throws Exception {
        return super.Update(t);
    }

    @Override
    public boolean Delete(StockProducto t) throws Exception {
        return super.Delete(t);
    }

    @Override
    public List<StockProducto> findAll() throws Exception {
        super.setCod("codStock");
        return super.findAll();
    }

    @Override
    public StockProducto findBy(String q) throws Exception {
        return super.findBy(q);
    }

    @Override
    public List<StockProducto> findByQuery(String q) throws Exception {
        return super.findByQuery(q);
    }

    @Override
    public List<StockProducto> findByNativeQuery(String nq) throws Exception {
        return super.findByNativeQuery(nq);
    }

    public int findGetCod() throws Exception {
        int end = 0;

        try {
            em = PharmacyConexion.getInstance().getFactory().createEntityManager();
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT MAX(st.codStock) FROM StockProducto st");
            end = (int) query.getSingleResult();
            em.close();
        } catch (Exception e) {
            throw e;
        }

        return end;
    }

    public List<StockProducto> doFindByName(String name) {
        List<StockProducto> lista = null;

        try {
            em = PharmacyConexion.getInstance().getFactory().createEntityManager();
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT s FROM StockProducto s WHERE s.nombre LIKE :name AND s.state = TRUE");
            query.setParameter("name", name + "%");
            lista = query.getResultList();
            em.close();
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

    public List<StockProducto> doFindByNameLab(String lab) {
        List<StockProducto> lista = null;

        try {
            em = PharmacyConexion.getInstance().getFactory().createEntityManager();
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT s FROM StockProducto s WHERE s.codLab.nomLab LIKE :lab and s.state = TRUE");
            query.setParameter("lab", lab + "%");
            lista = query.getResultList();
            em.close();
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }
}
