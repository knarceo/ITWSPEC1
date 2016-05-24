/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPackage.admin;

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

/**
 *
 * @author Windows8.1
 */
public class SearchByStatus_ADMIN extends javax.swing.JPanel {

    private static final String DATABSE_URL = "jdbc:derby://localhost:1527/libraryDb";
    private static final String username = "oracle";
    private static final String password = "pass";

    Calendar currenttime = Calendar.getInstance();

    Date sqldate = new Date((currenttime.getTime()).getTime());

    private final String GET_RECORDS = "SELECT * FROM TBLBOOKS WHERE STATE = ?";

    private final String CHECK_BORROWED = "SELECT STUDENT_NUMBER = ? FROM ACCOUNTS WHERE BOOK_ID != 0";

    //Student Number Checker
    private final String GET_SNUMBER = "SELECT * FROM ACCOUNTS WHERE STUDENT_NUMBER = ?";

    //Commands for table books 
    private final String UPDATE_TBLBOOKS_OUT = "UPDATE TBLBOOKS SET DATE_BORROWED = ?, STATE = 'OUT', STUDENT_NUMBER = ? WHERE ID = ?"; // STUDENT NUMBER KUNG SINO HUMIRAM YUNG NASA JOPTIONPANE
    private final String UPDATE_TBLBOOKS_IN = "UPDATE TBLBOOKS SET DATE_BORROWED = NULL, STATE = 'IN', STUDENT_NUMBER = NULL  WHERE ID = ?"; //ID NA NASA TABLE

    //Commands for table BORROW
    private final String INSERT_TO_BORROW = "INSERT INTO BORROW VALUES(?,?,?,null)"; // Book has been borrowed
    private final String UPDATE_BORROW = "UPDATE BORROW SET DATE_RETURNED = ? WHERE BOOK_ID = ?"; // STUDENT NUMBER NA NASA TABLE

