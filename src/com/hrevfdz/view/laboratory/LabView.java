package com.hrevfdz.view.laboratory;

import com.hrevfdz.controller.LaboratoryController;
import com.hrevfdz.model.Laboratory;
import com.hrevfdz.model.Suppliers;
import com.hrevfdz.util.AccionUtil;
import com.hrevfdz.util.FramesUtil;
import com.hrevfdz.util.MessagesUtil;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class LabView extends javax.swing.JInternalFrame {

    LaboratoryController lc;
    private DefaultTableModel dtm;

    JDesktopPane container;
    private final JButton btnLab;

    public LabView(JDesktopPane container, JButton btnLab) {
        initComponents();

        this.container = container;
        this.btnLab = btnLab;

        lc = new LaboratoryController();
        lc.doListarLabs();
        lc.doLoadData(dtm, tblLabs);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNomProd = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblLabs = new javax.swing.JTable();

        setTitle("LABORATORIOS");
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

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre Prod.");

        txtNomProd.setBackground(new java.awt.Color(255, 255, 255));
        txtNomProd.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        txtNomProd.setForeground(new java.awt.Color(0, 0, 0));
        txtNomProd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        txtNomProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomProdKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNomProdKeyTyped(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(5, 67, 98));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setPreferredSize(new java.awt.Dimension(5, 0));

        btnAdd.setBackground(new java.awt.Color(5, 67, 98));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/action/add/icons8-Add List-34.png"))); // NOI18N
        btnAdd.setBorder(null);
        btnAdd.setContentAreaFilled(false);
        btnAdd.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/action/add/icons8-Add List-28.png"))); // NOI18N
        btnAdd.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/action/add/icons8-Add List-40.png"))); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(5, 67, 98));
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/action/update/icons8-Edit Property-34.png"))); // NOI18N
        btnUpdate.setBorder(null);
        btnUpdate.setContentAreaFilled(false);
        btnUpdate.setEnabled(false);
        btnUpdate.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/action/update/icons8-Edit Property-28.png"))); // NOI18N
        btnUpdate.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/action/update/icons8-Edit Property-40.png"))); // NOI18N
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(5, 67, 98));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/action/delete/icons8-Trash Can-34.png"))); // NOI18N
        btnDelete.setBorder(null);
        btnDelete.setContentAreaFilled(false);
        btnDelete.setEnabled(false);
        btnDelete.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/action/delete/icons8-Trash Can-28.png"))); // NOI18N
        btnDelete.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/action/delete/icons8-Trash Can-40.png"))); // NOI18N
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

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
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnRefresh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
            .addComponent(btnAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtNomProd, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNomProd, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(5, 67, 98));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        tblLabs.setBackground(new java.awt.Color(255, 255, 255));
        tblLabs.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        tblLabs.setForeground(new java.awt.Color(0, 0, 0));
        tblLabs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Distribuidor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLabs.setGridColor(new java.awt.Color(255, 255, 255));
        tblLabs.setSelectionBackground(new java.awt.Color(0, 153, 153));
        tblLabs.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tblLabs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLabsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblLabs);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
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
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void tblLabsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLabsMouseClicked
        getLabRow();
        FramesUtil.enablerActionButtons(btnUpdate, btnDelete, true);
    }//GEN-LAST:event_tblLabsMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        lc.doNew();
        openFrameSupp(AccionUtil.CREATE);
    }//GEN-LAST:event_btnAddActionPerformed

    private void getLabRow() {
        lc.setLaboratorio(new Laboratory());
        lc.getLaboratorio().setCodLab(Integer.parseInt(tblLabs.getValueAt(tblLabs.getSelectedRow(), 0).toString()));
        lc.getLaboratorio().setNomLab(tblLabs.getValueAt(tblLabs.getSelectedRow(), 1).toString());
        lc.getLaboratorio().setCodSupplier((Suppliers) tblLabs.getValueAt(tblLabs.getSelectedRow(), 2));
    }

    private void openFrameSupp(String accion) {
        CULabView cULabView = new CULabView(lc, this, container, tblLabs, dtm);
        cULabView.setClosable(true);
        cULabView.setTitle(accion + cULabView.getTitle());
        container.add(cULabView);
        FramesUtil.setPosition(container, cULabView);
        FramesUtil.enablerActionButtons(btnUpdate, btnDelete, false);
        cULabView.show();
        this.setVisible(false);
        if (accion.equals(AccionUtil.UPDATE)) {
            cULabView.txtCodigo.setText(lc.getLaboratorio().getCodLab().toString());
            cULabView.txtNombre.setText(lc.getLaboratorio().getNomLab());
            cULabView.txtSupplier.setText(lc.getLaboratorio().getCodSupplier().toString());
        }
    }

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            if (tblLabs.isRowSelected(tblLabs.getSelectedRow())) {
                lc.doUpgrade(lc.getLaboratorio());
                lc.setSuppliers(lc.getLaboratorio().getCodSupplier());
                openFrameSupp(AccionUtil.UPDATE);
            } else {
                JOptionPane.showMessageDialog(null, MessagesUtil.SELECTED_ROW_MSG, MessagesUtil.SELECTED_ROW_TITLE, JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), MessagesUtil.ERROR_SERVER_TITLE, JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            if (tblLabs.isRowSelected(tblLabs.getSelectedRow())) {
                getLabRow();
                if (JOptionPane.showConfirmDialog(null, "Esta seguro que de eliminar el producto: " + lc.getLaboratorio().getNomLab().toUpperCase(),
                        MessagesUtil.COMFIRM_DELETE_TITLE, JOptionPane.YES_NO_OPTION) == 0) {
                    this.lc.doDelete(lc.getLaboratorio());
                    FramesUtil.limpiarTabla(tblLabs, (DefaultTableModel) tblLabs.getModel());
                    this.lc.doLoadData(dtm, tblLabs);
                }
            } else {
                JOptionPane.showMessageDialog(null, MessagesUtil.SELECTED_ROW_MSG, MessagesUtil.SELECTED_ROW_TITLE,
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), MessagesUtil.ERROR_SERVER_TITLE, JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        btnLab.setEnabled(true);
    }//GEN-LAST:event_formInternalFrameClosing

    private void txtNomProdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomProdKeyReleased
        lc.doFindByName(txtNomProd.getText());
        FramesUtil.limpiarTabla(tblLabs, (DefaultTableModel) tblLabs.getModel());
        lc.doLoadData(dtm, tblLabs);
    }//GEN-LAST:event_txtNomProdKeyReleased

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        lc.doListarLabs();
        FramesUtil.limpiarTabla(tblLabs, (DefaultTableModel) tblLabs.getModel());
        lc.doLoadData(dtm, tblLabs);
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void txtNomProdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomProdKeyTyped
        FramesUtil.convertToMayucula(evt);
    }//GEN-LAST:event_txtNomProdKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JTable tblLabs;
    private javax.swing.JTextField txtNomProd;
    // End of variables declaration//GEN-END:variables
}
