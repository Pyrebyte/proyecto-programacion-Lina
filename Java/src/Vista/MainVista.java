package vista;

import java.awt.Color;

import javax.swing.JTabbedPane;


public class MainVista extends JTabbedPane {
	public VistaPro vPro;
	public VistaEmp vEmp;
	public VistaGru vGru;
	
	
	public MainVista() {
		
		vPro = new VistaPro();
		vEmp = new VistaEmp();
		vGru = new VistaGru();
		
		setBackground(Color.LIGHT_GRAY);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		addTab("Proyectos", null, vPro, null);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		addTab("Empleados", null, vEmp, null);
		
		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		addTab("Grupos", null, vGru, null);
		
		
	}

}
