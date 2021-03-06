/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualgameoflife;

import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author alois
 */
public class Visual extends javax.swing.JFrame {
    
    static int Hauteur = 10, Largeur = 10, nbGeneration = 10;
    
    JPanel[][] grilleGraphique;
    
    World gameOfLife;
    
    public Visual(int hauteur, int largeur, int generation) {
        initComponents();
        Hauteur = hauteur;
        Largeur = largeur;
        nbGeneration = generation;
        
        gameOfLife = new World(Hauteur, Largeur);
        gameOfLife.initialisation();
        gameOfLife.afficherGrille();
        
        grilleGraphique = new JPanel[Hauteur][Largeur];
        for (int i = 0; i < Hauteur; i++) {
            for (int j = 0; j < Largeur; j++) {
                grilleGraphique[i][j] = new JPanel();
                grilleGraphique[i][j].setSize(jPanel1.getWidth() / Hauteur, jPanel1.getHeight() / Largeur);
                jPanel1.add(grilleGraphique[i][j]);
                grilleGraphique[i][j].setLocation(j * jPanel1.getWidth() / Hauteur, i * jPanel1.getHeight() / Largeur);
            }
        }
        
        Timer time = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                evolution();
            }
            
        };
        time.scheduleAtFixedRate(task, 0, 1);
        
    }
    
    private void goodDimention() {
        for (int i = 0; i < Hauteur; i++) {
            for (int j = 0; j < Largeur; j++) {
                grilleGraphique[i][j].setSize(jPanel1.getWidth() / Hauteur, jPanel1.getHeight() / Largeur);
                jPanel1.add(grilleGraphique[i][j]);
                grilleGraphique[i][j].setLocation(j * jPanel1.getWidth() / Hauteur, i * jPanel1.getHeight() / Largeur);
            }
        }
    }
    
    private void evolution() {
        javax.swing.JOptionPane.showMessageDialog(null, "Ready ?");
        for (int i = 0; i < nbGeneration; i++) {
            gameOfLife.nextGeneration(nbGeneration);
            getColor();
            
        }
        javax.swing.JOptionPane.showMessageDialog(null, "The End");
        System.exit(1);
    }
    
    private void getColor() {
        for (int i = 0; i < Hauteur; i++) {
            for (int j = 0; j < Largeur; j++) {
                if (gameOfLife.getCellState(i, j)) {
                    grilleGraphique[i][j].setBackground(Color.WHITE);
                    grilleGraphique[i][j].setBorder(BorderFactory.createLineBorder(Color.GRAY));
                } else {
                    grilleGraphique[i][j].setBackground(Color.BLACK);
                    grilleGraphique[i][j].setBorder(BorderFactory.createLineBorder(Color.GRAY));
                }
            }
        }
        jPanel1.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jPanel1ComponentResized(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 376, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 276, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel1ComponentResized
        goodDimention();
    }//GEN-LAST:event_jPanel1ComponentResized

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Visual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Visual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Visual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Visual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Visual(Hauteur, Largeur, nbGeneration).setVisible(true);
            }
            
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
