package modelo;

public class ModeloGrup {
	int codigoGrupo;
	String nombre;
	
	public void setNombre(String flag){this.nombre = flag;}
	
	public int getCodigo(){return this.codigoGrupo;}
	public String getNombre(){return this.nombre;}
	
	public ModeloGrup(int cod , String nombre){
		this.codigoGrupo = cod;
		this.nombre = nombre;
	}
	
	public ModeloGrup(int cod){
		this(cod , "");
	}
}
