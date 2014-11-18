package fiuba.algo3.tp2.Vista;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import fiuba.algo3.tp2.Controlador.AlgoCityControlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class AlgoCityVista extends JFrame {
		
        miJbutton[][] grid; 
        JLabel[] gridLabel;
        AlgoCityControlador controlador;
        
        public AlgoCityVista(int tamanioJuego){ 
        		Font unfont;
        		setTitle("AlgoCity");
        		setResizable(false);
        		float flot;
        		Dimension dimen = new Dimension(80,50);
        		int tamanioGrilla = tamanioJuego + 2;
                setLayout(new GridLayout(tamanioGrilla,tamanioGrilla));
                grid=new miJbutton[tamanioGrilla][tamanioGrilla]; 
                gridLabel = new JLabel[13];
                for(int y=0; y<(tamanioGrilla); y++){
                        for(int x=0; x<(tamanioGrilla); x++){                          
                        		grid[x][y]=new miJbutton("nodeberiaestaresto"); 
                        		grid[x][y].setCoordenadas(x, y);
                        		grid[x][y].setPreferredSize(dimen);
                        		unfont = grid[x][y].getFont();
                        		flot = unfont.getSize2D();
                        		flot = (float) (flot/1.1);
                        		unfont = unfont.deriveFont(flot);
                        		grid[x][y].setFont(unfont);
                        		if (x==1 && (y>=0) && (y<13)){
                        			gridLabel[y] = new JLabel ("TOBESET");
                        			this.add(gridLabel[y]);
                        			} else {
                        				this.add(grid[x][y]);
                        			}
                        }
                }
                
                
                
                setBotonesMenu(tamanioGrilla);
                setBotonesLote(tamanioJuego);
                
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                pack(); 
                setVisible(true);
        }
        
        
        private void setBotonesMenu(int tamanioGrilla){
        	JButton botonTemporal;
            for(int y=0; y<tamanioGrilla; y++){
                for(int x=0; x<tamanioGrilla; x++){
                   	if ((x==0)||(x==1)) {
                		botonTemporal = grid[x][y];
                		botonTemporal.setVisible(false);
                	}
                	
                	if ((y==tamanioGrilla-1)||(y==tamanioGrilla-2)) {
                		botonTemporal = grid[x][y];
                		botonTemporal.setVisible(false);
                	}
                	
                	if ((x==0)&&(y<=12)) {
                		botonTemporal = grid[x][y];
                		botonTemporal.setVisible(true);
                	}
                }
            }
        	
        	 JLabel label;
             JButton boton = grid[0][0];
             boton.setText("<html>Proximo<br/>turno</html>");
             Font elfont = boton.getFont();
             float tama = elfont.getSize2D();
             tama = (float) (tama*1.2);
             elfont = elfont.deriveFont(tama);
             boton.setFont(elfont);
             ActionListener action = new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						controlador.proximoTurno();
					}
				};
				boton.addActionListener(action);
             
             
             
             boton = grid[0][1];
             boton.setText("<html>CASA</html>");
             boton.setFont(elfont);
             label = gridLabel[1];
             label.setText("$5");
             action = new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						controlador.SetProximoAConstruirCasa();
					}
				};
				boton.addActionListener(action);
             
             boton = grid[0][2];
             boton.setText("<html>COMER.</html>");
             boton.setFont(elfont);
             label = gridLabel[2];
             label.setText("$5");
             action = new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						controlador.SetProximoAConstruirComercio();
					}
				};
				boton.addActionListener(action);
             
             boton = grid[0][3];
             boton.setText("<html>INDUS.</html>");
             boton.setFont(elfont);
             label = gridLabel[3];
             label.setText("$10");
             action = new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						controlador.SetProximoAConstruirIndustria();;
					}
				};
				boton.addActionListener(action);
             
             boton = grid[0][4];
             boton.setText("<html>BOMB.</html>");
             boton.setFont(elfont);
             label = gridLabel[4];
             label.setText("$1500");
             action = new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						controlador.SetProximoAConstruirBomberos();
					}
				};
				boton.addActionListener(action);
             
             boton = grid[0][5];
             boton.setText("<html>Cent.<br/>Eolica</html>");
             boton.setFont(elfont);
             label = gridLabel[5];
             label.setText("$1000");
             action = new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						controlador.SetProximoAConstruirCentralEolica();;
					}
				};
				boton.addActionListener(action);
             
             boton = grid[0][6];
             boton.setText("<html>Cent.<br/>Mineral</html>");
             boton.setFont(elfont);
             label = gridLabel[6];
             label.setText("$3000");
             action = new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						controlador.SetProximoAConstruirCentralMineral();
					}
				};
				boton.addActionListener(action);
             

             boton = grid[0][7];
             boton.setText("<html>Cent.<br/>Nuclear</html>");
             boton.setFont(elfont);
             label = gridLabel[7];
             label.setText("$10000");
             action = new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						controlador.SetProximoAConstruirCentralNuclear();
					}
				};
				boton.addActionListener(action);

             boton = grid[0][8];
             boton.setText("<html>Ruta</html>");
             boton.setFont(elfont);
             label = gridLabel[8];
             label.setText("$10");
             action = new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						controlador.SetProximoAConstruirRuta();
					}
				};
				boton.addActionListener(action);
             

             boton = grid[0][9];
             boton.setText("<html>Linea<br/>Tension</html>");
             boton.setFont(elfont);
             label = gridLabel[9];
             label.setText("$5");
             action = new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						controlador.SetProximoAConstruirLineaDeTension();
					}
				};
				boton.addActionListener(action);
             

             boton = grid[0][10];
             boton.setText("<html>Ruta</html>");
             boton.setFont(elfont);
             label = gridLabel[10];
             label.setText("$10");
             action = new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						controlador.SetProximoAConstruirRuta();
					}
				};
				boton.addActionListener(action);
             

             boton = grid[0][11];
             boton.setText("<html>Tuberia</html>");
             boton.setFont(elfont);
             label = gridLabel[11];
             label.setText("$5");
             action = new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						controlador.SetProximoAConstruirTuberia();
					}
				};
				boton.addActionListener(action);
             

             boton = grid[0][12];
             boton.setText("<html>Pozo<br/>Agua</html>");
             boton.setFont(elfont);
             label = gridLabel[12];
             label.setText("$250");
             action = new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						controlador.SetProximoAConstruirPozoDeAgua();
					}
				};
				boton.addActionListener(action);
        
        }
        
        
        private void setBotonesLote(int tamanioJuego){
        	JButton boton;
        	ActionListener escuchador;
        	escuchador = new ActionListener(){
        		@Override
        		public void actionPerformed(ActionEvent e){
        			miJbutton botoncito =(miJbutton) e.getSource();
        			int x = botoncito.getcoordX();
        			int y = botoncito.getcoordY();
        			controlador.construirEnCoordenadas(x-2, y);
        			controlador.actualizarVista();
        		}
        	};
     
        	for (int i=0; i<tamanioJuego; i++){
        		for (int j=0; j<tamanioJuego; j++){
        			boton = grid[i+2][j];
        			boton.addActionListener(escuchador);
        		}
        	}
        	
        }
        
        public void setBotonTexto(String string, int x, int y){
        	JButton temp = grid[x][y];
        	temp.setText(string);
        }
        
        public void msgbox(String s){
        	   JOptionPane.showMessageDialog(null, s);
        	}
        
        public void setSaldo(int x){
        	JLabel label = gridLabel[0];
        	String string = Integer.toString(x);
            label.setText("$"+string);
        }
        
        public void setControlador(AlgoCityControlador unControlador){
        	controlador = unControlador;
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
