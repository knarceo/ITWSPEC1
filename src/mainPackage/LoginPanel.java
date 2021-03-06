/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPackage;

import java.awt.BorderLayout;
import java.awt.Window;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Windows8.1
 */
public class LoginPanel extends javax.swing.JPanel {

    private static final String DATABSE_URL = "jdbc:derby://localhost:1527/libraryDb";
    private static final String username = "oracle";
    private static final String password = "pass";

    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultset;
    private ResultSetMetaData rsMetadata;
    
    public LoginPanel() {
        initComponents();
        try {
            connection = DriverManager.getConnection(DATABSE_URL, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(LoginPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int checkRecords(String username, String password) {
        int count = 0;
        try {
            String CHECK_RECORDS = "SELECT * FROM ACCOUNTS WHERE USERNAME = '"+username+"' AND PASSWORD = '"+password+"'";
            statement = connection.prepareStatement(CHECK_RECORDS);
//            statement.setString(1, username);
//            statement.setString(2, password);
            resultset = statement.executeQuery();
            while (resultset.next()) {
                if(resultset.getString("ACCT_STATUS").equals("DEACTIVATED")){
                    return -1;
                }else{
                    return 1;
                }
            }
            return 0;
//            while (resultset.next()) {
//                if(resultset.getString("ACCT_STATUS").equals("DEACTIVATED")){
//                    return -1;
//                    JOptionPane.showMessageDialog(null, "Account has been deactivated.\nPlease contact administrator for further details", "", JOptionPane.ERROR_MESSAGE);
//                    break;
//                }
//                
//                count = count++;
//            }

        } catch (SQLException ex) {
            Logger.getLogger(LoginPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count = 0;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        usernameField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        loginButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        passwordField = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(710, 469));

        jLabel1.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jLabel1.setText("Username:");

        jLabel2.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jLabel2.setText("Password:");

        loginButton.setBackground(new java.awt.Color(153, 153, 255));
        loginButton.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        backButton.setBackground(new java.awt.Color(255, 51, 51));
        backButton.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial Narrow", 1, 36)); // NOI18N
        jLabel3.setText("Book Rental System : Login");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(137, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel2))
                                        .addGap(0, 289, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(backButton)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(loginButton))
                            .addComponent(usernameField)
                            .addComponent(passwordField))
                        .addGap(133, 133, 133))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(156, 156, 156))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(loginButton))
                .addContainerGap(170, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed

        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        
        if (username.equals("admin") && password.equals("admin")) {
            this.setVisible(false);
            this.remove(this);
            AdminFrame serverFrame = new AdminFrame();
            serverFrame.setVisible(true);
            ((Window) getRootPane().getParent()).dispose();
        } else if (username.equals("") && password.equals("")) {
            JOptionPane.showMessageDialog(null, "Please Fill out the needed areas.", "", JOptionPane.ERROR_MESSAGE);
        } else if (checkRecords(username, password) == 1) {
            this.setVisible(false);
            this.remove(this);
            ClientFrame clientFrame = new ClientFrame();
            clientFrame.setVisible(true);
            ((Window) getRootPane().getParent()).dispose();
        }else if(checkRecords(username, password) == -1){
            JOptionPane.showMessageDialog(null, "This account has been deactivated.\nPlease contact the administrator for further instructions", "", JOptionPane.ERROR_MESSAGE);
        }else if (checkRecords(username, password) == 0) {
            JOptionPane.showMessageDialog(null, "Account not Found!", "", JOptionPane.ERROR_MESSAGE);
            usernameField.setText("");
            passwordField.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Account not Found!!", "", JOptionPane.ERROR_MESSAGE);
            usernameField.setText("");
            passwordField.setText("");
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed

        MainFrame.mainPanel.removeAll();
        MainFrame.mainPanel.setVisible(false);
        MainFrame.mainPanel.setLayout(new BorderLayout());
        MainFrame.mainPanel.add(new MainPanel(), BorderLayout.CENTER);
        MainFrame.mainPanel.repaint();
        MainFrame.mainPanel.setVisible(true);

    }//GEN-LAST:event_backButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables
}
