package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.*;
import vista.*;


public class Controlador implements ActionListener {
	ArrayList<ModeloEmpl> empM;
	
	
	VistaEmp empV;
	VistaGru gruV;
	VistaPro proV;
	
	
	
	
	public Controlador(VistaEmp emp , VistaGru gru , VistaPro pro) {
		this.empV = emp;
		this.gruV = gru;
		this.proV = pro;
		
		empM = new ArrayList<ModeloEmpl>();
	}
	
	private void empleadoConfirm(){
		String dni = empV.getNombre();
		String nombre = empV.getNombre();
		String apellido = empV.getApellido();
		String sueldo1 = empV.getSueldo();
		float sueldo2;
		
		if(dni == ""){
			JOptionPane.showMessageDialog(null, "Introduce un DNI.");
			return;
		}
		if(nombre == ""){
			JOptionPane.showMessageDialog(null, "Introduce un nombre.");
			return;
		}
		if(apellido == ""){
			JOptionPane.showMessageDialog(null, "Introduce un apellido.");
			return;
		}
		try{
			sueldo2 = Float.valueOf(sueldo1);
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null, "El sueldo no es un número válido.");
			return;
		}
		sueldo2 = Float.valueOf(sueldo1);
		empM.add(new ModeloEmpl(dni , nombre , apellido , sueldo2));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == empV.confirm){
			empleadoConfirm();
		}
	}
}
