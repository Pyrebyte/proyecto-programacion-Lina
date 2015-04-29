package modelo;

import java.util.ArrayList;

public class ModeloEmpl {
	String dni;
	String nombre;
	String apellido;
	float sueldo;
	
	public void setTodo(String dni, String nombre , String apellido , float sueldo){
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.sueldo = sueldo;
	}
	
	public void setDni(String flag){this.dni = flag;}
	public void setNombre(String flag){this.nombre = flag;}
	public void setApellido(String flag){this.nombre = flag;}
	public void setSueldo(float flag){this.sueldo = flag;}
	
	public void modSueldo(float flag){this.sueldo += flag;}
	
	public String getDni(){return this.dni;}
	public String getNombre(){return this.nombre;}
	public String getApellido(){return this.apellido;}
	public float getSueldo(){return this.sueldo;}
	
	public ModeloEmpl(){
		
	}
	
	public ModeloEmpl(String dni , String nombre , String apellido , float sueldo){
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.sueldo = sueldo;
	}
	public ModeloEmpl(String dni){
		this(dni,null,null,0);
	}
	public ModeloEmpl(String dni , float sueldo){
		this(dni,null,null,sueldo);
	}
	public ModeloEmpl(String dni , String nombre , String apellido){
		this(dni,nombre,apellido,0);
	}
	
	
}
