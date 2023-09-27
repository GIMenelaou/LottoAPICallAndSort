package pkg3hge;


import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Giorg
 */
public class FrameExtend extends JFrame {
        

    
       public FrameExtend(){ 
             
             
           JPanel panel = new JPanel();
           
            
        
        
        this.setVisible(true);
        this.setSize(420,420);
        this.setTitle("JokerGame-Stats");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        JLabel label = new JLabel();
        label.setText("Στατιστικά Στοιχεία ΤΖΟΚΕΡ");
        ImageIcon image2 = new ImageIcon("src/logo.png");
        label.setIcon(image2);
        
         label.setBounds(69, 80, 260, 220);
         this.setLocationRelativeTo(null);
        label.getPreferredSize();
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setForeground(Color.white);
        label.setFont(new Font("Helvetica",Font.PLAIN,20));
        label.setIconTextGap(1);
    
       
         this.add(label);
        ImageIcon image = new ImageIcon("src/opap.jpg");
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(new Color(0x123456));
        
      
        
       
        
}
    //check json parsesr
}
