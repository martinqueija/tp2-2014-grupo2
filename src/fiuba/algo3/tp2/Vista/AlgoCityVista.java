package fiuba.algo3.tp2.Vista;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class AlgoCityVista extends JFrame {
		
        JButton[][] grid; 
        
        public AlgoCityVista(int width, int length){ 
        		Font unfont;
        		float flot;
        		Dimension dimen = new Dimension(70,50);
        		
        		Dimension dimen2 = new Dimension(2,2);
        		
        		int tamXreal = width + 2;
        		int tamYreal = length + 2;
                setLayout(new GridLayout(tamXreal,tamYreal));
                grid=new JButton[tamXreal][tamYreal]; 
                for(int y=0; y<(tamYreal); y++){
                        for(int x=0; x<(tamXreal); x++){                          
                        		grid[x][y]=new JButton("nodeberiaestaresto"); 
                        		grid[x][y].setPreferredSize(dimen);
                        		unfont = grid[x][y].getFont();
                        		flot = unfont.getSize2D();
                        		flot = (float) (flot/1.5);
                        		unfont = unfont.deriveFont(flot);
                        		grid[x][y].setFont(unfont);
                        		
                                this.add(grid[x][y]);
                        }
                }
                
                JButton botonTemporal;
                for(int y=0; y<tamYreal; y++){
                    for(int x=0; x<tamXreal; x++){
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
                    
                /*
                JButton boton = grid[3][3];
                ActionListener action = new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						if (a) {
						setBotonTexto("yeah",4,4);
						a = false;
						} else {
							setBotonTexto("god",4,4);
							a = true;
						}
					}
                };
                
                boton.addActionListener(action);
                */
                
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
