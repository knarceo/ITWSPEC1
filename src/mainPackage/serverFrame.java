/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPackage;

import java.awt.BorderLayout;
import javax.swing.JOptionPane;

/**
 *
 * @author Windows8.1
 */
public class serverFrame extends javax.swing.JFrame {

    /**
     * Creates new form serverFrame
     */
    public serverFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        serverPanel = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        addItem = new javax.swing.JMenuItem();
        updateItem = new javax.swing.JMenuItem();
        deleteItem = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        byIdMenuItem = new javax.swing.JMenuItem();
        byTitleMenuItem = new javax.swing.JMenuItem();
        byAuthorMenuItem = new javax.swing.JMenuItem();
        byGenreMenuItem = new javax.swing.JMenuItem();
        byStateItem = new javax.swing.JMenuItem();
        viewAllItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        exitMenuItem = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        addAccountItem = new javax.swing.JMenuItem();
        updateAccountItem = new javax.swing.JMenuItem();
        deleteAccountItem = new javax.swing.JMenuItem();
        viewAccountItem = new javax.swing.JMenuItem();
        displayAccountItem = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        helpMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin");
        setResizable(false);

        serverPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout serverPanelLayout = new javax.swing.GroupLayout(serverPanel);
        serverPanel.setLayout(serverPanelLayout);
        serverPanelLayout.setHorizontalGroup(
            serverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 710, Short.MAX_VALUE)
        );
        serverPanelLayout.setVerticalGroup(
            serverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 469, Short.MAX_VALUE)
        );

        jMenuBar1.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N

        jMenu1.setText("Cars");

        addItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK));
        addItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mainPackage/add-icon.png"))); // NOI18N
        addItem.setText("Add Car");
        addItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addItemActionPerformed(evt);
            }
        });
        jMenu1.add(addItem);

        updateItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_MASK));
        updateItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mainPackage/edit.png"))); // NOI18N
        updateItem.setText("Update Car");
        updateItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateItemActionPerformed(evt);
            }
        });
        jMenu1.add(updateItem);

        deleteItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_MASK));
        deleteItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mainPackage/delete.png"))); // NOI18N
        deleteItem.setText("Delete Car");
        deleteItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteItemActionPerformed(evt);
            }
        });
        jMenu1.add(deleteItem);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mainPackage/view.png"))); // NOI18N
        jMenu4.setText("Search Car");

        byIdMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mainPackage/view.png"))); // NOI18N
        byIdMenuItem.setText("By ID");
        byIdMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                byIdMenuItemActionPerformed(evt);
            }
        });
        jMenu4.add(byIdMenuItem);

        byTitleMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mainPackage/view.png"))); // NOI18N
        byTitleMenuItem.setText("By Title");
        byTitleMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                byTitleMenuItemActionPerformed(evt);
            }
        });
        jMenu4.add(byTitleMenuItem);

        byAuthorMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mainPackage/view.png"))); // NOI18N
        byAuthorMenuItem.setText("By Author");
        byAuthorMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                byAuthorMenuItemActionPerformed(evt);
            }
        });
        jMenu4.add(byAuthorMenuItem);

        byGenreMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mainPackage/view.png"))); // NOI18N
        byGenreMenuItem.setText("By Genre");
        byGenreMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                byGenreMenuItemActionPerformed(evt);
            }
        });
        jMenu4.add(byGenreMenuItem);

        byStateItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mainPackage/view.png"))); // NOI18N
        byStateItem.setText("By State");
        byStateItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                byStateItemActionPerformed(evt);
            }
        });
        jMenu4.add(byStateItem);

        jMenu1.add(jMenu4);

        viewAllItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        viewAllItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mainPackage/viewAll.png"))); // NOI18N
        viewAllItem.setText("View All Car");
        viewAllItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAllItemActionPerformed(evt);
            }
        });
        jMenu1.add(viewAllItem);
        jMenu1.add(jSeparator1);

        exitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        exitMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mainPackage/exit.jpg"))); // NOI18N
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(exitMenuItem);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Accounts");

        addAccountItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        addAccountItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mainPackage/add-icon.png"))); // NOI18N
        addAccountItem.setText("Add Account");
        addAccountItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAccountItemActionPerformed(evt);
            }
        });
        jMenu2.add(addAccountItem);

        updateAccountItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        updateAccountItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mainPackage/edit.png"))); // NOI18N
        updateAccountItem.setText("Update Account");
        updateAccountItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateAccountItemActionPerformed(evt);
            }
        });
        jMenu2.add(updateAccountItem);

        deleteAccountItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        deleteAccountItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mainPackage/delete.png"))); // NOI18N
        deleteAccountItem.setText("Delete Account");
        deleteAccountItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteAccountItemActionPerformed(evt);
            }
        });
        jMenu2.add(deleteAccountItem);

        viewAccountItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        viewAccountItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mainPackage/view.png"))); // NOI18N
        viewAccountItem.setText("View Account");
        viewAccountItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAccountItemActionPerformed(evt);
            }
        });
        jMenu2.add(viewAccountItem);

        displayAccountItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        displayAccountItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mainPackage/viewAll.png"))); // NOI18N
        displayAccountItem.setText("View All Account");
        displayAccountItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayAccountItemActionPerformed(evt);
            }
        });
        jMenu2.add(displayAccountItem);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("About");

        helpMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mainPackage/about.png"))); // NOI18N
        helpMenuItem.setText("Help");
        helpMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpMenuItemActionPerformed(evt);
            }
        });
        jMenu3.add(helpMenuItem);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(serverPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(serverPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addItemActionPerformed

        serverPanel.removeAll();
        serverPanel.setVisible(false);
        serverPanel.setLayout(new BorderLayout());
        serverPanel.add(new addPanel(), BorderLayout.CENTER);
        serverPanel.repaint();
        serverPanel.setVisible(true);

    }//GEN-LAST:event_addItemActionPerformed

    private void viewAllItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAllItemActionPerformed

        serverPanel.removeAll();
        serverPanel.setVisible(false);
        serverPanel.setLayout(new BorderLayout());
        serverPanel.add(new displayPanel(), BorderLayout.CENTER);
        serverPanel.repaint();
        serverPanel.setVisible(true);

    }//GEN-LAST:event_viewAllItemActionPerformed

    private void updateItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateItemActionPerformed
        // TODO add your handling code here:
        serverPanel.removeAll();
        serverPanel.setVisible(false);
        serverPanel.setLayout(new BorderLayout());
        serverPanel.add(new updatePanel(), BorderLayout.CENTER);
        serverPanel.repaint();
        serverPanel.setVisible(true);
    }//GEN-LAST:event_updateItemActionPerformed

    private void deleteItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteItemActionPerformed

        serverPanel.removeAll();
        serverPanel.setVisible(false);
        serverPanel.setLayout(new BorderLayout());
        serverPanel.add(new deletePanel(), BorderLayout.CENTER);
        serverPanel.repaint();
        serverPanel.setVisible(true);

    }//GEN-LAST:event_deleteItemActionPerformed

    private void deleteAccountItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteAccountItemActionPerformed

        serverPanel.removeAll();
        serverPanel.setVisible(false);
        serverPanel.setLayout(new BorderLayout());
        serverPanel.add(new deleteAccountPanel(), BorderLayout.CENTER);
        serverPanel.repaint();
        serverPanel.setVisible(true);

    }//GEN-LAST:event_deleteAccountItemActionPerformed

    private void viewAccountItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAccountItemActionPerformed

        serverPanel.removeAll();
        serverPanel.setVisible(false);
        serverPanel.setLayout(new BorderLayout());
        serverPanel.add(new viewAccountPanel(), BorderLayout.CENTER);
        serverPanel.repaint();
        serverPanel.setVisible(true);

    }//GEN-LAST:event_viewAccountItemActionPerformed

    private void addAccountItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAccountItemActionPerformed

        serverPanel.removeAll();
        serverPanel.setVisible(false);
        serverPanel.setLayout(new BorderLayout());
        serverPanel.add(new addAccountPanel(), BorderLayout.CENTER);
        serverPanel.repaint();
        serverPanel.setVisible(true);

    }//GEN-LAST:event_addAccountItemActionPerformed

    private void displayAccountItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayAccountItemActionPerformed

        serverPanel.removeAll();
        serverPanel.setVisible(false);
        serverPanel.setLayout(new BorderLayout());
        serverPanel.add(new displayAccountPanel(), BorderLayout.CENTER);
        serverPanel.repaint();
        serverPanel.setVisible(true);

    }//GEN-LAST:event_displayAccountItemActionPerformed

    private void updateAccountItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateAccountItemActionPerformed

        serverPanel.removeAll();
        serverPanel.setVisible(false);
        serverPanel.setLayout(new BorderLayout());
        serverPanel.add(new updateAccountPanel(), BorderLayout.CENTER);
        serverPanel.repaint();
        serverPanel.setVisible(true);

    }//GEN-LAST:event_updateAccountItemActionPerformed

    private void helpMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpMenuItemActionPerformed

        JOptionPane.showMessageDialog(null, "You have accessed the Server. Through here you can manage the Books and Accounts inside the Library.");

    }//GEN-LAST:event_helpMenuItemActionPerformed

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed

        System.exit(0);

    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void byIdMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_byIdMenuItemActionPerformed

        serverPanel.removeAll();
        serverPanel.setVisible(false);
        serverPanel.setLayout(new BorderLayout());
        serverPanel.add(new viewIdPanel(), BorderLayout.CENTER);
        serverPanel.repaint();
        serverPanel.setVisible(true);

    }//GEN-LAST:event_byIdMenuItemActionPerformed

    private void byTitleMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_byTitleMenuItemActionPerformed

        serverPanel.removeAll();
        serverPanel.setVisible(false);
        serverPanel.setLayout(new BorderLayout());
        serverPanel.add(new viewTitlePanel(), BorderLayout.CENTER);
        serverPanel.repaint();
        serverPanel.setVisible(true);

    }//GEN-LAST:event_byTitleMenuItemActionPerformed

    private void byAuthorMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_byAuthorMenuItemActionPerformed

        serverPanel.removeAll();
        serverPanel.setVisible(false);
        serverPanel.setLayout(new BorderLayout());
        serverPanel.add(new viewAuthorPanel(), BorderLayout.CENTER);
        serverPanel.repaint();
        serverPanel.setVisible(true);

    }//GEN-LAST:event_byAuthorMenuItemActionPerformed

    private void byGenreMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_byGenreMenuItemActionPerformed

        serverPanel.removeAll();
        serverPanel.setVisible(false);
        serverPanel.setLayout(new BorderLayout());
        serverPanel.add(new viewGenrePanel(), BorderLayout.CENTER);
        serverPanel.repaint();
        serverPanel.setVisible(true);

    }//GEN-LAST:event_byGenreMenuItemActionPerformed

    private void byStateItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_byStateItemActionPerformed

        serverPanel.removeAll();
        serverPanel.setVisible(false);
        serverPanel.setLayout(new BorderLayout());
        serverPanel.add(new viewStatePanel(), BorderLayout.CENTER);
        serverPanel.repaint();
        serverPanel.setVisible(true);


    }//GEN-LAST:event_byStateItemActionPerformed

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
            java.util.logging.Logger.getLogger(serverFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(serverFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(serverFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(serverFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new serverFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem addAccountItem;
    private javax.swing.JMenuItem addItem;
    private javax.swing.JMenuItem byAuthorMenuItem;
    private javax.swing.JMenuItem byGenreMenuItem;
    private javax.swing.JMenuItem byIdMenuItem;
    private javax.swing.JMenuItem byStateItem;
    private javax.swing.JMenuItem byTitleMenuItem;
    private javax.swing.JMenuItem deleteAccountItem;
    private javax.swing.JMenuItem deleteItem;
    private javax.swing.JMenuItem displayAccountItem;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenuItem helpMenuItem;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPanel serverPanel;
    private javax.swing.JMenuItem updateAccountItem;
    private javax.swing.JMenuItem updateItem;
    private javax.swing.JMenuItem viewAccountItem;
    private javax.swing.JMenuItem viewAllItem;
    // End of variables declaration//GEN-END:variables
}
