package fiuba.algo3.tp2.Vista;
import javax.swing.*;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.*;

@SuppressWarnings("serial")
public class AlgoCityVista extends JFrame {
	
	private JTextField textField = new JTextField(15);
	private JButton quitButton = new JButton("QUIT");
	private JButton removeButton = new JButton("SacarTexto");
	
	public AlgoCityVista(){
		this.initUI();
	}
	
	public void initUI(){
		JPanel panel = new JPanel();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1024, 768);
		this.setTitle("AlgoCity");
		panel.add(textField);
		panel.add(quitButton);
		panel.add(removeButton);
		
		Color arg0 = new Color(17,155,0);
		panel.setBackground(arg0);
		
		
		ActionListener escuchadorParaBotonQUIT = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event) {
				textField.setText("jojo");
			}
		};
		quitButton.addActionListener(escuchadorParaBotonQUIT);
		
		ActionListener escuchadorParaButtonRemove = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event){
				textField.setVisible(false);
			}
		};
		removeButton.addActionListener(escuchadorParaButtonRemove);
		
		this.add(panel);

	}
	
	
}
