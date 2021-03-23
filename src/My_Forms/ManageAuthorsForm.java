/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package My_Forms;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aldin
 */
public class ManageAuthorsForm extends javax.swing.JFrame {
My_Classes.Genre genre = new My_Classes.Genre();
    /**
     * Creates new form ManageGenresForm
     */
    public ManageAuthorsForm() {
        initComponents();
        
        //centriramo formu
        this.setLocationRelativeTo(null);
        
        //dodajemo sivi border
         Border panelHeaderBorder = BorderFactory.createMatteBorder(3, 3, 3, 3, Color.gray);
         jPanel1.setBorder(panelHeaderBorder);
         
         //prikaz slike u vrhu
        //Poziv funkcije da se pokaze slika na vrhu
        My_Classes.Func_Class func = new My_Classes.Func_Class();
        func.displayImage(75, 60, "/My_Images/hierarchy.png", jLabel_FormTitle);
        
        
        //uredjivanje tabele
        
        jTable_Genres_.setSelectionBackground(new Color(249,105,14));
        jTable_Genres_.setSelectionForeground(Color.white);
        jTable_Genres_.setRowHeight(30);
        jTable_Genres_.setShowGrid(false);
        jTable_Genres_.setBackground(new Color(248,248,248));
        
        
        //uredjivanje headera tabele 
        jTable_Genres_.getTableHeader().setBackground(new Color(42,187,155)); //ne prikazuje se trenutno popravit ću poslije
        jTable_Genres_.getTableHeader().setForeground(Color.white);
        jTable_Genres_.getTableHeader().setFont(new Font("Verdana", Font.BOLD, 20));
        jTable_Genres_.getTableHeader().setOpaque(false);
        
        
        //Ovdje sakrijemo jlabel empty koji je napravljen ukoliko nije upisano ime žanra
        
        jLabel_EmptyName_.setVisible(false);
        
        
        //Poziv funkcije za populiranje sa žanrom
        populateJtableWithGenres();
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
        jLabel_FormTitle = new javax.swing.JLabel();
        jLabel_CloseForm_ = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField_Name = new javax.swing.JTextField();
        jTextField_ID = new javax.swing.JTextField();
        jButton_Delete = new javax.swing.JButton();
        jButton_Add = new javax.swing.JButton();
        jButton_Edit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Genres_ = new javax.swing.JTable();
        jLabel_EmptyName_ = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel_FormTitle.setBackground(java.awt.Color.gray);
        jLabel_FormTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel_FormTitle.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_FormTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_FormTitle.setText("     Uređivanje žanrova knjiga");
        jLabel_FormTitle.setOpaque(true);

        jLabel_CloseForm_.setBackground(java.awt.Color.gray);
        jLabel_CloseForm_.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jLabel_CloseForm_.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_CloseForm_.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_CloseForm_.setText("X");
        jLabel_CloseForm_.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_CloseForm_.setOpaque(true);
        jLabel_CloseForm_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_CloseForm_MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel1.setText("Ime:");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel2.setText("ID:");

        jTextField_Name.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N

        jTextField_ID.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N

        jButton_Delete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton_Delete.setText("Obriši");
        jButton_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DeleteActionPerformed(evt);
            }
        });

        jButton_Add.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton_Add.setText("Dodaj");
        jButton_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AddActionPerformed(evt);
            }
        });

        jButton_Edit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton_Edit.setText("Uredi");
        jButton_Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_EditActionPerformed(evt);
            }
        });

        jTable_Genres_.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable_Genres_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_Genres_MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_Genres_);

        jLabel_EmptyName_.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel_EmptyName_.setForeground(new java.awt.Color(253, 0, 0));
        jLabel_EmptyName_.setText("*Upišite ime žanra");
        jLabel_EmptyName_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_EmptyName_MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton_Add, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextField_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_EmptyName_, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel_FormTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel_CloseForm_, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel_FormTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(jLabel_CloseForm_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 11, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addComponent(jLabel_EmptyName_))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Add, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel_CloseForm_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_CloseForm_MouseClicked
        //Zatvaramo formu
        
        this.dispose();
        
    }//GEN-LAST:event_jLabel_CloseForm_MouseClicked

    private void jButton_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AddActionPerformed
       
        //button za dodavanje novog žanra
        String name = jTextField_Name.getText();
        
        //provjerava da li su polja za tekst prazna
        if(name.isEmpty()){
            jLabel_EmptyName_.setVisible(true);
        }
        else//ako su popunjena polja
        {
         genre.addGenre(name);
         
         //osvježavanje tabele nakon što se doda žanr
         populateJtableWithGenres();
        }
        
        
        
    }//GEN-LAST:event_jButton_AddActionPerformed

    private void jButton_EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EditActionPerformed
        //uređujemo selektovani žanr
        String name = jTextField_Name.getText();

        //provjerava da li su polja za tekst prazna
        if(name.isEmpty()){
            jLabel_EmptyName_.setVisible(true);
        }
        //ako su popunjena polja
        else{ 
            try{
                int id = Integer.parseInt(jTextField_ID.getText());
                genre.editGenre(id, name);
                //osvježavanje tabele nakon što se edituje žanr
         populateJtableWithGenres();
            }
            catch(NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(null, "Neispravan ID žanra." + ex.getMessage(), "Greška",0);
            }
        }
    }//GEN-LAST:event_jButton_EditActionPerformed

    private void jButton_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DeleteActionPerformed
        //brisanje selektovanog žanra
          try{
                int id = Integer.parseInt(jTextField_ID.getText());
                genre.removeGenre(id);
                //osvježavanje tabele nakon što se obriše žanr
                
                //čistimo tekst formu 
                jTextField_ID.setText("");
                jTextField_Name.setText("");
         populateJtableWithGenres();
            }
            catch(NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(null, "Neispravan ID žanra - " + ex.getMessage(),"Greška",0);
            }
        
    }//GEN-LAST:event_jButton_DeleteActionPerformed

    private void jTable_Genres_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_Genres_MouseClicked
        // Prikazivanje selektovanog žanra
        //dobijanje indexa selektovanog reda
        int index = jTable_Genres_.getSelectedRow();
        
        //ovdje uzimamo vrijednost
        String id = jTable_Genres_.getValueAt(index, 0).toString();
        String name = jTable_Genres_.getValueAt(index, 1).toString();
        
        //Prikaz podataka unutar textfielda
        jTextField_ID.setText(id);
        jTextField_Name.setText(name);
        
    }//GEN-LAST:event_jTable_Genres_MouseClicked

    
    //funkcija da se spoji jtable zajedno sa žanrovima
    
    public void populateJtableWithGenres()
    {
        ArrayList<My_Classes.Genre> genresList = genre.genreList();
        
        //jtable kolone
        String[] colNames = {"ID", "IME"};
        
        //jtable redovi
        Object[][] rows = new Object[genresList.size()][colNames.length];
        
        for(int i = 0; i< genresList.size(); i++)
        {
            rows[i][0] = genresList.get(i).getId();
            rows[i][1] = genresList.get(i).getName();
            
        }
        
        DefaultTableModel model  = new DefaultTableModel(rows, colNames);
        jTable_Genres_.setModel(model);
        
    }
    
    
    
    private void jLabel_EmptyName_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_EmptyName_MouseClicked
        //Label nestaje na klik
        jLabel_EmptyName_.setVisible(false);
    }//GEN-LAST:event_jLabel_EmptyName_MouseClicked

   
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
                    
                    //javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManageAuthorsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageAuthorsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageAuthorsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageAuthorsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageAuthorsForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Add;
    private javax.swing.JButton jButton_Delete;
    private javax.swing.JButton jButton_Edit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel_CloseForm_;
    private javax.swing.JLabel jLabel_EmptyName_;
    private javax.swing.JLabel jLabel_FormTitle;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Genres_;
    private javax.swing.JTextField jTextField_ID;
    private javax.swing.JTextField jTextField_Name;
    // End of variables declaration//GEN-END:variables
}
