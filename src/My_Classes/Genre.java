
package My_Classes;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author aldin
 */
public class Genre {
    
    private int id;
    private String name;
    
    
    //konstruktor
    public Genre(){};
    
    public Genre(int _id, String _name)
    {
        this.id = _id;
        this.name = _name;
        
    }
    
    
    //getteri i setteri
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int _id) {
        this.id = _id;
    }

    public void setName(String _name) {
        this.name = _name;
    }
    
    
    //funkcije
    //funkcija za ubacivanje novog žanra
    public void addGenre(String _name)
    {
        String insertQuery = "INSERT INTO `book_genres`(`name`) VALUES (?)";
        
        try {
            
            PreparedStatement ps = DB.getConnection().prepareStatement(insertQuery);
            ps.setString(1,_name);
            
            if(ps.executeUpdate()==1){
                JOptionPane.showMessageDialog(null, "Žanr dodat", "Dodavanje žanra",1);
            }
            else{
                JOptionPane.showMessageDialog(null, "Dodavanje žanra neuspješno.", "Dodavanje žanra",2);
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(Genre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    //Funkcija za editovanje žanra pomoću ID-a
        public void editGenre(int _id, String _name)
    {
        String editQuery = "UPDATE `book_genres` SET `name` = ? WHERE `id` = ?";
        
        try {
            
            PreparedStatement ps = DB.getConnection().prepareStatement(editQuery);
            ps.setString(1, _name);
            ps.setInt(2, _id);
            
            
            if(ps.executeUpdate() != 0){
                JOptionPane.showMessageDialog(null, "Žanr uređen", "Uređivanje žanra",1);
            }
            else{
                JOptionPane.showMessageDialog(null, "Uređivanje žanra neuspješno.", "Uređivanje žanra",2);
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(Genre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
