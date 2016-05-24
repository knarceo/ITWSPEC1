/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPackage.client;

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
import mainPackage.admin.AddBookPanel_ADMIN;
import mainPackage.displayPanel;

/**
 *
 * @author Windows8.1
 */
public class searchByGenrePanel extends javax.swing.JPanel {

    private static final String DATABSE_URL = "jdbc:derby://localhost:1527/libraryDb";
    private static final String username = "oracle";
    private static final String password = "pass";
    private final String GET_RECORDS = "SELECT * FROM TBLBOOKS WHERE GENRE = ?";

    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultset;
    private ResultSetMetaData rsMetadata;

    public searchByGenrePanel() {
        initComponents();
        try {
            connection = DriverManager.getConnection(DATABSE_URL, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(searchByGenrePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        viewAllRecords();
    }

    public int checkRecords(Object genre) {

        int count = 0;

        try {
            statement = connection.prepareStatement(GET_RECORDS);
            statement.setObject(1, genre);
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

    public void viewRecords(Object genre) {
        try {

            if (checkRecords(genre) >= 1) {

                statement = connection.prepareStatement(GET_RECORDS);
                statement.setObject(1, genre);
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
                JOptionPane.showMessageDialog(null, "No books were found related to this genre", "", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(displayPanel.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel1 = new javax.swing.JLabel();
        submitButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        displayTable = new javax.swing.JTable();
        genreBox = new javax.swing.JComboBox<>();

        jLabel1.setFont(new java.awt.Font("Arial Narrow", 1, 24)); // NOI18N
        jLabel1.setText("Search by Genre");

        submitButton.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        submitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mainPackage/assets/view.png"))); // NOI18N
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

        genreBox.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        genreBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Adventure", "Romance", "Fantasy", "Science fiction", "Satire", "Mystery", "Horror", "Self help", "Health", "Guide", "Travel", "Children's", "Religion & Spirituality", "Science", "History", "Math", "Anthology", "Poetry", "Encyclopedias", "Dictionaries", "Comics", "Art", "Cookbooks", "Diaries", "Journals", "Prayer books", "Series", "Trilogy", "Biographies", "Autobiographies" }));
        genreBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genreBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(genreBox, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(submitButton)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(genreBox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
   Object genre = "";

        switch (genreBox.getSelectedIndex()) {

            case 0:
                genre = genreBox.getSelectedItem();
                System.out.println(genre);
                break;
            case 1:
                genre = genreBox.getSelectedItem();
                break;
            case 2:
                genre = genreBox.getSelectedItem();
                break;
            case 3:
                genre = genreBox.getSelectedItem();
                break;
            case 4:
                genre = genreBox.getSelectedItem();
                break;
            case 5:
                genre = genreBox.getSelectedItem();
                break;
            case 6:
                genre = genreBox.getSelectedItem();
                break;
            case 7:
                genre = genreBox.getSelectedItem();
                break;
            case 8:
                genre = genreBox.getSelectedItem();
                break;
            case 9:
                genre = genreBox.getSelectedItem();
                break;
            case 10:
                genre = genreBox.getSelectedItem();
                break;
            case 11:
                genre = genreBox.getSelectedItem();
                break;
            case 12:
                genre = genreBox.getSelectedItem();
                break;
            case 13:
                genre = genreBox.getSelectedItem();
                break;
            case 14:
                genre = genreBox.getSelectedItem();
                break;
            case 15:
                genre = genreBox.getSelectedItem();
                break;
            case 16:
                genre = genreBox.getSelectedItem();
                break;
            case 17:
                genre = genreBox.getSelectedItem();
                break;
            case 18:
                genre = genreBox.getSelectedItem();
                break;
            case 19:
                genre = genreBox.getSelectedItem();
                break;
            case 20:
                genre = genreBox.getSelectedItem();
                break;
            case 21:
                genre = genreBox.getSelectedItem();
                break;
            case 22:
                genre = genreBox.getSelectedItem();
                break;
            case 23:
                genre = genreBox.getSelectedItem();
                break;
            case 24:
                genre = genreBox.getSelectedItem();
                break;
            case 25:
                genre = genreBox.getSelectedItem();
                break;
            case 26:
                genre = genreBox.getSelectedItem();
                break;
            case 27:
                genre = genreBox.getSelectedItem();
                break;
            case 28:
                genre = genreBox.getSelectedItem();
                break;
            case 29:
                genre = genreBox.getSelectedItem();
                break;
            default:
                genre = "";
                break;
        }
      
        if (genre.equals("")) {
            JOptionPane.showMessageDialog(null, "Please select a genre from the provided list", "", JOptionPane.ERROR_MESSAGE);
        } else {
            viewRecords(genre);
        }
    }//GEN-LAST:event_submitButtonActionPerformed

    private void genreBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genreBoxActionPerformed

    }//GEN-LAST:event_genreBoxActionPerformed

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable displayTable;
    private javax.swing.JComboBox<String> genreBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
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
            dtmPrefix.addColumn("STATE");

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
            Logger.getLogger(displayPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
