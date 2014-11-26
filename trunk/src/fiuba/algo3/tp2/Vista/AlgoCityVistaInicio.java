package fiuba.algo3.tp2.Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import fiuba.algo3.tp2.Controlador.AlgoCityControlador;

@SuppressWarnings("serial")
public class AlgoCityVistaInicio extends JFrame {

	private JPanel contentPane;
	private JSlider slider;
    AlgoCityControlador controlador;

	public AlgoCityVistaInicio() {
		setTitle("ALGO CITY 2014");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblAlgoCity = new JLabel("Algo City 2014");
		lblAlgoCity.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlgoCity.setFont(new Font("SonicCutThru Hv BT", Font.BOLD | Font.ITALIC, 38));
		
		JButton btnJugar_1 = new JButton("JUGAR");
		btnJugar_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnJugar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.clickeoJugar(getValorSlider());
				setVisible(false);
			}
		});
		
		JButton btnSalir_1 = new JButton("SALIR");
		btnSalir_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSalir_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		slider = new JSlider();
		slider.setValue(500000);
		slider.setMaximum(1000000);
		slider.setValue(500000);
		final JLabel lblNewLabel = new JLabel("$"+Integer.toString(slider.getValue()));
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				lblNewLabel.setText("$"+Integer.toString(slider.getValue()));
			}
		});
		
		JLabel label = new JLabel("$0");
		
		JLabel label_1 = new JLabel("$1000000");
		
		JLabel lblSaldoInicial = new JLabel("Saldo Inicial");
		lblSaldoInicial.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(lblAlgoCity, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(45)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(slider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
							.addComponent(lblSaldoInicial))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(label)
							.addGap(158)
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
							.addComponent(lblNewLabel))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnJugar_1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
							.addComponent(btnSalir_1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)))
					.addGap(47))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAlgoCity)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSalir_1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnJugar_1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
					.addGap(41)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(slider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSaldoInicial))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(label_1)
						.addComponent(lblNewLabel))
					.addContainerGap(26, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		JLabel lblAlgocity = new JLabel("AlgoCity 2014");
		lblAlgocity.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlgocity.setFont(new Font("SonicCutThru Hv BT", Font.BOLD | Font.ITALIC, 33));
		



	}

	public int getValorSlider(){
		return (slider.getValue());
	}

	public void setControlador(AlgoCityControlador Controlador) {
		controlador = Controlador;
	}

}
