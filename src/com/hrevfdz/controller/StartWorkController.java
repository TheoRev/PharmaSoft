package com.hrevfdz.controller;

import com.hrevfdz.dao.PaymentsDAO;
import com.hrevfdz.dao.SaleDAO;
import com.hrevfdz.dao.StartWorkDAO;
import com.hrevfdz.dao.UsersDAO;
import com.hrevfdz.model.StartWork;
import com.hrevfdz.model.Users;
import com.hrevfdz.service.IPharmacy;
import com.hrevfdz.util.MessagesUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class StartWorkController extends PharmaSoftController {

    private List<StartWork> startWorks;
    private StartWork startWork;
    private List<Users> usuarios;
    private Users user;

    SimpleDateFormat sdf;

    public boolean doCreate(Users u, StartWork sw) {
        IPharmacy<StartWork> dao = new StartWorkDAO();

        try {

            IPharmacy<Users> daoUs = new UsersDAO();
            String query = "SELECT u FROM Users u WHERE u.username = '" + u.getUsername() + "' AND u.password = '" + u.getPassword() + "'";
            Users us = daoUs.findBy(query);

            sw.setUserId(us);
            boolean result = dao.Create(sw);

            if (result) {
                JOptionPane.showMessageDialog(null, MessagesUtil.SAVE_SUCCESS, MessagesUtil.SUCCESS_TITLE, JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, MessagesUtil.SAVE_FAIL, MessagesUtil.FAIL_TITLE, JOptionPane.WARNING_MESSAGE);
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), MessagesUtil.ERROR_TITLE, JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public void doFindAll() {
        IPharmacy<StartWork> dao = new StartWorkDAO();

        try {
            String query = "SELECT s FROM StartWork s ORDER BY s.fecha DESC";
            startWorks = dao.findByQuery(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), MessagesUtil.ERROR_SERVER_TITLE, JOptionPane.ERROR_MESSAGE);
        }
    }

    public double doGetTotal(StartWork p) {
        IPharmacy dao = null;
        sdf = new SimpleDateFormat("yyyy-MM-dd");
        double montoAct = 0;

        try {
            double totalSales;
            double totalPays;
            String q1;
            String q2;
            String q3;

            if (p == null) {
                q1 = "SELECT sw FROM StartWork sw WHERE sw.fecha = '" + sdf.format(new Date()) + "'";
                q2 = "SELECT SUM(s.subtotal) FROM Sale s WHERE s.fecha = '" + sdf.format(new Date()) + "'";
                q3 = "SELECT SUM(p.monto) FROM Payments p WHERE p.fecha = '" + sdf.format(new Date()) + "'";
            } else {
                q1 = "SELECT sw FROM StartWork sw WHERE sw.fecha = '" + sdf.format(p.getFecha()) + "'";
                q2 = "SELECT SUM(s.subtotal) FROM Sale s WHERE s.fecha = '" + sdf.format(p.getFecha()) + "'";
                q3 = "SELECT SUM(p.monto) FROM Payments p WHERE p.fecha = '" + sdf.format(p.getFecha()) + "'";
            }

            dao = (dao == null) ? new SaleDAO() : dao;
            totalSales = dao.findBy(q2) != null ? (double) dao.findBy(q2) : 0;
            dao = new PaymentsDAO();
            totalPays = dao.findBy(q3) != null ? (double) dao.findBy(q3) : 0;

            dao = new StartWorkDAO();
            startWork = (StartWork) dao.findBy(q1);
            montoAct = (startWork.getCapital() + totalSales) - totalPays;
//            startWork.setCapital(montoAct);
//            payments.setIdSw(startWork);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), MessagesUtil.ERROR_SERVER_TITLE, JOptionPane.ERROR_MESSAGE);
        }

        return montoAct;
    }

    public void doFindBy() {
        IPharmacy<StartWork> dao = new StartWorkDAO();
        sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            String query = "";
//            switch(op){
//                case 1:
//                    
//            }
            if (startWork.getFecha() != null && !startWork.getUserId().getUsername().equals("")) {
                query = "SELECT w FROM StartWork w WHERE w.fecha = '" + sdf.format(startWork.getFecha()) + "' AND w.userId.id = " + startWork.getUserId().getId();
            } else if (startWork.getFecha() != null && startWork.getUserId().getUsername().equals("")) {
                query = "SELECT w FROM StartWork w WHERE w.fecha = '" + sdf.format(startWork.getFecha()) + "'";
            } else if (startWork.getFecha() == null && !startWork.getUserId().getUsername().equals("")) {
                query = "SELECT w FROM StartWork w WHERE w.userId.id = " + startWork.getUserId().getId();
            }

            startWorks = dao.findByQuery(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), MessagesUtil.ERROR_SERVER_TITLE, JOptionPane.ERROR_MESSAGE);
        }
    }

    public void doGetAllUsers() {
        IPharmacy<Users> dao = new UsersDAO();

        try {
            String query = "SELECT u FROM Users u";
            usuarios = dao.findByQuery(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), MessagesUtil.ERROR_SERVER_TITLE, JOptionPane.ERROR_MESSAGE);
        }
    }

    public void doGetOneUser(String name) {
        IPharmacy<Users> dao = new UsersDAO();

        try {
            String query = "SELECT u FROM Users u WHERE u.username = '" + name + "'";
            user = dao.findBy(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), MessagesUtil.ERROR_SERVER_TITLE, JOptionPane.ERROR_MESSAGE);
        }
    }

    public List<StartWork> getStartWorks() {
        return startWorks;
    }

    public void setStartWorks(List<StartWork> startWorks) {
        this.startWorks = startWorks;
    }

    public StartWork getStartWork() {
        return startWork;
    }

    public void setStartWork(StartWork startWork) {
        this.startWork = startWork;
    }

    public List<Users> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Users> usuarios) {
        this.usuarios = usuarios;
    }

    public Users getUsers() {
        return user;
    }

    public void setUsers(Users user) {
        this.user = user;
    }
}
