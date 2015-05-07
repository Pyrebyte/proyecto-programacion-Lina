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
			empleadoInfo(empV.list.getSelectedIndex());
		}
		if (e.getSource() == proV.confirm){
			proyectoConfirm();
		}
		if (e.getSource() == proV.limpiar){
			proV.limpiar();
		}
		if (e.getSource() == proV.eliminar){
			proyectoDel(proV.list.getSelectedIndex());
		}
		if (e.getSource() == proV.info){
			proyectoInfo(proV.list.getSelectedIndex());
		}
	}
	
	public Controlador(VistaEmp emp , VistaGru gru , VistaPro pro) {
		this.empV = emp;
		this.gruV = gru;
		this.proV = pro;
		this.fun = new FuncionesDB();
		emp.registrarControlador(this);
		actualizarEmp();
		actualizarPro();
		//gru.registrarControlador(this);
		pro.registrarControlador(this);
	}
	
	
	private void empleadoConfirm(){
		String nombre , apellido , dni;
		float sueldo = 0;
		nombre = empV.getNombre();
		apellido = empV.getApellido();
		dni = empV.getDni();
		//comprobarDni(dni);
		try{
			sueldo = Float.valueOf(empV.getSueldo());
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null, "error: Sueldo no es un numero.\n"
			, "Error", JOptionPane.ERROR_MESSAGE);
			empV.sueldoT.setText("");
			return;
		}
		String operacion = "INSERT INTO empleado VALUES('"+dni+"','"+nombre+"','"+apellido+"','"+sueldo+"',null);";
		fun.actualizar(operacion);
		actualizarEmp();
		empV.limpiar();
	}
	
	private void empleadoDel(int index){
		String dni = getDni(index);
		if (!dni.equals("")){
			fun.actualizar("DELETE FROM `proyecto_lina`.`empleado` WHERE `dni`='" + dni + "';");
			actualizarEmp();
		}else{JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún empleado.");}
		
	}
	
	private void empleadoInfo(int index){
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
	
	private void proyectoConfirm(){
		String nombre = proV.nombre.getText();
		float presupuesto = 0;
		try{
			presupuesto = Float.valueOf(proV.presupuesto.getText());
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null, "error: Presupuesto no es un numero.\n"
					, "Error", JOptionPane.ERROR_MESSAGE);
					proV.presupuesto.setText("");
					return;
		}
		int cod = proCod();
		if (cod == -1){
			JOptionPane.showMessageDialog(null, "error: No se ha encontrado\n"+"ningún código disponible.\n"
					, "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		String operacion = "INSERT INTO proyecto VALUES ('"+cod+"', '" + presupuesto + "', '"+nombre+"');";
		fun.actualizar(operacion);
		actualizarPro();
		proV.limpiar();
		
	}

	private void proyectoDel(int index){
		int cod = getCod(index);
		System.out.println(cod);
		if (cod != -1){
			fun.actualizar("DELETE FROM `proyecto_lina`.`proyecto` WHERE `cod`='"+cod+"';");
			actualizarPro();
		}else{JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún proyecto.");}
		
	}
	
	private void proyectoInfo(int index){
		int cod = getCod(index);
		String info = "";
		ResultSet res; 
		res = fun.consultar("SELECT * FROM proyecto WHERE cod = '"+cod+"';");
		try {
			while(res.next()){
				info = "Codigo Interno: " + res.getInt("cod") + "\n"
					  +"Nombre: " + res.getString("nombre") + "\n"
					  +"Presupuesto: " + res.getString("presupuesto");
			}
		} catch (SQLException e) {}
		if (info.equals("")){
			info = "No se ha seleccionado ningún proyecto.";
		}
		JOptionPane.showMessageDialog(null, info);
	}
	
	
	//metodos internos:
	private void actualizarEmp(){
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
	private void actualizarPro(){
		int max = proV.listModel.getSize();
		for (int i = 0; i<max; i++){
			proV.listModel.removeElementAt(0);
		}
		String elemento;
		ResultSet resultado;
		try{
			resultado = fun.consultar("SELECT * FROM proyecto");
			while(resultado.next()){
				elemento = resultado.getString("nombre");
				proV.listModel.addElement(elemento);
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
	private int proCod(){
		int cod = 1;
		ResultSet codigos;
		
		try {
			//todos los codigos:
			codigos = fun.consultar("SELECT cod FROM proyecto ORDER BY cod");
			while(codigos.next()){
				//primer cod disponible:
				/*================================
				 * recorre todos los codigos HASTA
				 * encontrar un numero entero
				 * no usado como codigo.
				 *=================================*/
				if(cod != codigos.getInt("cod")){
					return cod;
				}
				else{
					cod++;
				}
			}
			return cod;
		} catch (SQLException e){return -1;}
	}
	private int getCod(int index){
		ResultSet resultado;
		int cod = -1;
		try{
			resultado = fun.consultar("SELECT * FROM proyecto");
			for(int i = 0; resultado.next();i++){
				if(index == i){
					cod = resultado.getInt("cod");
				}
			}
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		return cod;
		
	}
}
