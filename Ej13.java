package repasoExamen;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Ej13 extends JFrame {

	private JTable table;
	private DefaultTableModel modelo;
	private JLabel nombre, telefono;
	private JTextField nombreT, telefonoT;
	private JButton btnInsertar, btnEliminar;
	
	public Ej13() {
		
		//estructura
		super("Agenda de contactos");
		setSize(400,400);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		
		//eventos
		
		nombre=new JLabel("Nombre: ");
		telefono=new JLabel("Teléfono: ");
		nombreT=new JTextField(20);
		telefonoT=new JTextField(20);
		btnEliminar=new JButton("Eliminar");
		btnInsertar=new JButton("Insertar");
		
		
		modelo=new DefaultTableModel();
		modelo.addColumn("Nombre");
		modelo.addColumn("Teléfono");
		
		table=new JTable(modelo);
		JScrollPane scroll=new JScrollPane(table);
		scroll.setPreferredSize(new Dimension(350,200));
		
		Manejador manejador=new Manejador();
		btnEliminar.addActionListener(manejador);
		btnInsertar.addActionListener(manejador);
		
		add(nombre);
		add(nombreT);
		add(telefono);
		add(telefonoT);
		add(scroll);
		add(btnInsertar);
		add(btnEliminar);
		setVisible(true);
	}
	
	private class Manejador implements ActionListener{
	
		@Override
		public void actionPerformed(ActionEvent e) {
		
	
			if(e.getSource()==btnInsertar) {
				
				String n=nombreT.getText().trim();
				String t=telefonoT.getText().trim();
				
				if(n.isEmpty() || t.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor, rellena todos los campos");
				}
				else {
					modelo.addRow(new Object[] {n, t});
					nombreT.setText("");
					telefonoT.setText("");
				}
			}
			else if(e.getSource()==btnEliminar) {
				int filaSelec=table.getSelectedRow();
				if(filaSelec!=-1) {
					modelo.removeRow(filaSelec);
				}
				else {
					JOptionPane.showMessageDialog(null, "Selecciona una fila por favor");
				}
			}
			
		}
	}
}
