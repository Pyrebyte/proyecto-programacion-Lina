package Vista;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JList;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractListModel;

@SuppressWarnings("serial")
public class VistaLista extends JPanel {
	protected JButton btninfo;
	protected JButton btnEliminar;
	@SuppressWarnings("rawtypes")
	private JList list;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public VistaLista() {
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(45, 11, 180, 260);
		add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));

		list = new JList(new String[] { "1", "2" });
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"1", "2", "3", "4", "5"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		panel.add(list);

		btninfo = new JButton("+ INFO");
		btninfo.setBounds(45, 295, 80, 23);
		add(btninfo);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEliminar.setBounds(145, 295, 80, 23);
		add(btnEliminar);

		setBackground(Color.gray);
	}
}
