package repasoExamen;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;

public class Ej11 extends JFrame {

	private JScrollBar peso, altura;
	private JLabel pesoL, alturaL;
	private JButton btnCalcular;
	private JTextField pesoT, alturaT, imc2;

	public Ej11() {

		super("Cálculo IMC");
		setLayout(new FlowLayout());
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 400);

		peso = new JScrollBar(JScrollBar.HORIZONTAL, 70, 2, 20, 160);
		peso.setBlockIncrement(2);
		peso.setUnitIncrement(2);
		altura = new JScrollBar(JScrollBar.HORIZONTAL, 170, 2, 50, 240);
		altura.setBlockIncrement(2);
		altura.setUnitIncrement(2);
		pesoL = new JLabel("Peso");
		alturaL = new JLabel("Altura");
		btnCalcular = new JButton("Calcular IMC: ");

		imc2=new JTextField(20);
		imc2.setEditable(false);
		pesoT = new JTextField(30);
		pesoT.setEditable(false);
		peso.addAdjustmentListener(new manejadorSlider());
		alturaT = new JTextField(30);
		alturaT.setEditable(false);
		altura.addAdjustmentListener(new manejadorSlider());
		
		btnCalcular.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int p=peso.getValue();
				int a=altura.getValue();
				double altMetros=a/100.0;
				double imc=p/(altMetros*altMetros);
				imc2.setText(String.format("%.2f", imc));
				
			}

		});
		add(pesoL);
		add(pesoT);
		add(peso);
		add(alturaL);
		add(alturaT);
		add(altura);
		pesoT.setText("70");
		alturaT.setText("170");
		add(imc2);
		add(btnCalcular);
		setVisible(true);
	}

	private class manejadorSlider implements AdjustmentListener {

		@Override
		public void adjustmentValueChanged(AdjustmentEvent e) {

			if(e.getSource()==peso) {
				pesoT.setText(String.valueOf(peso.getValue()));
			}
			else if(e.getSource()==altura) {
				alturaT.setText(String.valueOf(altura.getValue()));
			}

		}
	}
}
