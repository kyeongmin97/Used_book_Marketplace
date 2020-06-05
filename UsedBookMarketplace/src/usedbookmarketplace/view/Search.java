package usedbookmarketplace.view;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;

import usedbookmarketplace.model.data.Book;

public class Search extends JPanel {
	private String[] colName = { "Title", "Author", "Publisher", "Publication Year", "ISBN", "Price", "Book State", "seller ID" };

	private DefaultTableModel model = new DefaultTableModel(null, colName){
        public boolean isCellEditable(int r, int c) {
            return false;
        }
    };
	private JTable table = new JTable(model);

	private JTextField searchField = new JTextField(30);
	private JRadioButton titleRBtn = new JRadioButton("Title");
	private JRadioButton authorRBtn = new JRadioButton("Author");
	private JRadioButton isbnRBtn = new JRadioButton("ISBN");
	private JRadioButton selleridRBtn = new JRadioButton("Seller ID");
	
	public JButton searchBtn = new JButton("Search");
	public JButton purchaseBtn = new JButton("Purchase");
	public JButton logoutBtn = new JButton("Logout");

	public Search() {

	}

	public Search(Vector<Book> bookList) {
		JPanel radioBtnsPanel = new JPanel();
		radioBtnsPanel.setLayout(new GridLayout(1, 4));
		ButtonGroup searchFilter = new ButtonGroup();
		searchFilter.add(titleRBtn);
		searchFilter.add(authorRBtn);
		searchFilter.add(isbnRBtn);
		searchFilter.add(selleridRBtn);
		
		radioBtnsPanel.add(titleRBtn);
		radioBtnsPanel.add(authorRBtn);
		radioBtnsPanel.add(isbnRBtn);
		radioBtnsPanel.add(selleridRBtn);

		JPanel btnsPanel = new JPanel();
		btnsPanel.setLayout(new GridLayout(1, 3));
		btnsPanel.add(searchBtn);
		btnsPanel.add(purchaseBtn);
		btnsPanel.add(logoutBtn);

		for (int i = 0; i < bookList.size(); i++) {
			String[] bookInfo = bookList.get(i).getAllBookInfo();
			model.addRow(new Object[] { bookInfo[0], bookInfo[1], bookInfo[2], bookInfo[3],
										bookInfo[4], bookInfo[5], bookInfo[6], bookInfo[7] });
		}
		
		table.getColumn("Publication Year").setPreferredWidth(100);
		table.getTableHeader().setReorderingAllowed(false);
	    table.getTableHeader().setResizingAllowed(false);
		
	    JScrollPane scroll = new JScrollPane(table);
	    scroll.setPreferredSize(new Dimension(640,480));
		
	    add(searchField, BorderLayout.WEST);
		add(radioBtnsPanel, BorderLayout.EAST);
		add(btnsPanel, BorderLayout.CENTER);
		add(scroll, BorderLayout.SOUTH);
	}
	
	public void addActionListeners(ActionListener action){
		searchBtn.addActionListener(action);
		purchaseBtn.addActionListener(action);
		logoutBtn.addActionListener(action);
	}
	
	public void updateTable(Vector<Book> bookList) {
		model = (DefaultTableModel)table.getModel();
		model.setNumRows(0);
		
		for (int i = 0; i < bookList.size(); i++) {
			String[] bookInfo = bookList.get(i).getAllBookInfo();
			model.addRow(new Object[] { bookInfo[0], bookInfo[1], bookInfo[2], bookInfo[3],
										bookInfo[4], bookInfo[5], bookInfo[6], bookInfo[7] });
		}
		
		table.setModel(model);
	}
	
	public String getSearchtxt() {	return searchField.getText();	}
	public boolean isTitleSelected() {	return titleRBtn.isSelected();	}
	public boolean isAuthorSelected() {	return authorRBtn.isSelected();	}
	public boolean isISBNSelected() {	return isbnRBtn.isSelected();	}
	public boolean isSellerIdSelected() {	return selleridRBtn.isSelected();	}
}