package com.hrevfdz.view.suppliers;

import Atxy2k.CustomTextField.RestrictedTextField;
import com.hrevfdz.controller.SuppliersController;
import com.hrevfdz.util.FrameFunctions;
import com.hrevfdz.util.FramesUtil;
import com.hrevfdz.util.MessagesUtil;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CUSupplierView extends javax.swing.JInternalFrame implements FrameFunctions {
    
    SuppliersController suc;
    JInternalFrame iframe;
    JDesktopPane container;
    JTable tblSupp;
    DefaultTableModel dtm;
    
    public CUSupplierView(SuppliersController suc, JInternalFrame iframe, JDesktopPane container,
            JTable tblSupp, DefaultTableModel dtm) {
        initComponents();
        
        this.suc = suc;
        this.iframe = iframe;
        this.container = container;
        this.tblSupp = tblSupp;
        this.dtm = dtm;
        
        RestrictedTextField rtf = new RestrictedTextField(txtRuc);
        rtf.setLimit(11);
        rtf.setOnlyNums(true);
        RestrictedTextField r = new RestrictedTextField(txtTelefono);
        r.setOnlyNums(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtCodigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtEncargado = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtRuc = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();

        setTitle(" DISTRIBUIDOR");
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

        jPanel1.setBackground(new java.awt.Color(5, 67, 98));

        txtCodigo.setBackground(new java.awt.Color(255, 255, 255));
        txtCodigo.setForeground(new java.awt.Color(0, 0, 0));
        txtCodigo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        txtCodigo.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Código");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre *");

        txtNombre.setBackground(new java.awt.Color(255, 255, 255));
        txtNombre.setForeground(new java.awt.Color(0, 0, 0));
        txtNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        txtEncargado.setBackground(new java.awt.Color(255, 255, 255));
        txtEncargado.setForeground(new java.awt.Color(0, 0, 0));
        txtEncargado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        txtEncargado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEncargadoKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Encargado *");

        txtRuc.setBackground(new java.awt.Color(255, 255, 255));
        txtRuc.setForeground(new java.awt.Color(0, 0, 0));
        txtRuc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("RUC *");

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Teléfono *");

        txtTelefono.setBackground(new java.awt.Color(255, 255, 255));
        txtTelefono.setForeground(new java.awt.Color(0, 0, 0));
        txtTelefono.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Email");

        txtEmail.setBackground(new java.awt.Color(255, 255, 255));
        txtEmail.setForeground(new java.awt.Color(0, 0, 0));
        txtEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        btnGuardar.setBackground(new java.awt.Color(0, 102, 102));
        btnGuardar.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/action/save/icons8-Save-24.png"))); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51), 2));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre)
                            .addComponent(txtCodigo)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmail)
                            .addComponent(txtTelefono)
                            .addComponent(txtRuc)
                            .addComponent(txtEncargado))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCodigo)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNombre)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtEncargado)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTelefono)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtEmail)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtRuc)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
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

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (validarCamposVacios()) {
            JOptionPane.showMessageDialog(null, MessagesUtil.EMPTY_FIELD_MESSAGE, MessagesUtil.EMPTY_FIELD_TITLE, JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                asignarDatos();
                suc.doExecute();
                FramesUtil.limpiarTabla(tblSupp, (DefaultTableModel) tblSupp.getModel());
                suc.doFindAll();
                suc.loadData(dtm, tblSupp);
                this.dispose();
                iframe.setVisible(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), MessagesUtil.ERROR_SERVER_TITLE, JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        iframe.setVisible(true);
    }//GEN-LAST:event_formInternalFrameClosing

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        FramesUtil.convertToMayucula(evt);
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtEncargadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEncargadoKeyTyped
        FramesUtil.convertToMayucula(evt);
    }//GEN-LAST:event_txtEncargadoKeyTyped
    
    private void asignarDatos() {
        suc.getSuppliers().setNombre(txtNombre.getText());
        suc.getSuppliers().setEncargado(txtEncargado.getText());
        suc.getSuppliers().setTelefono(txtTelefono.getText());
        suc.getSuppliers().setEmail(txtEmail.getText());
        suc.getSuppliers().setRuc(txtRuc.getText());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JTextField txtCodigo;
    public javax.swing.JTextField txtEmail;
    public javax.swing.JTextField txtEncargado;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtRuc;
    public javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

    @Override
    public boolean validarCamposVacios() {
        return txtNombre.getText().isEmpty() || txtEncargado.getText().isEmpty() || txtTelefono.getText().isEmpty() || txtRuc.getText().isEmpty();
    }
}
