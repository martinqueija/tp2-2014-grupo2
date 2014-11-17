package fiuba.algo3.tp2.Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AlgoCityVista extends JFrame {
		
        JButton[][] grid; //nombra la grilla de botones
 
        public AlgoCityVista(int width, int length){ 
                setLayout(new GridLayout(width,length));
                grid=new JButton[width][length]; 
                for(int y=0; y<length; y++){
                        for(int x=0; x<width; x++){
                              //  grid[x][y]=new JButton("("+x+","+y+")"); 
                        		grid[x][y]=new JButton("<html>   I ! ()<br/>100.0</html>"); 
                                this.add(grid[x][y]);
                        }
                }
                JButton botonTemporal;
                
                for(int y=0; y<length; y++){
                    for(int x=0; x<width; x++){
                    	if ((x==0)||(y==0)) {
                    		botonTemporal = grid[x][y];
                    		botonTemporal.setVisible(false);
                    	}
                    	
                    	if ((x==1)||(y==1)) {
                    		botonTemporal = grid[x][y];
                    		botonTemporal.setVisible(false);
                    	}
                    	
                    	if ((x==0)&&(y<=12)) {
                    		botonTemporal = grid[x][y];
                    		botonTemporal.setVisible(true);
                    	}
                    }
                }
                
                
                for(int y=0; y<length; y++){
                    for(int x=0; x<width; x++){
                    	if (!((x<=1)&&(y<=0))) {
                        	botonTemporal = grid[x][y];
                    	}
                    }
                }
                
  //              btnNewButton.addActionListener(new ActionListener() {
  //      			public void actionPerformed(ActionEvent arg0) {
   //     			}
   //     		});
                
                
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                pack(); 
                setVisible(true);
        }
        
        
        public void setBotonTexto(String string, int x, int y){
        	JButton temp = grid[x][y];
        	temp.setText(string);
        }
        
        public String getBotonTexto(int x, int y){
        	JButton temp = grid[x][y];
        	return temp.getText();
        }
        
        public void setBotonColorBackground(Color color, int x, int y){
        	JButton temp = grid[x][y];
        	temp.setBackground(color);
        }
        
        public void setBotonColorTexto(Color color, int x, int y){
        	JButton temp = grid[x][y];
        	temp.setForeground(color);
        }
        
}
