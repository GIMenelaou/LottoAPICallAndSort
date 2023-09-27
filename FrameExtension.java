/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3hge;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
/**
 *
 * @author Giorg
 */
public  class FrameExtension extends JFrame{
    
     FrameExtension (){
         
        this.setVisible(true);
        this.setSize(690,420);
        this.setTitle("ΟΠΑΠ Drawing Statistics");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        
        ImageIcon image = new ImageIcon("aaa.jpg");
        this.setIconImage(image.getImage());
        
        this.getContentPane().setBackground(new Color(0x123456));
     }
    
 
    
}
