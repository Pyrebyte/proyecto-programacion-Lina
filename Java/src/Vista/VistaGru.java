package vista;

import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JList;
import javax.swing.AbstractListModel;

import java.awt.GridLayout;

import javax.swing.JLabel;

public class VistaGru extends JPanel{
	public JButton insertar;
	public JButton eliminar;
	public DefaultListModel modelGru;
	public JList gruposList;
	public JList empGruList;
	public DefaultListModel modelEmpGru;
	public JList empleadosList;
	public DefaultListModel modelEmp;
	public JTextField grupoT;
	public JButton crearGrupo;
	
	public VistaGru(){
		setLayout(null);
		
		setBackground(Color.gray);
		
		JPanel panelEmpGru = new JPanel();
		panelEmpGru.setBounds(340, 31, 180, 300);
		add(panelEmpGru);
		panelEmpGru.setLayout(new GridLayout(0, 1, 0, 0));
		
		modelEmpGru = new DefaultListModel();
		empGruList = new JList();
		empGruList.setModel(modelEmpGru);
		panelEmpGru.add(empGruList);
		
		JPanel panel_Gru = new JPanel();
		panel_Gru.setBounds(10, 60, 198, 81);
		add(panel_Gru);
		panel_Gru.setLayout(new GridLayout(1, 0, 0, 0));
		
		modelGru = new DefaultListModel();
		gruposList = new JList();
		gruposList.setModel(modelGru);
		panel_Gru.add(gruposList);
		
		//panel.add(new JScrollPane(list));
		
		JPanel panelEmp = new JPanel();
		panelEmp.setBounds(10, 207, 198, 124);
		add(panelEmp);
		panelEmp.setLayout(new GridLayout(1, 0, 0, 0));
		
		modelEmp = new DefaultListModel();
		JList empleadosList = new JList();
		empleadosList.setModel(modelEmp);
		panelEmp.add(new JScrollPane(empleadosList));
		
		insertar = new JButton(">");
		insertar.setBounds(241, 207, 50, 50);
		add(insertar);
		
		eliminar = new JButton("<");
		eliminar.setBounds(241, 281, 50, 50);
		add(eliminar);
		
		JLabel gruposL = new JLabel("Grupos: ");
		gruposL.setBounds(10, 11, 80, 14);
		add(gruposL);
		
		JLabel empleadosL = new JLabel("Empleados: ");
		empleadosL.setBounds(10, 182, 80, 14);
		add(empleadosL);
		
		JLabel lblEmpleadosDelGrupo = new JLabel("Empleados del grupo:");
		lblEmpleadosDelGrupo.setBounds(340, 11, 180, 14);
		add(lblEmpleadosDelGrupo);
		
		grupoT = new JTextField();
		grupoT.setBounds(10, 31, 86, 20);
		add(grupoT);
		grupoT.setColumns(10);
		
		crearGrupo = new JButton("Crear Grupo");
		crearGrupo.setBounds(106, 31, 102, 23);
		add(crearGrupo);
		
		JButton btnSeleccionarGrupo = new JButton("Seleccionar grupo");
		btnSeleccionarGrupo.setBounds(10, 148, 198, 23);
		add(btnSeleccionarGrupo);
	}
	public void registrarControlador(ActionListener e){
		insertar.addActionListener(e);
		eliminar.addActionListener(e);
		crearGrupo.addActionListener(e);
	}
	
}

	