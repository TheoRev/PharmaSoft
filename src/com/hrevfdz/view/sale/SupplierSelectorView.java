package com.hrevfdz.view.sale;

import com.hrevfdz.controller.LaboratoryController;
import com.hrevfdz.model.Suppliers;
import com.hrevfdz.util.MessagesUtil;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class SupplierSelectorView extends javax.swing.JInternalFrame {
    
    LaboratoryController lc;
    JDesktopPane container;
    JTextField txtSupp;
    
    DefaultTableModel dtm;
    
    public SupplierSelectorView(LaboratoryController lc, JDesktopPane container, JTextField txtSupp) {
        initComponents();
        
        this.lc = lc;
        this.container = container;
        this.txtSupp = txtSupp;
        
        loadSuppliers();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNomLab = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSuppliers = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(5, 67, 98));

        jPanel2.setBackground(new java.awt.Color(5, 67, 98));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jPanel2.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre");

        txtNomLab.setBackground(new java.awt.Color(255, 255, 255));
        txtNomLab.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        txtNomLab.setForeground(new java.awt.Color(0, 0, 0));

        btnAceptar.setBackground(new java.awt.Color(255, 255, 102));
        btnAceptar.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnAceptar.setForeground(new java.awt.Color(52, 152, 219));
        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/action/comfirm/icons8-Ok-24.png"))); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(52, 152, 219), 2, true));
        btnAceptar.setEnabled(false);
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNomLab, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNomLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(5, 67, 98));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));

        tblSuppliers.setBackground(new java.awt.Color(255, 255, 255));
        tblSuppliers.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        tblSuppliers.setForeground(new java.awt.Color(0, 0, 0));
        tblSuppliers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre Dist.", "Encargado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSuppliers.setGridColor(new java.awt.Color(255, 255, 255));
        tblSuppliers.setSelectionBackground(new java.awt.Color(0, 153, 153));
        tblSuppliers.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tblSuppliers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSuppliersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSuppliers);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if (tblSuppliers.isRowSelected(tblSuppliers.getSelectedRow())) {
            lc.doGetSuplierByCod(lc.getSuppliers().getCodigo());
            this.txtSupp.setText(lc.getSuppliers().getNombre());
            this.hide();
        } else {
            JOptionPane.showMessageDialog(null, MessagesUtil.SELECTED_ROW_MSG, MessagesUtil.SELECTED_ROW_TITLE, JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void tblSuppliersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSuppliersMouseClicked
        //        try {
        btnAceptar.setEnabled(true);
        lc.setSuppliers(new Suppliers());
        lc.getSuppliers().setCodigo(Integer.parseInt(tblSuppliers.getValueAt(tblSuppliers.getSelectedRow(), 0).toString()));
        lc.getSuppliers().setNombre(tblSuppliers.getValueAt(tblSuppliers.getSelectedRow(), 1).toString());
        lc.getSuppliers().setEncargado(tblSuppliers.getValueAt(tblSuppliers.getSelectedRow(), 2).toString());
        //        } catch (Exception ex) {
        //            JOptionPane.showMessageDialog(null, ex.getMessage(), MessagesUtil.ERROR_SERVER_TITLE, JOptionPane.ERROR_MESSAGE);
        //        }
    }//GEN-LAST:event_tblSuppliersMouseClicked
    
    private void loadSuppliers() {
        dtm = (DefaultTableModel) tblSuppliers.getModel();
        lc.doListSuppliers();
        
        lc.getSupplierses().stream().map((s) -> {
            Object[] row = new Object[3];
            row[0] = s.getCodigo();
            row[1] = s.getNombre();
            row[2] = s.getEncargado();
            return row;
        }).forEachOrdered((row) -> {
            dtm.addRow(row);
        });
        tblSuppliers.setModel(dtm);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tblSuppliers;
    private javax.swing.JTextField txtNomLab;
    // End of variables declaration//GEN-END:variables
}
