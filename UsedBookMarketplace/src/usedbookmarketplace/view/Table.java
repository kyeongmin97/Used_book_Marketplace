package usedbookmarketplace.view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public abstract class Table extends JPanel {
	protected DefaultTableModel model;
	protected JTable table = new JTable(model);

	protected JPanel btnsPanel = new JPanel();
	public JButton logoutBtn = new JButton("Logout");
	
	public Table() {
		btnsPanel.add(logoutBtn);
	}
	
	// update table
	public abstract <T> void updateTable(Vector<T> data);
	
	public void addActionListeners(ActionListener action) {
		logoutBtn.addActionListener(action);
	}
	
	public JTable getTable() {
		return table;
	}
	public DefaultTableModel getModel() {
		return model;
	}
}
