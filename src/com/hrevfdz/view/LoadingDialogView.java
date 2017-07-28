package com.hrevfdz.view;

import java.awt.Color;
import javax.swing.UIManager;

public final class LoadingDialogView extends javax.swing.JFrame {

    public LoadingDialogView() {
        super();
        initComponents();

        setLocationRelativeTo(null);
        loading();
    }

    private void loading() {
        new Thread(new Progreso()).start();
    }

    public class Progreso implements Runnable {

        @Override
        public void run() {
//            UIManager.put("pbLoadPharmaSoft.background", Color.RGBtoHSB(0, 153, 153, null));
            int n = 0;

            for (int i = 1; i <= 100; i++) {
                pbLoadPharmaSoft.setValue(i);
                pbLoadPharmaSoft.repaint();
                n = pbLoadPharmaSoft.getValue();
//                System.out.println("n: " + n);

                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                }

                if (pbLoadPharmaSoft.getValue() == 100) {
                    HomeView principal = new HomeView();
                    principal.setVisible(true);
                    LoadingDialogView.this.dispose();
                }
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pbLoadPharmaSoft = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        pbLoadPharmaSoft.setBackground(new java.awt.Color(0, 153, 153));
        pbLoadPharmaSoft.setForeground(new java.awt.Color(0, 102, 255));
        pbLoadPharmaSoft.setBorder(null);
        pbLoadPharmaSoft.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        pbLoadPharmaSoft.setOpaque(false);
        pbLoadPharmaSoft.setStringPainted(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pbLoadPharmaSoft, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pbLoadPharmaSoft, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(LoadingDialogView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoadingDialogView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoadingDialogView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoadingDialogView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LoadingDialogView dialog = new LoadingDialogView();
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar pbLoadPharmaSoft;
    // End of variables declaration//GEN-END:variables
}
