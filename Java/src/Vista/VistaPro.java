package Vista;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class VistaPro extends JPanel{
	VistaProForm formEmp;
	VistaLista listaPro;
	
	VistaPro(){
		setLayout(new GridLayout(1,2));
		formEmp = new VistaProForm();
		listaPro = new VistaLista();
		add(formEmp);
		add(listaPro);
		
	}
}