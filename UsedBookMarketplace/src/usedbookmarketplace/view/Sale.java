package usedbookmarketplace.view;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import usedbookmarketplace.model.data.Book;

public class Sale extends Table{
	
	private JButton registerBtn = new JButton("Register");
	private JButton modifyBtn = new JButton("Modify");
	private JButton deleteBtn = new JButton("Delete");
	private JButton logoutBtn = new JButton("Logout");
	
	public Sale() {
		
	}	
	
	public Sale (Vector<Book> bookList) {
		super();

		// setting table
		String[] colName = { "Title", "Author", "Publisher", "Publication Year", "ISBN", "Price", "Book State", "Seller ID", "Is Sold" };
		model = new DefaultTableModel(null, colName) {
			public boolean isCellEditable(int r, int c) {
				return false;
			}
		};
		table = new JTable(model);
		table.getColumn("Publication Year").setPreferredWidth(100);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		updateTable(bookList);
		
		JScrollPane scroll = new JScrollPane(table);
		scroll.setPreferredSize(new Dimension(640, 480));
		
		// setting button
		btnsPanel.add(registerBtn);
		btnsPanel.add(modifyBtn);
		btnsPanel.add(deleteBtn);
		btnsPanel.add(logoutBtn);
		
		// add components
		add(btnsPanel);
		add(scroll);
	}
	
	@Override
	public <T> void updateTable(Vector<T> data) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void addActionListeners(ActionListener action) {
		registerBtn.addActionListener(action);
		modifyBtn.addActionListener(action);
		deleteBtn.addActionListener(action);
		logoutBtn.addActionListener(action);
	}
	
	public JButton getRegisterBtn() {	return registerBtn;	}
	public JButton getModifyBtn() {		return modifyBtn;	}
	public JButton getDeleteBtn() {		return deleteBtn;	}
	public JButton getLogoutBtn() {		return logoutBtn;	}
}
