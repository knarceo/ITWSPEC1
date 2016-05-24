package mainPackage.client;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import mainPackage.ClientFrame;
import mainPackage.admin.AddBookPanel_ADMIN;
import mainPackage.admin.ViewAllBooksPanel_ADMIN;

/**
 *
 * @author Windows8.1
 */
public class searchByIdPanel extends javax.swing.JPanel {

    private static final String DATABSE_URL = "jdbc:derby://localhost:1527/libraryDb";
    private static final String username = "oracle";
    private static final String password = "pass";
    private final String GET_STATE = "SELECT * FROM TBLBOOKS WHERE STATE = ?";

    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultset;
    private ResultSetMetaData rsMetadata;

    public searchByIdPanel() {
        initComponents();
        inRadioButton.setVisible(false);
        outRadioButton.setVisible(false);
        searchStateBtn.setVisible(false);
        try {
            connection = DriverManager.getConnection(DATABSE_URL, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(searchByIdPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        viewAllRecords();
    }

    public int checkRecordsByState(String state) {

        int count = 0;

        try {
            statement = connection.prepareStatement(GET_STATE);
            statement.setString(1, state);
            resultset = statement.executeQuery();

            while (resultset.next()) {
                count = count + 1;
            }

            if (count == 1) {

                return count;
            }

        } catch (SQLException ex) {
            Logger.getLogger(AddBookPanel_ADMIN.class.getName()).log(Level.SEVERE, null, ex);
        }

        return count = 0;

    }
    
    public int checkRecords(String column, String tblValue) {
        
        String QUERY = "";
        if(column.equals("ID")){
            QUERY = "SELECT * FROM TBLBOOKS WHERE "+ column +" = "+tblValue;
        }else{
            QUERY = "SELECT * FROM TBLBOOKS WHERE "+ column +" LIKE '%"+tblValue+"%'";
        }

        try {
            statement = connection.prepareStatement(QUERY);
            resultset = statement.executeQuery();

            if(resultset.next()){
                return 1;
            }

        } catch (SQLException ex) {
            Logger.getLogger(AddBookPanel_ADMIN.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;

    }
    
    public void viewRecords(String column, String tblValue) {
        try {
            
            if (checkRecords(column, tblValue) == 1) {
                String QUERY = "";
                if(column.equals("ID")){
                    QUERY = "SELECT * FROM TBLBOOKS WHERE "+ column +" = "+tblValue;
                }else{
                    QUERY = "SELECT * FROM TBLBOOKS WHERE "+ column +" LIKE '%"+tblValue+"%'";
                }
                statement = connection.prepareStatement(QUERY);
//                statement.setInt(1, id);
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
                        resultset.getString(1),
                        resultset.getString(2),
                        resultset.getString(3),
                        resultset.getString(4),
                        resultset.getString(5),
                    });
                    displayTable.setModel(dtmPrefix);
                }
//                studentNumberField.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Book does not exists!");
//                studentNumberField.setText("");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void viewRecordsByStatus(String state) {
        try {

            if (checkRecordsByState(state) >= 1) {

                statement = connection.prepareStatement(GET_STATE);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        displayTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        columnBox = new javax.swing.JComboBox<String>();
        submitButton = new javax.swing.JButton();
        searchByIdField = new javax.swing.JTextField();
        searchStateBtn = new javax.swing.JButton();
        outRadioButton = new javax.swing.JRadioButton();
        inRadioButton = new javax.swing.JRadioButton();

        displayTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        displayTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                doubleClick(evt);
            }
        });
        jScrollPane1.setViewportView(displayTable);

        jLabel1.setFont(new java.awt.Font("Arial Narrow", 1, 24)); // NOI18N
        jLabel1.setText("Search a Book");

        columnBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Search By ID", "Search By Author", "Search By Title", "Search By Genre", "Search By Status" }));
        columnBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                columnBoxActionPerformed(evt);
            }
        });

        submitButton.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        submitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mainPackage/assets/viewAll.png"))); // NOI18N
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        searchByIdField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchByIdFieldActionPerformed(evt);
            }
        });

        searchStateBtn.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        searchStateBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mainPackage/assets/viewAll.png"))); // NOI18N
        searchStateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchStateBtnActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(492, 492, 492))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(columnBox, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchByIdField)
                        .addGap(12, 12, 12)
                        .addComponent(inRadioButton)
                        .addGap(18, 18, 18)
                        .addComponent(outRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(submitButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchStateBtn)
                        .addGap(174, 174, 174))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(searchByIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(outRadioButton)
                                    .addComponent(inRadioButton)))
                            .addComponent(columnBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchStateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void doubleClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doubleClick
            
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

        
    }//GEN-LAST:event_doubleClick

    private void columnBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_columnBoxActionPerformed
        // TODO add your handling code here:
        if(columnBox.getSelectedItem().toString().equals("Search By Status")){
            ClientFrame.clientPanel.removeAll();
            ClientFrame.clientPanel.setVisible(false);
            ClientFrame.clientPanel.setLayout(new BorderLayout());
            ClientFrame.clientPanel.add(new searchByStatusPanel(), BorderLayout.CENTER);
            ClientFrame.clientPanel.repaint();
            ClientFrame.clientPanel.setVisible(true);
        }
        else{
            searchByIdField.setVisible(true);
            submitButton.setVisible(true);
            inRadioButton.setVisible(false);
            outRadioButton.setVisible(false);
            searchStateBtn.setVisible(false);
        }
    }//GEN-LAST:event_columnBoxActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        try {
            String tblColumn = "Search By ID";

            switch(columnBox.getSelectedItem().toString()){
                    case "Search By ID" :
                    tblColumn = "ID";
                    break;
                    case "Search By Author" :
                    tblColumn = "AUTHOR";
                    break;
                    case "Search By Title" :
                    tblColumn = "TITLE";
                    break;
                    case "Search By Genre" :
                    tblColumn = "GENRE";
                    break;
                    case "Search By Status" :
                    tblColumn = "STATE";
                    break;
                }

            viewRecords(tblColumn, searchByIdField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please Input a Proper ID Number.");
        }
                
    }//GEN-LAST:event_submitButtonActionPerformed

    private void searchByIdFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchByIdFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchByIdFieldActionPerformed

    private void searchStateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchStateBtnActionPerformed
        String state;

        if (inRadioButton.isSelected()) {
            state = "IN";
            viewRecordsByStatus(state);

        }

        else if(outRadioButton.isSelected()){
            state = "OUT";
            viewRecordsByStatus(state);

        }

        else{
            System.out.println("Error");
        }
    }//GEN-LAST:event_searchStateBtnActionPerformed

    private void inRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inRadioButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> columnBox;
    private javax.swing.JTable displayTable;
    private javax.swing.JRadioButton inRadioButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton outRadioButton;
    private javax.swing.JTextField searchByIdField;
    private javax.swing.JButton searchStateBtn;
    private javax.swing.JButton submitButton;
    // End of variables declaration//GEN-END:variables

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
            searchByIdField.setText("");         
        } catch (SQLException ex) {
            Logger.getLogger(ViewAllBooksPanel_ADMIN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
