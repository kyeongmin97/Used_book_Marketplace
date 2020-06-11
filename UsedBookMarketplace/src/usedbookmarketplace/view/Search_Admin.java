package usedbookmarketplace.view;

import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JButton;

import usedbookmarketplace.model.data.Book;

public class Search_Admin extends Search {
	
	public JButton deleteBtn = new JButton("Delete");
	
	public Search_Admin() {
		
	}
	
	public Search_Admin(Vector<Book> bookList) {
		super(bookList);		
		btnsPanel.add(deleteBtn);
	}
	
	@Override
	public void addActionListeners(ActionListener action) {
		super.addActionListeners(action);
		deleteBtn.addActionListener(action);
	}
}