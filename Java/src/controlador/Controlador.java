package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.*;
import vista.*;


public class Controlador implements ActionListener {
	FuncionesDB fun;
	VistaEmp empV;
	VistaGru gruV;
	VistaPro proV;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == empV.confirm){
			empleadoConfirm();
		}
		if(e.getSource() == empV.clean){
			empV.limpiar();
		}
		if(e.getSource() == empV.eliminar){
			empleadoDel(empV.list.getSelectedIndex());
		}
		if(e.getSource() == empV.info){
			info(empV.list.getSelectedIndex());
		}
	}
	
	public Controlador(VistaEmp emp , VistaGru gru , VistaPro pro) {
		this.empV = emp;
		this.gruV = gru;
		this.proV = pro;
		this.fun = new FuncionesDB();
		emp.registrarControlador(this);
		actualizarLista();
		//gru.registrarControlador(this);
		//pro.registrarControlador(this);
		
	}
	/* empleadoConfirm sin base de datos
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
	}*/
	private void empleadoConfirm(){
		String nombre , apellido , dni;
		float sueldo = 0;
		nombre = empV.getNombre();
		apellido = empV.getApellido();
		dni = empV.getDni();
		try{
			sueldo = Float.valueOf(empV.getSueldo());
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null, "error: Sueldo no es un numero.\n"
			, "Error", JOptionPane.ERROR_MESSAGE);
			empV.limpiar();
			return;
		}
		String operacion = "INSERT INTO empleado VALUES('"+dni+"','"+nombre+"','"+apellido+"','"+sueldo+"',null);";
		fun.actualizar(operacion);
		actualizarLista();
		empV.limpiar();
	}
	
	private void empleadoDel(int index){
		String dni = getDni(index);
		fun.actualizar("DELETE FROM `proyecto_lina`.`empleado` WHERE `dni`='" + dni + "';");
		actualizarLista();
	}
	
	private void info(int index){
		String dni = getDni(index);
		String info = "";
		ResultSet res = fun.consultar("SELECT * FROM empleado WHERE dni = '" + dni + "';");
		try {
			while(res.next()){
				info = "Nombre: " + res.getString("nombre") + "\n"
						+"Apellido: " + res.getString("apellido") + "\n"
						+"DNI: " + res.getString("dni") + "\n"
						+"Sueldo: " + res.getString("sueldo");
			}
		} catch (SQLException e) {}
		if(info.equals("")){
			info = "No se ha seleccionado ningun empleado";
		}
		JOptionPane.showMessageDialog(null, info);
	}
	
	private void actualizarLista(){
		int max = empV.listModel.getSize();
		for (int i = 0; i<max; i++){
			empV.listModel.removeElementAt(0);
		}
		String elemento;
		ResultSet resultado;
		try{
			resultado = fun.consultar("SELECT * FROM empleado");
			while(resultado.next()){
				elemento = resultado.getString("nombre");
				empV.listModel.addElement(elemento);
		}
		}catch(SQLException e){
			
		}
	}
	private String getDni(int index){
		ResultSet resultado;
		String dni = "";
		try{
			resultado = fun.consultar("SELECT * FROM empleado");
			for(int i = 0; resultado.next();i++){
				if(index == i){
					dni = resultado.getString("dni");
				}
			}
		}catch(SQLException e){}
		return dni;
	}
	
}
