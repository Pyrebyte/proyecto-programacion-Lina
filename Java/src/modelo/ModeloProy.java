package modelo;

public class ModeloProy {
	int codigoPro;
	float presupuesto;
	String nombre;
	
	public void setPresupuesto(float pres){this.presupuesto = pres;}
	public void setNombre(String nombre){this.nombre = nombre;}
	
	public float getPresupuesto(){return this.presupuesto;}
	public String getNombre(){return this.nombre;}
	public int getCod(){return this.codigoPro;}
	
	public ModeloProy(int codigo , float pres , String nombre){
		this.codigoPro = codigo;
		this.presupuesto = pres;
		this.nombre = nombre;
	}
	public ModeloProy(int codigo , float pres){
		this(codigo,pres,"Sin Nombre");
	}
	public ModeloProy(int codigo , String nombre){
		this(codigo,0,nombre);
	}
}
