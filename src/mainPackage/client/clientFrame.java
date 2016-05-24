/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPackage.client;

import mainPackage.client.searchByIdPanel;
import mainPackage.client.searchByGenrePanel;
import mainPackage.client.searchByStatusPanel;
import mainPackage.client.searchByAuthorPanel;
import mainPackage.client.searchByTitlePanel;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;

/**
 *
 * @author Windows8.1
 */
public class clientFrame extends javax.swing.JFrame {

    /**
     * Creates new form clientFrame
     */
    public clientFrame() {
        initComponents();
        clientPanel.removeAll();
        clientPanel.setVisible(false);
        clientPanel.setLayout(new BorderLayout());
        clientPanel.add(new searchByIdPanel(), BorderLayout.CENTER);
        clientPanel.repaint();
        clientPanel.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        clientPanel = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        searchByModel = new javax.swing.JMenuItem();
        searchByType = new javax.swing.JMenuItem();
        byAuthorItem = new javax.swing.JMenuItem();
        byGenreItem = new javax.swing.JMenuItem();
        byStateMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        exitMenuItem = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        helpMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Client");
        setResizable(false);

        clientPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout clientPanelLayout = new javax.swing.GroupLayout(clientPanel);
        clientPanel.setLayout(clientPanelLayout);
        clientPanelLayout.setHorizontalGroup(
            clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 710, Short.MAX_VALUE)
        );
        clientPanelLayout.setVerticalGroup(
            clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 469, Short.MAX_VALUE)
        );

        jMenu1.setText("Books");

        searchByModel.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.ALT_MASK));
        searchByModel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mainPackage/assets/orange_search.png"))); // NOI18N
        searchByModel.setText("Search by ID");
        searchByModel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchByModelActionPerformed(evt);
            }
        });
        jMenu1.add(searchByModel);

        searchByType.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_MASK));
        searchByType.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mainPackage/assets/orange_search.png"))); // NOI18N
        searchByType.setText("Search by Title");
        searchByType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchByTypeActionPerformed(evt);
            }
        });
        jMenu1.add(searchByType);

        byAuthorItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        byAuthorItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mainPackage/assets/orange_search.png"))); // NOI18N
        byAuthorItem.setText("Search by Author");
        byAuthorItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                byAuthorItemActionPerformed(evt);
            }
        });
        jMenu1.add(byAuthorItem);

        byGenreItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.ALT_MASK));
        byGenreItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mainPackage/assets/orange_search.png"))); // NOI18N
        byGenreItem.setText("Search by Genre");
        byGenreItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                byGenreItemActionPerformed(evt);
            }
        });
        jMenu1.add(byGenreItem);

        byStateMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        byStateMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mainPackage/assets/orange_search.png"))); // NOI18N
        byStateMenuItem.setText("Search by Status");
        byStateMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                byStateMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(byStateMenuItem);
        jMenu1.add(jSeparator1);

        exitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        exitMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mainPackage/assets/system-delete-alt.png"))); // NOI18N
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(exitMenuItem);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("About");

        helpMenuItem.setText("Version");
        helpMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpMenuItemActionPerformed(evt);
            }
        });
        jMenu2.add(helpMenuItem);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(clientPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(clientPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void searchByModelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchByModelActionPerformed

        clientPanel.removeAll();
        clientPanel.setVisible(false);
        clientPanel.setLayout(new BorderLayout());
        clientPanel.add(new searchByIdPanel(), BorderLayout.CENTER);
        clientPanel.repaint();
        clientPanel.setVisible(true);

    }//GEN-LAST:event_searchByModelActionPerformed

    private void byAuthorItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_byAuthorItemActionPerformed

        clientPanel.removeAll();
        clientPanel.setVisible(false);
        clientPanel.setLayout(new BorderLayout());
        clientPanel.add(new searchByAuthorPanel(), BorderLayout.CENTER);
        clientPanel.repaint();
        clientPanel.setVisible(true);

    }//GEN-LAST:event_byAuthorItemActionPerformed

    private void searchByTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchByTypeActionPerformed

        clientPanel.removeAll();
        clientPanel.setVisible(false);
        clientPanel.setLayout(new BorderLayout());
        clientPanel.add(new searchByTitlePanel(), BorderLayout.CENTER);
        clientPanel.repaint();
        clientPanel.setVisible(true);

    }//GEN-LAST:event_searchByTypeActionPerformed

    private void byGenreItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_byGenreItemActionPerformed

        clientPanel.removeAll();
        clientPanel.setVisible(false);
        clientPanel.setLayout(new BorderLayout());
        clientPanel.add(new searchByGenrePanel(), BorderLayout.CENTER);
        clientPanel.repaint();
        clientPanel.setVisible(true);

    }//GEN-LAST:event_byGenreItemActionPerformed

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed

        System.exit(0);

    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void helpMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpMenuItemActionPerformed

        JOptionPane.showMessageDialog(
                null, 
                "Book Keeping Library System by\nKevin Arceo\nJoymee Salcedo\nJan Sarmiento\n\nVersion 1.0 - 2016",
                "Software Information",
                JOptionPane.INFORMATION_MESSAGE);
                
    }//GEN-LAST:event_helpMenuItemActionPerformed

    private void byStateMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_byStateMenuItemActionPerformed

        clientPanel.removeAll();
        clientPanel.setVisible(false);
        clientPanel.setLayout(new BorderLayout());
        clientPanel.add(new searchByStatusPanel(), BorderLayout.CENTER);
        clientPanel.repaint();
        clientPanel.setVisible(true);

    }//GEN-LAST:event_byStateMenuItemActionPerformed

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
            java.util.logging.Logger.getLogger(clientFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(clientFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(clientFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(clientFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new clientFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem byAuthorItem;
    private javax.swing.JMenuItem byGenreItem;
    private javax.swing.JMenuItem byStateMenuItem;
    private javax.swing.JPanel clientPanel;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenuItem helpMenuItem;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem searchByModel;
    private javax.swing.JMenuItem searchByType;
    // End of variables declaration//GEN-END:variables
}
