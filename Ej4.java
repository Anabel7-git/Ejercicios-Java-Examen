package repasoExamen;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Ej4 extends JFrame {

	private JTextField nombreT, email;
	private JPasswordField contrasenia, contraseniaRep;
	private JLabel nombreL, emailL, contraseniaL, contraseniaRepL;

	public Ej4() {

		super("Formulario Alta");
		setLayout(new FlowLayout());
		setSize(400, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		nombreL = new JLabel("Nombre");
		emailL = new JLabel("Email");
		contraseniaL = new JLabel("Contraseña");
		contraseniaRepL = new JLabel("Repite contraseña");
		nombreT = new JTextField(30);
		email = new JTextField(30);
		contrasenia = new JPasswordField(20);
		contraseniaRep = new JPasswordField(20);

		manejador manejador = new manejador();

		nombreT.addActionListener(manejador);
		email.addActionListener(manejador);
		contrasenia.addActionListener(manejador);
		contraseniaRep.addActionListener(manejador);

		add(nombreL);
		add(nombreT);
		add(emailL);
		add(email);
		add(contraseniaL);
		add(contrasenia);
		add(contraseniaRepL);
		add(contraseniaRep);
		setVisible(true);
	}

	private class manejador implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			String nombre = nombreT.getText();
			String emailT = email.getText();
			String contraseniaT = new String(contrasenia.getPassword());
			String contraseniaRepT = new String(contraseniaRep.getPassword());

			if (nombre.isEmpty() || emailT.isEmpty() || contraseniaT.isEmpty() || contraseniaRepT.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Campo vacío", "Mensaje error", JOptionPane.WARNING_MESSAGE);
			} else if (Character.isUpperCase(nombre.charAt(0))) {
				JOptionPane.showMessageDialog(null, "Nombre válido");
			} else if (!Character.isUpperCase(nombre.charAt(0))) {
				JOptionPane.showMessageDialog(null, "Nombre no válido", "Mensaje Error", JOptionPane.ERROR_MESSAGE);
			} else if (emailT.contains("@") || !emailT.contains(".")) {
				JOptionPane.showMessageDialog(null, "Email válido");
			} else if (!emailT.contains("@") || !emailT.contains(".")) {
				JOptionPane.showMessageDialog(null, "Email no válido", "Mensaje Error", JOptionPane.ERROR_MESSAGE);
			} else if (contraseniaT.length() >= 8 && contraseniaRepT.length() >= 8) {
				if (contraseniaRepT.equals(contraseniaT)) {
					JOptionPane.showMessageDialog(null, "Contraseña válida");
				} else if (!contraseniaRepT.equals(contraseniaT)) {
					JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", "Mensaje Error",
							JOptionPane.ERROR_MESSAGE);
				}
			} else if (contraseniaT.length() < 8) {
				JOptionPane.showMessageDialog(null, "La contraseña tiene menos de 8 caracteres", "Mensaje Error",
						JOptionPane.ERROR_MESSAGE);
			} else if (contraseniaRepT.length() < 8) {
				JOptionPane.showMessageDialog(null, "La contraseña tiene menos de 8 caracteres", "Mensaje Error",
						JOptionPane.ERROR_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(null, "Gracias por darse de alta", "Éxito", JOptionPane.INFORMATION_MESSAGE);
		        
		      
		        nombreT.setText("");
		        email.setText("");
		        contrasenia.setText("");
		        contraseniaRep.setText("");
			}
		}
	}

}
