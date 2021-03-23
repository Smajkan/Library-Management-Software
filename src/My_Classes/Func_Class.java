
package My_Classes;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author aldin
 */
public class Func_Class {
    
     public void displayImage(int width, int height, String imagePath, JLabel label){
        //ucitavanje slike
        ImageIcon imgIco = new ImageIcon(getClass().getResource(imagePath));
       //Kako bi slika fitovala se u label
        Image image = imgIco.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        //Postavljanje slike unutar našeg JLabel-a
        label.setIcon(new ImageIcon(image));
        
        

        
        
 }
    
}
