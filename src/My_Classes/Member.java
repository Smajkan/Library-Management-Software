
package My_Classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Member {
    
    private int id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String gender;
    private byte[] picture;

    
    
    public Member(){}
    
    
        public Member(int _id, String _fname, String _lname, String _phone, String _email, String _gender, byte[] _picture){
        
        this.id = _id;
        this.firstName = _fname;
        this.lastName = _lname;
        this.phone = _phone;
        this.email = _email;
        this.gender = _gender;
        this.picture = _picture;
        
    }
        

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public byte[] getPicture() {
        return picture;
    }
   
        
//Funkcija za dodavanje novog člana
    public void addMember(String _fname, String _lname, String _phone, String _email, String _gender, byte[] _pic)
    {
        String insertQuery = "INSERT INTO `members`(`firstName`, `lastName`, `phone`, `email`, `gender`, `picture`) VALUES (?,?,?,?,?,?)";
        
        try {
            
            PreparedStatement ps = DB.getConnection().prepareStatement(insertQuery);
            ps.setString(1, _fname);
            ps.setString(2, _lname);
            ps.setString(3, _phone);
            ps.setString(4, _email);
            ps.setString(5, _gender);
            ps.setBytes(6, _pic);
            
            if(ps.executeUpdate()==1){
                JOptionPane.showMessageDialog(null, "Član dodat", "Dodavanje člana",1);
            }
            else{
                JOptionPane.showMessageDialog(null, "Dodavanje člana neuspješno.", "Dodavanje člana",2);
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
      //Funkcija za editovanje member pomoću ID-a
        public void editMember(Integer _id,String _fname, String _lname, String _phone, String _email, String _gender, byte[] _pic)
    {
        String editQuery = "UPDATE `members` SET `firstName`=?, `lastName`=?, `phone`=?, `email`=?, `gender`=?, `picture`=?  WHERE `id`=?";
        
        try {
            
            PreparedStatement ps = DB.getConnection().prepareStatement(editQuery);
            
            ps.setInt(1, _id);
            ps.setString(2, _fname);
            ps.setString(3, _lname);
            ps.setString(4, _phone);
            ps.setString(5, _email);
            ps.setString(6, _gender);
            ps.setBytes(7, _pic);
            
            
            
            if(ps.executeUpdate() != 0){
                JOptionPane.showMessageDialog(null, "Član uređen", "Uređivanje član",1);
            }
            else{
                JOptionPane.showMessageDialog(null, "Uređivanje člana neuspješno.", "Uređivanje član",2);
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
  
        }
        
    }
//Funkcija za brisanje membera pomoću ID-a
        public void removeMember(int _id)
        {
        String removeQuery = "DELETE FROM `members` WHERE `id` = ?";
        
        try {
            
            PreparedStatement ps = DB.getConnection().prepareStatement(removeQuery);
            
            
           
            ps.setInt(1, _id);
            
            
            if(ps.executeUpdate() != 0){
                JOptionPane.showMessageDialog(null, "Član izbrisan", "Brisanje člana",1);
            }
            else{
                JOptionPane.showMessageDialog(null, "Brisanje člana neuspješno.", "Brisanje člana",2);
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        }
        
        
        //Uzimamo ID membera
        public Member getMemberById(Integer _id) throws SQLException{
            Func_Class func = new Func_Class();
            
            String query = "SELECT * FROM `members` WHERE `id`= " + _id;
            
            ResultSet rs = func.getData(query);
            
            if(rs.next())
            {
            return new Member(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getBytes(7));    
            }
            else{
                
                return null;
            }
            
        }
    
        
        
            //funkcija da se sastavi arrayList zajedno sa članovima
        public ArrayList<Member> membersList(){
            ArrayList<Member> mList = new ArrayList<>();
            
           
            
            My_Classes.Func_Class func = new Func_Class();
           
            
        try {
            
            ResultSet rs = func.getData("SELECT * FROM `members`");
            
            
           Member member;
            
            
            while(rs.next()){
                //`, ``, ``, `about
                member = new Member(rs.getInt("id"), rs.getString("firstName"), rs.getString("lastName"),rs.getString("email"),rs.getString("phone"), rs.getString("gender"),rs.getBytes("picture"));
                mList.add(member);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mList;
        }
}
