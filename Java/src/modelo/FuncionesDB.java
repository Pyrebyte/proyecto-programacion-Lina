package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

public class FuncionesDB {

	private static final String DRIVER = "com.mysql.jdbc.Driver"; 
	private static final String URL = "jdbc:mysql://localhost/proyecto_lina"; 
	private static final String USUARIO = "usuario_proyecto"; 
	private static final String CLAVE = "pass";
	
	private Connection conexion; 
    private Statement sentencia; 
    
    public FuncionesDB() {
    	try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("Error driver" + e.getMessage()); 
			e.printStackTrace();
		} 
    	try {
			this.conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
		} catch (SQLException e) {
			System.out.println("Error de SQL" + e.getMessage()); 
			e.printStackTrace();
		} 
    	try {
			this.sentencia = this.conexion.createStatement();
		} catch (SQLException e) {
			System.out.println("Error de SQL" + e.getMessage()); 
			e.printStackTrace();
		}
    } 

	public Connection getConexion() {
		return conexion;
	}

	public Statement getSentencia() {
		return sentencia;
	}
	
	public void desconectar() {
		if (this.conexion != null) { 	 
    		try {
    			this.conexion.close();
    		} 
    		catch (SQLException e) {
    		} 	
    	} 
	}
	
	public void cerrarSentencia() {
		if (this.sentencia != null) { 	 
    		try {
    			this.sentencia.close();
    		} 
    		catch (SQLException e) {
    		} 
    	}
	}

	public int actualizar(String consultaSQL) { 
		
	    int filasAfectadas = 0; 
	   	try {
			filasAfectadas = this.sentencia.executeUpdate(consultaSQL);
		} catch (SQLException e) {
			System.out.println("Error de SQL" + e.getMessage()); 
			e.printStackTrace();
		} 
	    return filasAfectadas; 
	} 
	  
	public ResultSet consultar(String consultaSQL) { 
		 
	    ResultSet filas = null; 
	    try {
			filas = this.sentencia.executeQuery(consultaSQL);
		} catch (SQLException e) {
			System.out.println("Error de SQL" + e.getMessage()); 
			e.printStackTrace();
		} 
	    return filas; 
	}

	public void mostrarTabla(DefaultTableModel tabla, String sql){
        ResultSet resultado = null;
        tabla.setRowCount(0);
        tabla.setColumnCount(0);
        try {
            resultado = consultar(sql);
            if(resultado != null){
                int numeroColumna = resultado.getMetaData().getColumnCount();
                for(int k = 1;k <= numeroColumna;k++){	
                    tabla.addColumn(resultado.getMetaData().getColumnName(k));
                }
                while(resultado.next()){
                    Object [] objetos = new Object[numeroColumna];
                    for(int i = 1;i <= numeroColumna;i++){
                        objetos[i-1] = resultado.getObject(i);
                    }
                    tabla.addRow(objetos);
                }
            }
        } catch(SQLException e){
        	e.printStackTrace();
        }

        finally {
        	try
        	{
        		this.sentencia.close();
        		if(resultado != null)
        			resultado.close();
        	} catch (Exception e) {
        		e.printStackTrace();
        	}
        }
    }
}