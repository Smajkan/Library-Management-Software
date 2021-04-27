
package My_Classes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author aldin
 */
public class Func_Class {
    
     public void displayImage(int width, int height, byte[] imagebyte, String imagePath, JLabel label){
        //ucitavanje slike,
       ImageIcon imgIco;
        if(imagebyte != null){ //pomocu bytes dobijamo sliku
            imgIco = new ImageIcon(imagebyte);
        }
        else{
            try{
                //uzimamo sliku iz project resursa
                imgIco = new ImageIcon(getClass().getResource(imagePath));
              }catch(Exception e){
                  //Uzimamo sliku sa racunara
              imgIco = new ImageIcon(imagePath);
              }
        }
       
       //Kako bi slika fitovala se u label
        Image image = imgIco.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        //Postavljanje slike unutar našeg JLabel-a
        label.setIcon(new ImageIcon(image));
        
        

        
        
 }
     
     
     //funkcija za uređivanje jtabel
     
     public void customTable(JTable table){
          //uredjivanje tabele
        
        table.setSelectionBackground(new Color(249,105,14));
        table.setSelectionForeground(Color.white);
        table.setRowHeight(35);
        table.setShowGrid(false);
        table.setBackground(new Color(248,248,248));
        table.setShowHorizontalLines(true);
        table.setGridColor(Color.ORANGE);
        
         
     }
     //funkcija da se uredi jtable headeri
      public void customTableHeader(JTable table,Color back_Color, Integer fontSize){
        table.getTableHeader().setBackground(back_Color); //ne prikazuje se trenutno popravit ću poslije
        table.getTableHeader().setForeground(Color.white);
        table.getTableHeader().setFont(new Font("Verdana", Font.BOLD, fontSize));
        table.getTableHeader().setOpaque(false);
          
      }

      
    // Funkcija za selektovanje slike
    // Funkcija će vraćati path do slike
      
      public String selectImage(){
                         //Selektovanje slike iz računara
        
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Odaberite Naslovnicu Knjige");
        
        fileChooser.setCurrentDirectory(new File("C:\\Images"));
        
        FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter("image",".png",".jpg",".jpeg");
        fileChooser.addChoosableFileFilter(extensionFilter);
        
        int fileState = fileChooser.showSaveDialog(null);
        String path="";
        if(fileState == JFileChooser.APPROVE_OPTION){
            path = fileChooser.getSelectedFile().getAbsolutePath();
        }
        
        
        return path;
      }


//Funkcija za returnanje resultSet
     //Koristićemo ovu funkciju da bismo smanjili kod kod populacije arraylista

     public ResultSet getData(String query){
     PreparedStatement ps;
     ResultSet rs = null;
            
        try {
            ps = DB.getConnection().prepareStatement(query);
            rs = ps.executeQuery();
         
         
     } 
        catch (SQLException ex) {
            Logger.getLogger(Func_Class.class.getName()).log(Level.SEVERE, null, ex);
        }
     
   return rs; 
}
}
