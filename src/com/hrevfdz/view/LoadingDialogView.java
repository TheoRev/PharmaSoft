package com.hrevfdz.view;

import com.hrevfdz.model.Users;
import com.hrevfdz.util.FramesUtil;
import java.awt.Color;

public final class LoadingDialogView extends javax.swing.JFrame {
    
    Users users;
    
    public LoadingDialogView(Users users) {
        super();
        initComponents();
        this.users = users;
        
        
        FramesUtil.setIcon(this);
        
        setLocationRelativeTo(null);
        loading();
    }
    
    private void loading() {
        new Thread(new Progreso(this.users)).start();
    }
    
    public class Progreso implements Runnable {
        
        Users users1;
        
        public Progreso(Users users1) {
            this.users1 = users1;
        }
        
        @Override
        public void run() {
//            UIManager.put("pbLoadPharmaSoft.background", Color.RGBtoHSB(0, 153, 153, null));
            int n = 0;
            
            for (int i = 1; i <= 100; i++) {
                pbLoadPharmaSoft.setValue(i);
                pbLoadPharmaSoft.repaint();
                n = pbLoadPharmaSoft.getValue();
//                System.out.println("n: " + n);

                if (i == 50) {
                    pbLoadPharmaSoft.setForeground(Color.WHITE);
                }
                
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                }
                
                if (pbLoadPharmaSoft.getValue() == 100) {
                    HomeView principal = new HomeView(this.users1);
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
        pbLoadPharmaSoft.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        pbLoadPharmaSoft.setForeground(new java.awt.Color(51, 51, 51));
        pbLoadPharmaSoft.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 255), 2));
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar pbLoadPharmaSoft;
    // End of variables declaration//GEN-END:variables
}
