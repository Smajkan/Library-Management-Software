
package My_Classes;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.HashMap;
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
      My_Classes.Func_Class func = new Func_Class();
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
        
        
         //Funkcija za brisanje žanra pomoću ID-a
        public void removeGenre(int _id)
    {
        String removeQuery = "DELETE FROM `book_genres` WHERE `id` = ?";
        
        try {
            
            PreparedStatement ps = DB.getConnection().prepareStatement(removeQuery);
            
            
           
            ps.setInt(1, _id);
            
            
            if(ps.executeUpdate() != 0){
                JOptionPane.showMessageDialog(null, "Žanr izbrisan", "Brisanje žanra",1);
            }
            else{
                JOptionPane.showMessageDialog(null, "Brisanje žanra neuspješno.", "Brisanje žanra",2);
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(Genre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        
        //funkcija da se sastavi arrayList zajedno sa žanrovima
        public ArrayList<Genre> genreList(){
           ArrayList<Genre> gList = new ArrayList<>();
         
           
        try {
           ResultSet rs = func.getData("SELECT * FROM `book_genres`");
            
            Genre genre;
            
            
            while(rs.next()){
                genre = new Genre(rs.getInt("id"), rs.getString("name"));
                gList.add(genre);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Genre.class.getName()).log(Level.SEVERE, null, ex);
        }
        return gList;
        }
        
        
        //Funkcija kako bi vratili hashmap
        //String je kljuc
        // integer je vrijednost
        public HashMap<String, Integer> getGenresMap()
        {
            
            HashMap<String, Integer> map = new HashMap<>();
            
             try {
           ResultSet rs = func.getData("SELECT * FROM `book_genres`");
            
            Genre genre;
            
            
            while(rs.next()){
                genre = new Genre(rs.getInt("id"), rs.getString("name"));
             map.put(genre.getName(),genre.getId());
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Genre.class.getName()).log(Level.SEVERE, null, ex);
        }
             
             return map;
        }
        
        
}
