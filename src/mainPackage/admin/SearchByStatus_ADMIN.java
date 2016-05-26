package mainPackage.admin;

import java.awt.BorderLayout;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
    
    private final String GET_STATE = "SELECT * FROM TBLBOOKS WHERE STATE = ?";
    
     //Commands for table books 
    private final String UPDATE_TBLBOOKS_OUT = "UPDATE TBLBOOKS SET DATE_BORROWED = ?, STATE = 'OUT', STUDENT_NUMBER = ? WHERE ID = ?"; // STUDENT NUMBER KUNG SINO HUMIRAM YUNG NASA JOPTIONPANE
    private final String UPDATE_TBLBOOKS_IN = "UPDATE TBLBOOKS SET DATE_BORROWED = NULL, STATE = 'IN', STUDENT_NUMBER = NULL  WHERE ID = ?"; //ID NA NASA TABLE

    //Commands for table BORROW
    private final String INSERT_TO_BORROW = "INSERT INTO BORROW VALUES(?,?,?,null)"; // Book has been borrowed
    private final String UPDATE_BORROW = "UPDATE BORROW SET DATE_RETURNED = ? WHERE BOOK_ID = ?"; // STUDENT NUMBER NA NASA TABLE

    //Commands for accounts
    private final String UPDATE_ACCOUNTS_OUT = "UPDATE ACCOUNTS SET DATE_BORROWED = ?, BOOK_ID = ? WHERE STUDENT_NUMBER = ?"; // Book ID kung ano yung nasa table na book id YUNG STUDENT NUMBER NAMAN KUNG SINO YUNG HUMIRAM YUNG NASA JOPTIONPANE
    private final String UPDATE_ACCOUNTS_IN = "UPDATE ACCOUNTS SET DATE_BORROWED = NULL, BOOK_ID = 0 WHERE STUDENT_NUMBER = ?"; // STUDENT NUMBER NA NASA TABLE
    
    private final String CHECK_BORROWED = "SELECT STUDENT_NUMBER = ? FROM ACCOUNTS WHERE BOOK_ID != 0";
    
    
    //Student Number Checker
    private final String GET_SNUMBER = "SELECT * FROM ACCOUNTS WHERE STUDENT_NUMBER = ?";

    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultset;
    private ResultSetMetaData rsMetadata;
    
    Calendar currenttime = Calendar.getInstance();
    Date sqldate = new Date((currenttime.getTime()).getTime());
    
    static ObjectOutputStream output;
    static ObjectInputStream input;

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
    
    public int checkAccounts(String sNumber) {

        int count = 0;

        try {
            statement = connection.prepareStatement(GET_SNUMBER);
            statement.setString(1, sNumber);
            resultset = statement.executeQuery();

            while (resultset.next()) {
                count = count + 1;
            }

            if (count == 1) {

                return count;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ViewAllBooksPanel_ADMIN.class.getName()).log(Level.SEVERE, null, ex);
        }

        return count = 0;

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
            Logger.getLogger(ViewAllBooksPanel_ADMIN.class.getName()).log(Level.SEVERE, null, ex);
        }

        return count = 0;

    }
    
    public void UPDATE_TBLBOOKS_OUT(Object id, String sNumber) { // Student Number at ID

        try {
            statement = connection.prepareStatement(UPDATE_TBLBOOKS_OUT);
            statement.setObject(1, sqldate);
            statement.setObject(2, sNumber);
            statement.setObject(3, id);
            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ViewAllBooksPanel_ADMIN.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ViewAllBooksPanel_ADMIN.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ViewAllBooksPanel_ADMIN.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void UPDATE_TBLBOOKS_IN(Object id) {

        try {
            statement = connection.prepareStatement(UPDATE_TBLBOOKS_IN);
            statement.setObject(1, id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ViewAllBooksPanel_ADMIN.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void UPDATE_BORROW(Object book_id) {

        try {
            statement = connection.prepareStatement(UPDATE_BORROW);
            statement.setObject(2, book_id);
            statement.setObject(1, sqldate);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ViewAllBooksPanel_ADMIN.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void UPDATE_ACCOUNTS_IN(Object sNumber) {

        try {
            statement = connection.prepareStatement(UPDATE_ACCOUNTS_IN);
            statement.setObject(1, sNumber);
            statement.executeUpdate();
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
        returnBtn = new javax.swing.JButton();

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

        returnBtn.setText("Return");
        returnBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnBtnActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(returnBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lendBtn)
                    .addComponent(returnBtn))
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
        Object student_num = displayTable.getValueAt(rowTable, 5);
        Object date_borrowed = displayTable.getValueAt(rowTable, 6);

        if (evt.getClickCount() == 2) {
            JTable target = (JTable) evt.getSource();
            int row = target.getSelectedRow();

            JOptionPane.showMessageDialog(null, "ID: " + id + "\n"
                + "Title: " + title + "\n"
                + "Author: " + author + "\n"
                + "Genre: " + genre + "\n"
                + "Status: " + status + "\n"
                + "Student Number: " + student_num + "\n"
                + "Date Borrowed: " + date_borrowed + "\n"
            );

        }
    }//GEN-LAST:event_displayTabledoubleClick

    private void lendBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lendBtnActionPerformed
        int row = displayTable.getSelectedRow();

        Object state = displayTable.getValueAt(row, 4);
        Object result = displayTable.getValueAt(row, 1);
        if (state.equals("OUT")) {

            JOptionPane.showMessageDialog(null, "The Book is still out!");
        } else {

            String sNumber = JOptionPane.showInputDialog("Enter Student Number");

            if (checkAccounts(sNumber) == 1) {

                if (checkBorrowed(sNumber) == 0) {

                    try {

                        displayTable.setValueAt("OUT", row, 4);

                        displayTable.setValueAt(sNumber, row, 5);

                        displayTable.setValueAt(sqldate, row, 6);

                        Object id = displayTable.getValueAt(row, 0);

                        UPDATE_TBLBOOKS_OUT(id, sNumber);
                        INSERT_TO_BORROW(sNumber, id);
                        UPDATE_ACCOUNTS_OUT(id, sNumber);
                        AdminFrame.displayArea.append("\n=============================\nA book named "+result+" has been lent to the client with a student number of: "+sNumber+".\n=============================");

                    } catch (ArrayIndexOutOfBoundsException e) {
                        JOptionPane.showMessageDialog(null, "Input an ID first.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Student Number has already a Borrowed Book!");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Student Number is not registered.");
            }

        }
    }//GEN-LAST:event_lendBtnActionPerformed

    private void returnBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnBtnActionPerformed
        try {
            int row = displayTable.getSelectedRow();
            Object id = displayTable.getValueAt(row, 0);
            Object result = displayTable.getValueAt(row, 1);
            Object sNumber = displayTable.getValueAt(row, 5);
            UPDATE_ACCOUNTS_IN(sNumber);

            displayTable.setValueAt("IN", row, 4);

            displayTable.setValueAt("", row, 5);

            displayTable.setValueAt("", row, 6);

            UPDATE_TBLBOOKS_IN(id);
            UPDATE_BORROW(id);
            JOptionPane.showMessageDialog(null, "This book has been returned by the client.");
            AdminFrame.displayArea.append("\n=============================\nA book named "+result+" has been returned by the client.\n=============================");
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Input an ID first.");
        }
    }//GEN-LAST:event_returnBtnActionPerformed

    private void sendData(String message) {
        try {
            output.writeObject("CLIENT : \n" + message);
            output.flush(); // flush data to output
            //displayMessage("\nCLIENT>>> " + message);

        } catch (IOException ioException) {
            System.out.println("Error writing object");
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> columnBox;
    private javax.swing.JTable displayTable;
    private javax.swing.JRadioButton inRadioButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton lendBtn;
    private javax.swing.JRadioButton outRadioButton;
    private javax.swing.JButton returnBtn;
    private javax.swing.JButton submitButton;
    // End of variables declaration//GEN-END:variables
}
