package com.hrevfdz.view;

import com.hrevfdz.model.Users;
import com.hrevfdz.util.FramesUtil;
import com.hrevfdz.view.sale.SaleView;
import com.hrevfdz.view.stock.StockView;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.ImageIcon;

public final class HomeView extends javax.swing.JFrame {

    Users users;

    public HomeView() {
        initComponents();
        FramesUtil.setIcon(this);

        this.setExtendedState(LoadingDialogView.MAXIMIZED_BOTH);
    }

    public HomeView(Users users) {
        initComponents();
        FramesUtil.setIcon(this);

        this.users = users;
        lblUser.setText(lblUser.getText() + users.getUsername().toUpperCase());

        this.setExtendedState(LoadingDialogView.MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMainContainer = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnSale = new javax.swing.JButton();
        btnStock = new javax.swing.JButton();
        btnPays = new javax.swing.JButton();
        btnSuppliers = new javax.swing.JButton();
        btnCaja = new javax.swing.JButton();
        btnLab = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        dskContainer = new javax.swing.JDesktopPane();
        jPanel2 = new javax.swing.JPanel();
        lblUser = new javax.swing.JLabel();
        btnCerrarSesion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PharmaSoft");

        pnlMainContainer.setBackground(new java.awt.Color(36, 47, 65));

        jPanel1.setBackground(new java.awt.Color(36, 47, 65));

        btnSale.setBackground(new java.awt.Color(36, 47, 65));
        btnSale.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/sale/icons8-Shopping Cart Loaded-48.png"))); // NOI18N
        btnSale.setToolTipText("VENTA");
        btnSale.setBorder(null);
        btnSale.setBorderPainted(false);
        btnSale.setContentAreaFilled(false);
        btnSale.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/sale/icons8-Shopping Cart Loaded-40.png"))); // NOI18N
        btnSale.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/sale/icons8-Shopping Cart Loaded-56.png"))); // NOI18N
        btnSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaleActionPerformed(evt);
            }
        });

        btnStock.setBackground(new java.awt.Color(36, 47, 65));
        btnStock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/stock/icons8-Scan Stock-48.png"))); // NOI18N
        btnStock.setToolTipText("STOCK");
        btnStock.setBorder(null);
        btnStock.setBorderPainted(false);
        btnStock.setContentAreaFilled(false);
        btnStock.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/stock/icons8-Scan Stock-40.png"))); // NOI18N
        btnStock.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/stock/icons8-Scan Stock-52.png"))); // NOI18N
        btnStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStockActionPerformed(evt);
            }
        });

        btnPays.setBackground(new java.awt.Color(36, 47, 65));
        btnPays.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pay/icons8-Cash in Hand-48.png"))); // NOI18N
        btnPays.setToolTipText("PAGOS");
        btnPays.setBorder(null);
        btnPays.setBorderPainted(false);
        btnPays.setContentAreaFilled(false);
        btnPays.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pay/icons8-Cash in Hand-40.png"))); // NOI18N
        btnPays.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pay/icons8-Cash in Hand-56.png"))); // NOI18N

        btnSuppliers.setBackground(new java.awt.Color(36, 47, 65));
        btnSuppliers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/supplier/icons8-Queue-48.png"))); // NOI18N
        btnSuppliers.setToolTipText("DISTRIBUIDORES");
        btnSuppliers.setBorder(null);
        btnSuppliers.setBorderPainted(false);
        btnSuppliers.setContentAreaFilled(false);
        btnSuppliers.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/supplier/icons8-Queue-40.png"))); // NOI18N
        btnSuppliers.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/supplier/icons8-Queue-56.png"))); // NOI18N

        btnCaja.setBackground(new java.awt.Color(36, 47, 65));
        btnCaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/starter/icons8-Paper Money-48.png"))); // NOI18N
        btnCaja.setToolTipText("CAJA");
        btnCaja.setBorder(null);
        btnCaja.setBorderPainted(false);
        btnCaja.setContentAreaFilled(false);
        btnCaja.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/starter/icons8-Paper Money-40.png"))); // NOI18N
        btnCaja.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/starter/icons8-Paper Money-56.png"))); // NOI18N

        btnLab.setBackground(new java.awt.Color(36, 47, 65));
        btnLab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/lab/icons8-Test Tube-48.png"))); // NOI18N
        btnLab.setToolTipText("LABORATORIO");
        btnLab.setBorder(null);
        btnLab.setBorderPainted(false);
        btnLab.setContentAreaFilled(false);
        btnLab.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/lab/icons8-Test Tube-40.png"))); // NOI18N
        btnLab.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/lab/icons8-Test Tube-56.png"))); // NOI18N

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSale, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnStock, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
            .addComponent(btnPays, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnSuppliers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnCaja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnLab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(btnSale, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnStock, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPays, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSuppliers, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(btnLab, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(102, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(36, 47, 65));

        lblUser.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblUser.setForeground(new java.awt.Color(255, 255, 255));
        lblUser.setText("Usuario: ");

        btnCerrarSesion.setBackground(new java.awt.Color(255, 153, 153));
        btnCerrarSesion.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnCerrarSesion.setForeground(new java.awt.Color(51, 51, 51));
        btnCerrarSesion.setText("CERRAR SESION");
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCerrarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUser)
                    .addComponent(btnCerrarSesion))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dskContainer.setLayer(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout dskContainerLayout = new javax.swing.GroupLayout(dskContainer);
        dskContainer.setLayout(dskContainerLayout);
        dskContainerLayout.setHorizontalGroup(
            dskContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dskContainerLayout.createSequentialGroup()
                .addContainerGap(327, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        dskContainerLayout.setVerticalGroup(
            dskContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dskContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlMainContainerLayout = new javax.swing.GroupLayout(pnlMainContainer);
        pnlMainContainer.setLayout(pnlMainContainerLayout);
        pnlMainContainerLayout.setHorizontalGroup(
            pnlMainContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainContainerLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dskContainer))
        );
        pnlMainContainerLayout.setVerticalGroup(
            pnlMainContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(dskContainer)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMainContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMainContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaleActionPerformed
        SaleView sv = new SaleView(dskContainer);
        sv.setClosable(true);
        sv.setMaximizable(true);
        sv.setIconifiable(true);
        sv.setTitle("LISTA DE VENTAS");
        sv.setToolTipText("LISTA DE VENTAS");
        dskContainer.add(sv);
        FramesUtil.setPosition(dskContainer, sv);
        sv.show();
    }//GEN-LAST:event_btnSaleActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        LoginView loginView = new LoginView();
        loginView.show();
        this.dispose();
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStockActionPerformed
        StockView stockView = new StockView();
        stockView.setClosable(true);
        stockView.setMaximizable(true);
        stockView.setIconifiable(true);
        stockView.setTitle("PRODUCTOS EN STOCK");
        dskContainer.add(stockView);
        FramesUtil.setPosition(dskContainer, stockView);
        stockView.show();
    }//GEN-LAST:event_btnStockActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCaja;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnLab;
    private javax.swing.JButton btnPays;
    private javax.swing.JButton btnSale;
    private javax.swing.JButton btnStock;
    private javax.swing.JButton btnSuppliers;
    private javax.swing.JDesktopPane dskContainer;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPanel pnlMainContainer;
    // End of variables declaration//GEN-END:variables
}