    //Commands for accounts
    private final String UPDATE_ACCOUNTS_OUT = "UPDATE ACCOUNTS SET DATE_BORROWED = ?, BOOK_ID = ? WHERE STUDENT_NUMBER = ?"; // Book ID kung ano yung nasa table na book id YUNG STUDENT NUMBER NAMAN KUNG SINO YUNG HUMIRAM YUNG NASA JOPTIONPANE
    private final String UPDATE_ACCOUNTS_IN = "UPDATE ACCOUNTS SET DATE_BORROWED = NULL, BOOK_ID = 0 WHERE STUDENT_NUMBER = ?"; // STUDENT NUMBER NA NASA TABLE

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
    }

    public int checkBorrowed(String sNumber) {

        int count = 0;

        try {
            statement = connection.prepareStatement(CHECK_BORROWED);
            statement.setString(1, sNumber);
            resultset = statement.executeQuery();

            while (resultset.next()) {
                count = count + 1;
            }

            if (count == 1) {
                return count;
            }

        } catch (SQLException ex) {
            Logger.getLogger(SearchBookByID_ADMIN.class.getName()).log(Level.SEVERE, null, ex);
        }

        return count = 0;

    }

    public int checktblBooks(String genre) {

        int count = 0;

        try {
            statement = connection.prepareStatement(GET_RECORDS);
            statement.setString(1, genre);
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

    public int checkAccounts(String sNumber) {

        int count = 0;

        try {
            statement = connection.prepareStatement(GET_SNUMBER);
            statement.setString(1, sNumber);
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

    public void viewRecords(String genre) {
        try {

            if (checktblBooks(genre) >= 1) {

                statement = connection.prepareStatement(GET_RECORDS);
                statement.setString(1, genre);
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
                dtmPrefix.addColumn("STATE");
                dtmPrefix.addColumn("STUDENT NUMBER");
                dtmPrefix.addColumn("DATE BORROWED");

                while (resultset.next()) {

                    dtmPrefix.addRow(new Object[]{
                        resultset.getInt(1),
                        resultset.getString(2),
                        resultset.getString(3),
                        resultset.getString(4),
                        resultset.getString(5),
                        resultset.getString(6),
                        resultset.getString(7)
                    });
                    displayTable.setModel(dtmPrefix);
                }

            } else {
                JOptionPane.showMessageDialog(null, "There are no Books at this State!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ViewAllBooksPanel_ADMIN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void UPDATE_TBLBOOKS_OUT(Object id, String sNumber) { // Student Number at ID

        try {
            statement = connection.prepareStatement(UPDATE_TBLBOOKS_OUT);
            statement.setObject(1, sqldate);
            statement.setObject(2, sNumber);
            statement.setObject(3, id);
            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(SearchBookByID_ADMIN.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void INSERT_TO_BORROW(String sNumber, Object book_id) { // Student Number at ID

        try {
            statement = connection.prepareStatement(INSERT_TO_BORROW);
            statement.setObject(1, sNumber);
            statement.setObject(2, book_id);
            statement.setObject(3, sqldate);
            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(SearchBookByID_ADMIN.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void UPDATE_ACCOUNTS_OUT(Object id, String sNumber) { // Student Number at ID

        try {
            statement = connection.prepareStatement(UPDATE_ACCOUNTS_OUT);
            statement.setObject(3, sNumber);
            statement.setObject(2, id);
            statement.setObject(1, sqldate);
            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(SearchBookByID_ADMIN.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void UPDATE_TBLBOOKS_IN(Object id) {

        try {
            statement = connection.prepareStatement(UPDATE_TBLBOOKS_IN);
            statement.setObject(1, id);
            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(SearchBookByID_ADMIN.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void UPDATE_BORROW(Object book_id) {

        try {
            statement = connection.prepareStatement(UPDATE_BORROW);
            statement.setObject(2, book_id);
            statement.setObject(1, sqldate);
            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(SearchBookByID_ADMIN.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void UPDATE_ACCOUNTS_IN(Object sNumber) {

        try {
            statement = connection.prepareStatement(UPDATE_ACCOUNTS_IN);
            statement.setObject(1, sNumber);
            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(SearchBookByID_ADMIN.class
                    .getName()).log(Level.SEVERE, null, ex);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        displayTable = new javax.swing.JTable();
        outRadioButton = new javax.swing.JRadioButton();
        inRadioButton = new javax.swing.JRadioButton();

        jLabel1.setFont(new java.awt.Font("Arial Narrow", 1, 24)); // NOI18N
        jLabel1.setText("Administrator : Search by Status");

        submitButton.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        submitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mainPackage/assets/viewAll.png"))); // NOI18N
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        displayTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
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

        buttonGroup1.add(outRadioButton);
        outRadioButton.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        outRadioButton.setText("OUT");

        buttonGroup1.add(inRadioButton);
        inRadioButton.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        inRadioButton.setText("IN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(inRadioButton)
                                .addGap(18, 18, 18)
                                .addComponent(outRadioButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(submitButton))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(outRadioButton)
                    .addComponent(inRadioButton)
                    .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed

        String state;

        if (inRadioButton.isSelected()) {
            state = "IN";
            viewRecords(state);

        } else if (outRadioButton.isSelected()) {
            state = "OUT";
            viewRecords(state);

        } else {

            JOptionPane.showMessageDialog(null, "Please Choose a Button.");

        }

    }//GEN-LAST:event_submitButtonActionPerformed

    private void doubleClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doubleClick

        int rowTable = displayTable.getSelectedRow();

        Object id = displayTable.getValueAt(rowTable, 0);
        Object title = displayTable.getValueAt(rowTable, 1);
        Object author = displayTable.getValueAt(rowTable, 2);
        Object genre = displayTable.getValueAt(rowTable, 3);
        Object state = displayTable.getValueAt(rowTable, 4);
        Object sNumber = displayTable.getValueAt(rowTable, 5);
        Object date_borrowed = displayTable.getValueAt(rowTable, 6);

        if (evt.getClickCount() == 2) {
            JTable target = (JTable) evt.getSource();
            int row = target.getSelectedRow();

            JOptionPane.showMessageDialog(null, "ID: " + id + "\n"
                    + "Title: " + title + "\n"
                    + "Author: " + author + "\n"
                    + "Genre: " + genre + "\n"
                    + "State: " + state + "\n"
                    + "Student Number: " + sNumber + "\n"
                    + "Date Borrowed: " + date_borrowed + "\n"
            );

        }

    }//GEN-LAST:event_doubleClick


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTable displayTable;
    private javax.swing.JRadioButton inRadioButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton outRadioButton;
    private javax.swing.JButton submitButton;
    // End of variables declaration//GEN-END:variables
}
