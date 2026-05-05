package repasoExamen;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Ej9 extends JFrame {

	private JComboBox peso, altura;
	private JTextField pesoT, alturaT;
	private JLabel pesoL, alturaL, IMC;
	private JButton calcular;

	public Ej9() {
		super("Calcular IMC");
		setSize(300, 300);
		setLayout(new FlowLayout());
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		peso = new JComboBox();
		altura = new JComboBox();

		for (int i = 20; i <= 150; i+=5) {
			peso.addItem(i);
		}
		peso.setSelectedItem(70);
		for (int i = 50; i <= 230; i+=2) {
			altura.addItem(i);
		}
		altura.setSelectedItem(170);
		peso.setMaximumRowCount(10);
		altura.setMaximumRowCount(10);
		pesoL = new JLabel("Introduce el peso(kg): ");
		alturaL = new JLabel("Introduce la alura(m): ");

		manejador Manejador = new manejador();
		peso.addActionListener(Manejador);
		altura.addActionListener(Manejador);

		calcular = new JButton("Calcular");
		calcular.addActionListener(Manejador);

		IMC = new JLabel();
	

		
		add(pesoL);
		add(peso);
		add(alturaL);
		add(altura);
		add(calcular);
		add(IMC);
		setVisible(true);
	}

	private class manejador implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == calcular) {
				Double p = Double.parseDouble(peso.getSelectedItem().toString());
				Double a = Double.parseDouble(altura.getSelectedItem().toString());
				double imcResultado = p / ((a / 100.0) * (a / 100.0));
				IMC.setText("Tu IMC es: " + String.format("%.2f", imcResultado));
			}

		}
	}
}
