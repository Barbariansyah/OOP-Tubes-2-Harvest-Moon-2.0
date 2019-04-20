package viewcontroller;

import java.awt.*;
import javax.swing.*;

/**
 * GameWindow
 */
public class GameWindow {
    public GameWindow(){  
        JFrame f = new JFrame("Panel Example");  

        JPanel panel=new JPanel();  
        panel.setBounds(0,0,50,50);    
        panel.setBackground(Color.GREEN);  

        f.add(panel);  
        f.setSize(400,400);    
        f.setLayout(null);    
        f.setVisible(true);    
    }  
}