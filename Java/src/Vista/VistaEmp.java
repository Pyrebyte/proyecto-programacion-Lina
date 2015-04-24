package Vista;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class VistaEmp extends JPanel{
	VistaEmpForm formEmp;
	VistaLista listaEmp;
	
	VistaEmp(){
		setLayout(new GridLayout(1,2));
		formEmp = new VistaEmpForm();
		listaEmp = new VistaLista();
		add(formEmp);
		add(listaEmp);
		
	}
}