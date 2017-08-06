package com.hrevfdz.controller;

import com.hrevfdz.dao.StartWorkDAO;
import com.hrevfdz.dao.UsersDAO;
import com.hrevfdz.model.StartWork;
import com.hrevfdz.model.Users;
import com.hrevfdz.service.IPharmacy;
import com.hrevfdz.util.MessagesUtil;
import javax.swing.JOptionPane;

public class StartWorkController extends PharmaSoftController{

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
}
