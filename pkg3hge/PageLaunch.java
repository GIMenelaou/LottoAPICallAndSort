/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3hge;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import modular.OpapJokerDraws;




/**
 *
 * @author Giorg
 */
public class PageLaunch implements ActionListener{
    
         JButton buttn = new JButton("Εκκίνηση");
     
         
         
              /* public static void centreWindow(Window frame) {
    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
    frame.setLocation(x, y);
}*/
         
     
      
      PageLaunch(){
          
            FrameExtend fframe = new FrameExtend();
 
          buttn.setBounds(100,250,200,40);
          buttn.setFocusable(false);
          
          buttn.addActionListener(this);
          

         fframe.add(buttn);
       // centreWindow(fframe);
       
      }


    
       
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==buttn) {
             
            DataProcessing proc = new DataProcessing();
            proc.setVisible(true);
            
            createTablAndColumns();
          
          
            
        }
         
        
    }
      
    private static Connection connect(){
        String connectionString = "jdbc:derby://localhost:1527/JokerDrawstats;create=true;user=Ge3Db;password=Ge3Db;";
        Connection connection = null;
             
        try {
                connection = DriverManager.getConnection(connectionString);
        }   catch (SQLException ex){
                Logger.getLogger(OpapJokerDraws.class.getName()).log(Level.SEVERE,null,ex);
        }
        return connection;
        
    }
    
    
          private static void createTablAndColumns() {
      	  try{     
              Connection connection = connect();
              
        String createTableSQL= "CREATE TABLE OPAP_JOKER_DRAWS"+"(id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"+	
	"gameId INTEGER NOT NULL,"+
	"drawID INTEGER NOT NULL UNIQUE,"+
	"drawTime Date NOT NULL,"+
	"winnningNumbers VARCHAR(255) NOT NULL,"+
	"bonusNumber INTEGER NOT NULL,"+
	"countWinners VARCHAR(255) NOT NULL,"+
	"divident VARCHAR(255) NOT NULL,"+
	"distributed VARCHAR(255) NOT NULL,"+
	"jackpot VARCHAR(255) NOT NULL,"+
	"PRIMARY KEY(id))";
        
       Statement statement = connection.createStatement();
       statement.executeUpdate(createTableSQL);
       statement.close();	
       connection.close();
             
        }   catch (SQLException ex){
            Logger.getLogger(OpapJokerDraws.class.getName()).log(Level.SEVERE, null,ex);
        }    }

    
    
      
      
      
}
