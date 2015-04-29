package vista;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractListModel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class VistaEmp extends JPanel {
	protected JPanel formulario;
	protected JTextField nombreT;
	protected JTextField apellidoT;
	protected JTextField dniT;
	protected JTextField sueldoT;
	public JButton confirm;
	public JButton clean;
	
	//empieza vistalista
	
	protected JPanel lista;
	protected JButton info;
	protected JButton eliminar;
	@SuppressWarnings("rawtypes")
	protected JList list;
	
	public String getNombre(){return nombreT.getText();}
	public String getApellido(){return apellidoT.getText();}
	public String getDni(){return dniT.getText();}
	public String getSueldo(){return sueldoT.getText();}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public VistaEmp() {
		setLayout(new GridLayout(0,2));
		formulario = new JPanel(null);
		
		JLabel nombreL = new JLabel("Nombre: ");
		nombreL.setBounds(35, 55, 80, 14);
		formulario.add(nombreL);
		
		JLabel apellidoL = new JLabel("Apellido: ");
		apellidoL.setBounds(35, 110, 80, 14);
		formulario.add(apellidoL);
		
		JLabel dniL = new JLabel("DNI: ");
		dniL.setBounds(35, 165, 80, 14);
		formulario.add(dniL);
		
		JLabel sueldoL = new JLabel("Sueldo: ");
		sueldoL.setBounds(35, 220, 80, 14);
		formulario.add(sueldoL);
		
		confirm = new JButton("Confirmar");
		confirm.setBounds(25, 275, 100, 23);
		formulario.add(confirm);
		
		clean = new JButton("Limpiar");
		clean.setBounds(135, 275, 100, 23);
		formulario.add(clean);
		
		nombreT = new JTextField();
		nombreT.setBounds(125, 52, 100, 20);
		formulario.add(nombreT);
		nombreT.setColumns(10);
		
		apellidoT = new JTextField();
		apellidoT.setBounds(125, 107, 100, 20);
		formulario.add(apellidoT);
		apellidoT.setColumns(10);
		
		dniT = new JTextField();
		dniT.setBounds(125, 162, 100, 20);
		formulario.add(dniT);
		dniT.setColumns(10);
		
		sueldoT = new JTextField();
		sueldoT.setBounds(125, 217, 100, 20);
		formulario.add(sueldoT);
		sueldoT.setColumns(10);
		
		formulario.setBackground(Color.gray);
		
		//empieza listavista:
		lista = new JPanel(null);

		JPanel panel = new JPanel();
		panel.setBounds(45, 11, 180, 260);
		lista.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));

		list = new JList(new String[] { "1", "2" });
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"1", "2", "3", "4", "5"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		panel.add(list);

		info = new JButton("+ INFO");
		info.setBounds(45, 295, 80, 23);
		lista.add(info);

		eliminar = new JButton("Eliminar");
		eliminar.setBounds(145, 295, 80, 23);
		lista.add(eliminar);

		lista.setBackground(Color.gray);
		
		add(formulario);
		add(lista);
		
	}
	
	public void addActionListener(ActionListener e){
		
	}
}
