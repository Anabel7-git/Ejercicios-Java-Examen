package repasoExamen;

import javax.swing.JOptionPane;

public class Ej1 {

	public static void main(String[] args) {
	
		JOptionPane.showMessageDialog(null, "Cálculo IMC: ");
		String peso=JOptionPane.showInputDialog(null, "Introduce tu peso en kg: ");
		String altura=JOptionPane.showInputDialog(null, "Introduce la altura metros: ");
		double pesoD=Double.parseDouble(peso);
		double alturaD=Double.parseDouble(altura);
		
		double IMC=pesoD/(alturaD*alturaD);
		
		JOptionPane.showMessageDialog(null, "Tu IMC es de: "+ String.format("%.2f", IMC));
		
	}

}
