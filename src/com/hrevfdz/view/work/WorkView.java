package com.hrevfdz.view.work;

import com.hrevfdz.controller.StartWorkController;
import com.hrevfdz.model.StartWork;
import com.hrevfdz.model.Users;
import com.hrevfdz.util.FramesUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.table.DefaultTableModel;

public class WorkView extends javax.swing.JInternalFrame {

    JDesktopPane container;
    JButton btnWork;

    StartWorkController swc;
    DefaultTableModel dtm;

    public WorkView(JDesktopPane container, JButton btnWork) {
        initComponents();

        this.container = container;
        this.btnWork = btnWork;

        swc = new StartWorkController();
        swc.doFindAll();
        swc.doGetAllUsers();
        dcFecha.setDate(new Date());
        FramesUtil.limpiarTabla(tblWorks, (DefaultTableModel) tblWorks.getModel());
        loadData();
        loadUsers();
    }

    private void loadData() {
        dtm = (DefaultTableModel) tblWorks.getModel();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        swc.getStartWorks().stream().map((s) -> {
            Object[] row = new Object[5];
            row[0] = s.getId();
            row[1] = sdf.format(s.getFecha());
            row[2] = s.getCapital();
            row[3] = s.getUserId();
            row[4] = swc.doGetTotal(s);
            return row;
        }).forEachOrdered((row) -> {
            dtm.addRow(row);
        });
        tblWorks.setModel(dtm);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnRefresh = new javax.swing.JButton();
        dcFecha = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        cbUsers = new javax.swing.JComboBox<>();
        btnSearchDate = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblWorks = new javax.swing.JTable();

        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jPanel2.setBackground(new java.awt.Color(5, 67, 98));

        jPanel3.setBackground(new java.awt.Color(5, 67, 98));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Fecha");

        jPanel5.setBackground(new java.awt.Color(5, 67, 98));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));

        btnRefresh.setBackground(new java.awt.Color(5, 67, 98));
        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/action/refresh/icons8-Available Updates-34.png"))); // NOI18N
        btnRefresh.setBorder(null);
        btnRefresh.setContentAreaFilled(false);
        btnRefresh.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/action/refresh/icons8-Available Updates-28.png"))); // NOI18N
        btnRefresh.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/action/refresh/icons8-Available Updates-40.png"))); // NOI18N
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(271, 271, 271))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnRefresh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        dcFecha.setBackground(new java.awt.Color(255, 255, 255));
        dcFecha.setForeground(new java.awt.Color(0, 0, 0));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Usuario");

        cbUsers.setBackground(new java.awt.Color(255, 255, 255));
        cbUsers.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        cbUsers.setForeground(new java.awt.Color(0, 0, 0));
        cbUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbUsersActionPerformed(evt);
            }
        });

        btnSearchDate.setBackground(new java.awt.Color(5, 67, 98));
        btnSearchDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/action/search/icons8-Search-24.png"))); // NOI18N
        btnSearchDate.setBorderPainted(false);
        btnSearchDate.setContentAreaFilled(false);
        btnSearchDate.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/action/search/icons8-Search-20.png"))); // NOI18N
        btnSearchDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchDateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(dcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearchDate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel3))
                    .addComponent(cbUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(82, 82, 82)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSearchDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbUsers)
                                .addComponent(dcFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(5, 67, 98));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        tblWorks.setBackground(new java.awt.Color(255, 255, 255));
        tblWorks.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        tblWorks.setForeground(new java.awt.Color(0, 0, 0));
        tblWorks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Fecha", "Monto", "Usuario", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblWorks.setGridColor(new java.awt.Color(255, 255, 255));
        tblWorks.setSelectionBackground(new java.awt.Color(0, 153, 153));
        tblWorks.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(tblWorks);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 733, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        btnWork.setEnabled(true);
    }//GEN-LAST:event_formInternalFrameClosing

    private void btnSearchDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchDateActionPerformed
        swc.setStartWork(new StartWork());
        swc.getStartWork().setFecha(dcFecha.getDate());
        swc.setUsers(new Users());
        swc.getUsers().setUsername("");
        swc.getStartWork().setUserId(swc.getUsers());
        swc.doFindBy();
        refresh();
    }//GEN-LAST:event_btnSearchDateActionPerformed

    private void cbUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbUsersActionPerformed
        if (!cbUsers.getSelectedItem().toString().equals("Seleccione")) {
            swc.setStartWork(new StartWork());
            swc.doGetOneUser((String) cbUsers.getSelectedItem());
            swc.getStartWork().setUserId(swc.getUsers());
            swc.doFindBy();
            refresh();
        }
    }//GEN-LAST:event_cbUsersActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        swc.doFindAll();
        refresh();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void loadUsers() {
        try {
            cbUsers.addItem("Seleccione");
            swc.getUsuarios().forEach((u) -> {
                cbUsers.addItem(u.toString());
            });
        } catch (Exception e) {
            System.out.println("ERR: " + e.getMessage());
        }
    }

    private void refresh() {
        FramesUtil.limpiarTabla(tblWorks, (DefaultTableModel) tblWorks.getModel());
        loadData();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSearchDate;
    private javax.swing.JComboBox<String> cbUsers;
    private com.toedter.calendar.JDateChooser dcFecha;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable tblWorks;
    // End of variables declaration//GEN-END:variables
}
