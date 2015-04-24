package Vista;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;

import java.awt.FlowLayout;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class VistaEmpForm extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	public VistaEmpForm() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre: ");
		lblNewLabel.setBounds(35, 55, 80, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Apellido: ");
		lblNewLabel_1.setBounds(35, 110, 80, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("DNI: ");
		lblNewLabel_2.setBounds(35, 165, 80, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Sueldo: ");
		lblNewLabel_3.setBounds(35, 220, 80, 14);
		add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.setBounds(25, 275, 100, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Limpiar");
		btnNewButton_1.setBounds(135, 275, 100, 23);
		add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(125, 52, 100, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(125, 107, 100, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(125, 162, 100, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(125, 217, 100, 20);
		add(textField_3);
		textField_3.setColumns(10);
		
		setBackground(Color.gray);
		
	}
}
