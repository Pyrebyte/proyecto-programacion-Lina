package vista;

import javax.swing.JPanel;
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
	private JButton insertar;
	private JButton eliminar;
	private JList gruposList;
	
	public VistaGru(){
		setLayout(null);
		
		setBackground(Color.gray);
		
		JPanel panel = new JPanel();
		panel.setBounds(340, 11, 180, 320);
		add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JList list = new JList();
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 31, 180, 110);
		add(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		gruposList = new JList();
		gruposList.setModel(new AbstractListModel() {
			String[] values = new String[] {"1", "2", "3", "4", "5"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		panel_1.add(gruposList);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 170, 180, 161);
		add(panel_2);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));
		
		JList empleadosList = new JList();
		empleadosList.setModel(new AbstractListModel() {
			String[] values = new String[] {"1", "2", "3", "4", "5"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		panel_2.add(empleadosList);
		
		insertar = new JButton(">");
		insertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		insertar.setBounds(241, 170, 50, 50);
		add(insertar);
		
		eliminar = new JButton("<");
		eliminar.setBounds(241, 265, 50, 50);
		add(eliminar);
		
		JLabel gruposL = new JLabel("Grupos: ");
		gruposL.setBounds(10, 11, 80, 14);
		add(gruposL);
		
		JLabel empleadosL = new JLabel("Empleados: ");
		empleadosL.setBounds(10, 151, 80, 14);
		add(empleadosL);
		
		
	}
}
