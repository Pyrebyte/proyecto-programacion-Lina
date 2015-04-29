package vista;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import controlador.Controlador;

public class Test {

	public static void main(String[] args) {
		VistaEmp vistaE = new VistaEmp();
		VistaGru vistaG = new VistaGru();
		VistaPro vistaP = new VistaPro();
		Controlador control = new Controlador(vistaE, vistaG, vistaP);
		
		
		JFrame ventana = new JFrame("Base de Datos");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		MainVista panel = new MainVista();
		ventana.setContentPane(panel);
		ventana.setSize(540, 400);
		//ventana.setSize(530, 350);
		ventana.setResizable(false);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
		
	}
}

