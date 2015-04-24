package Vista;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class Test {

	public static void main(String[] args) {
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

