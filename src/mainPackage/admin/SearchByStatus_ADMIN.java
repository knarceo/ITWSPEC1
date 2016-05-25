/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPackage.admin;

import java.awt.BorderLayout;
import mainPackage.admin.SearchBookByID_ADMIN;
import mainPackage.admin.AddBookPanel_ADMIN;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import mainPackage.AdminFrame;

/**
 *
 * @author Windows8.1
 */
public class SearchByStatus_ADMIN extends javax.swing.JPanel {

    private static final String DATABSE_URL = "jdbc:derby://localhost:1527/libraryDb";
    private static final String username = "oracle";
    private static final String password = "pass";

    private final String GET_RECORDS = "SELECT * FROM TBLBOOKS WHERE STATE = ?";

    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultset;
    private ResultSetMetaData rsMetadata;

    public SearchByStatus_ADMIN() {
        initComponents();
        try {
            connection = DriverManager.getConnection(DATABSE_URL, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(SearchByStatus_ADMIN.class.getName()).log(Level.SEVERE, null, ex);
        }
        viewAllRecords();
    }
    
    private void viewAllRecords() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try {

            String searchQuery = "SELECT * FROM TBLBOOKS";
            statement = connection.prepareStatement(searchQuery);
            resultset = statement.executeQuery();
            rsMetadata = resultset.getMetaData();
            
            DefaultTableModel dtmPrefix = new DefaultTableModel() {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };
            dtmPrefix.addColumn("ID");
            dtmPrefix.addColumn("TITLE");
            dtmPrefix.addColumn("AUTHOR");
            dtmPrefix.addColumn("GENRE");
            dtmPrefix.addColumn("STATUS");

            while (resultset.next()) {

                dtmPrefix.addRow(new Object[]{
                    resultset.getInt(1),
                    resultset.getString(2),
                    resultset.getString(3),
                    resultset.getString(4),
                    resultset.getString(5),});
                displayTable.setModel(dtmPrefix);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ViewAllBooksPanel_ADMIN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int checkRecords(String state) {

        int count = 0;

        try {
            statement = connection.prepareStatement(GET_RECORDS);
            statement.setString(1, state);
            resultset = statement.executeQuery();

            while (resultset.next()) {
                count = count + 1;
            }

            if (count >= 1) {

                return count;
            }

        } catch (SQLException ex) {
            Logger.getLogger(AddBookPanel_ADMIN.class.getName()).log(Level.SEVERE, null, ex);
        }

        return count = 0;

    }

    public void viewRecords(String state) {
        try {

            if (checkRecords(state) >= 1) {

                statement = connection.prepareStatement(GET_RECORDS);
                statement.setString(1, state);
                resultset = statement.executeQuery();
                rsMetadata = resultset.getMetaData();

                DefaultTableModel dtmPrefix = new DefaultTableModel(){
                    
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };
                dtmPrefix.addColumn("ID");
                dtmPrefix.addColumn("TITLE");
                dtmPrefix.addColumn("AUTHOR");
                dtmPrefix.addColumn("GENRE");
                dtmPrefix.addColumn("STATUS");

                while (resultset.next()) {

                    dtmPrefix.addRow(new Object[]{
                        resultset.getInt(1),
                        resultset.getString(2),
                        resultset.getString(3),
                        resultset.getString(4),
                        resultset.getString(5)
                    });
                    displayTable.setModel(dtmPrefix);
                }

            } else {
                JOptionPane.showMessageDialog(null, "There are no books in this status", "", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ViewAllBooksPanel_ADMIN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        submitButton = new javax.swing.JButton();
        outRadioButton = new javax.swing.JRadioButton();
        inRadioButton = new javax.swing.JRadioButton();
        columnBox = new javax.swing.JComboBox<String>();
        jScrollPane1 = new javax.swing.JScrollPane();
        displayTable = new javax.swing.JTable();
        lendBtn = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Arial Narrow", 1, 24)); // NOI18N
        jLabel1.setText("Search by Status");

        submitButton.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        submitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mainPackage/assets/view.png"))); // NOI18N
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(outRadioButton);
        outRadioButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        outRadioButton.setText("OUT");

        buttonGroup1.add(inRadioButton);
        inRadioButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        inRadioButton.setText("IN");
        inRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inRadioButtonActionPerformed(evt);
            }
        });

        columnBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Search By ID", "Search By Author", "Search By Title", "Search By Genre", "Search By Status" }));
        columnBox.setSelectedItem("Search By Status");
        columnBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                columnBoxActionPerformed(evt);
            }
        });

        displayTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        displayTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                displayTabledoubleClick(evt);
            }
        });
        jScrollPane1.setViewportView(displayTable);

        lendBtn.setText("Lend Book Selected");
        lendBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lendBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(columnBox, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inRadioButton)
                        .addGap(18, 18, 18)
                        .addComponent(outRadioButton)
                        .addGap(18, 18, 18)
                        .addComponent(submitButton)
                        .addGap(333, 333, 333))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lendBtn)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(columnBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(outRadioButton)
                        .addComponent(inRadioButton)
                        .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lendBtn)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed

        String state;

        if (inRadioButton.isSelected()) {
            state = "IN";
            viewRecords(state);

        }

        else if(outRadioButton.isSelected()){
            state = "OUT";
            viewRecords(state);

        }

        else{
            System.out.println("Error");
        }

    }//GEN-LAST:event_submitButtonActionPerformed

    private void inRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inRadioButtonActionPerformed

    private void columnBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_columnBoxActionPerformed
        // TODO add your handling code here:
        if(columnBox.getSelectedItem().toString().equals("Search By Status")){
            AdminFrame.serverPanel.removeAll();
            AdminFrame.serverPanel.setVisible(false);
            AdminFrame.serverPanel.setLayout(new BorderLayout());
            AdminFrame.serverPanel.add(new SearchByStatus_ADMIN(), BorderLayout.CENTER);
            AdminFrame.serverPanel.repaint();
            AdminFrame.serverPanel.setVisible(true);
        }
        else if(columnBox.getSelectedItem().toString().equals("View All Books")){
            viewAllRecords();
        }
        else{
            AdminFrame.serverPanel.removeAll();
            AdminFrame.serverPanel.setVisible(false);
            AdminFrame.serverPanel.setLayout(new BorderLayout());
            AdminFrame.serverPanel.add(new ViewAllBooksPanel_ADMIN(), BorderLayout.CENTER);
            AdminFrame.serverPanel.repaint();
            AdminFrame.serverPanel.setVisible(true);
        }
    }//GEN-LAST:event_columnBoxActionPerformed

    private void displayTabledoubleClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_displayTabledoubleClick

        int rowTable = displayTable.getSelectedRow();

        Object id = displayTable.getValueAt(rowTable, 0);
        Object title = displayTable.getValueAt(rowTable, 1);
        Object author = displayTable.getValueAt(rowTable, 2);
        Object genre = displayTable.getValueAt(rowTable, 3);
        Object status = displayTable.getValueAt(rowTable, 4);

        if (evt.getClickCount() == 2) {
            JTable target = (JTable) evt.getSource();
            int row = target.getSelectedRow();

            JOptionPane.showMessageDialog(null, "ID: " + id + "\n"
                + "Title: " + title + "\n"
                + "Author: " + author + "\n"
                + "Genre: " + genre + "\n"
                + "Status: " + status + "\n"
            );

        }
    }//GEN-LAST:event_displayTabledoubleClick

    private void lendBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lendBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lendBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> columnBox;
    private javax.swing.JTable displayTable;
    private javax.swing.JRadioButton inRadioButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton lendBtn;
    private javax.swing.JRadioButton outRadioButton;
    private javax.swing.JButton submitButton;
    // End of variables declaration//GEN-END:variables
}
