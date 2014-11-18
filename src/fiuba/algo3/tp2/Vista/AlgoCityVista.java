package fiuba.algo3.tp2.Vista;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class AlgoCityVista extends JFrame {
		
        JButton[][] grid; 
        
        public AlgoCityVista(int width, int length){ 
        		Font unfont;
        		setTitle("AlgoCity");
        		setResizable(false);
        		float flot;
        		Dimension dimen = new Dimension(80,50);
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
                        		flot = (float) (flot/1.1);
                        		unfont = unfont.deriveFont(flot);
                        		grid[x][y].setFont(unfont);
                                this.add(grid[x][y]);
                        }
                }
                
                JButton botonTemporal;
                for(int y=0; y<tamYreal; y++){
                    for(int x=0; x<tamXreal; x++){
                       	if ((x==0)||(x==1)) {
                    		botonTemporal = grid[x][y];
                    		botonTemporal.setVisible(false);
                    	}
                    	
                    	if ((y==tamYreal-1)||(y==tamYreal-2)) {
                    		botonTemporal = grid[x][y];
                    		botonTemporal.setVisible(false);
                    	}
                    	
                    	if ((x==0)&&(y<=12)) {
                    		botonTemporal = grid[x][y];
                    		botonTemporal.setVisible(true);
                    	}
                    }
                }
                
                JButton boton22 = grid[0][0];
                boton22.setText("<html>Proximo<br/>turno</html>");
                Font elfont = boton22.getFont();
                float tama = elfont.getSize2D();
                tama = (float) (tama*1.2);
                elfont = elfont.deriveFont(tama);
                boton22.setFont(elfont);
                
                boton22 = grid[0][1];
                boton22.setText("<html>CASA</html>");
                boton22.setFont(elfont);
                
                boton22 = grid[0][2];
                boton22.setText("<html>COMER.</html>");
                boton22.setFont(elfont);
                
                boton22 = grid[0][3];
                boton22.setText("<html>INDUS.</html>");
                boton22.setFont(elfont);
                
                /*
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
                 */
                    
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
