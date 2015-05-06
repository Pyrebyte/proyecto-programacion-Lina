package controlador;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import vista.MainVista;
import vista.VistaEmp;
import vista.VistaGru;
import vista.VistaPro;

public class Test {

	public static void main(String[] args) {
		MainVista panel = new MainVista();
		Controlador control = new Controlador(panel.vEmp, panel.vGru, panel.vPro);
		
		JFrame ventana = new JFrame("Base de Datos");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		ventana.setContentPane(panel);
		ventana.setSize(540, 400);
		//ventana.setSize(530, 350);
		ventana.setResizable(false);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
	}
}

