package vista;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;

import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class VistaEmp extends JPanel {
	protected JPanel panelForm;
	public JTextField nombreT;
	public JTextField apellidoT;
	public JTextField dniT;
	public JTextField sueldoT;
	public JButton confirm;
	public JButton clean;
	
	protected JPanel panelLista;
	public DefaultListModel listModel;
	public JButton info;
	public JButton eliminar;
	public JList list;
	
	public String getNombre(){return nombreT.getText();}
	public String getApellido(){return apellidoT.getText();}
	public String getDni(){return dniT.getText();}
	public String getSueldo(){return sueldoT.getText();}
	
	
	public VistaEmp() {
		setLayout(new GridLayout(0,2));
		panelForm = new JPanel(null);
		
		JLabel nombreL = new JLabel("Nombre: ");
		nombreL.setBounds(35, 55, 80, 14);
		panelForm.add(nombreL);
		
		JLabel apellidoL = new JLabel("Apellido: ");
		apellidoL.setBounds(35, 110, 80, 14);
		panelForm.add(apellidoL);
		
		JLabel dniL = new JLabel("DNI: ");
		dniL.setBounds(35, 165, 80, 14);
		panelForm.add(dniL);
		
		JLabel sueldoL = new JLabel("Sueldo: ");
		sueldoL.setBounds(35, 220, 80, 14);
		panelForm.add(sueldoL);
		
		confirm = new JButton("Confirmar");
		confirm.setBounds(25, 275, 100, 23);
		panelForm.add(confirm);
		
		clean = new JButton("Limpiar");
		clean.setBounds(135, 275, 100, 23);
		panelForm.add(clean);
		
		nombreT = new JTextField();
		nombreT.setBounds(125, 52, 100, 20);
		panelForm.add(nombreT);
		nombreT.setColumns(10);
		
		apellidoT = new JTextField();
		apellidoT.setBounds(125, 107, 100, 20);
		panelForm.add(apellidoT);
		apellidoT.setColumns(10);
		
		dniT = new JTextField();
		dniT.setBounds(125, 162, 100, 20);
		panelForm.add(dniT);
		dniT.setColumns(10);
		
		sueldoT = new JTextField();
		sueldoT.setBounds(125, 217, 100, 20);
		panelForm.add(sueldoT);
		sueldoT.setColumns(10);
		
		panelForm.setBackground(Color.gray);
		
		//empieza lista:
		panelLista = new JPanel(null);

		JPanel panel = new JPanel();
		panel.setBounds(45, 11, 180, 260);
		panelLista.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		listModel = new DefaultListModel();
		list = new JList(listModel);
		panel.add(list);

		info = new JButton("+ INFO");
		info.setBounds(45, 295, 80, 23);
		panelLista.add(info);

		eliminar = new JButton("Eliminar");
		eliminar.setBounds(145, 295, 80, 23);
		panelLista.add(eliminar);

		panelLista.setBackground(Color.gray);
		
		add(panelForm);
		add(panelLista);
		
	}
	
	public void limpiar(){
		this.nombreT.setText("");
		this.apellidoT.setText("");
		this.dniT.setText("");
		this.sueldoT.setText("");
	}
	
	public void registrarControlador(ActionListener e){
		confirm.addActionListener(e);
		clean.addActionListener(e);
		eliminar.addActionListener(e);
		info.addActionListener(e);
	}
}
