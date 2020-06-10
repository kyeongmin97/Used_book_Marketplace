package usedbookmarketplace.view;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;

import usedbookmarketplace.model.data.Book;

public class Search extends Table {

	public JButton searchBtn = new JButton("Search");
//	public JButton purchaseBtn = new JButton("Purchase");
//	public JButton logoutBtn = new JButton("Logout");

	private JTextField searchtxt = new JTextField(30);
	private JRadioButton titleRBtn = new JRadioButton("Title", true);
	private JRadioButton authorRBtn = new JRadioButton("Author");
	private JRadioButton isbnRBtn = new JRadioButton("ISBN");
	private JRadioButton selleridRBtn = new JRadioButton("Seller ID");
//
//	private String[] colName = { "Title", "Author", "Publisher", "Publication Year", "ISBN", "Price", "Book State",
//			"seller ID", "" };
//	private DefaultTableModel model = new DefaultTableModel(null, colName) {
//		public boolean isCellEditable(int r, int c) {
//			return false;
//		}
//	};
//	private JTable table = new JTable(model);

	// constructor
	public Search() {

	}

	public Search(Vector<Book> bookList) {
		super();

		// setting table
		String[] colName = { "Title", "Author", "Publisher", "Publication Year", "ISBN", "Price", "Book State", "seller ID", "" };
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
		
		
		// setting radio buttons
		JPanel radioBtnsPanel = new JPanel();
		ButtonGroup searchFilter = new ButtonGroup();
		searchFilter.add(titleRBtn);
		searchFilter.add(authorRBtn);
		searchFilter.add(isbnRBtn);
		searchFilter.add(selleridRBtn);
		radioBtnsPanel.add(titleRBtn);
		radioBtnsPanel.add(authorRBtn);
		radioBtnsPanel.add(isbnRBtn);
		radioBtnsPanel.add(selleridRBtn);

		// setting button
		btnsPanel.add(searchBtn);
		
		// add components
		add(searchtxt);
		add(radioBtnsPanel);
		add(btnsPanel);
		add(scroll);
	}


	public <T> void updateTable(Vector<T> bookList) {
		model = (DefaultTableModel) table.getModel();
		model.setNumRows(0);

		for (int i = 0; i < bookList.size(); i++) {
			String[] bookInfo = ((Book)bookList.get(i)).getBookInfo();
			model.addRow(new Object[] { bookInfo[0], bookInfo[1], bookInfo[2], bookInfo[3], bookInfo[4],
										bookInfo[5], bookInfo[6], bookInfo[7], bookInfo[8] });
		}

		table.setModel(model);
	}
	
	// add the actionListener to buttons
	@Override
	public void addActionListeners(ActionListener action) {
		super.addActionListeners(action);
		searchBtn.addActionListener(action);
//		purchaseBtn.addActionListener(action);
//		logoutBtn.addActionListener(action);
	}

//	 //update table
//	public void updateTable(Vector<Book> bookList) {
//		model = (DefaultTableModel) table.getModel();
//		model.setNumRows(0);
//
//		for (int i = 0; i < bookList.size(); i++) {
//			String[] bookInfo = bookList.get(i).getBookInfo();
//			model.addRow(new Object[] { bookInfo[0], bookInfo[1], bookInfo[2], bookInfo[3], bookInfo[4],
//										bookInfo[5], bookInfo[6], bookInfo[7], bookInfo[8] });
//		}
//
//		table.setModel(model);
//	}

	// getter, setter
	public String getSearchTxt() {
		return searchtxt.getText();
	}
//	public JTable getTable() {
//		return table;
//	}
//	public DefaultTableModel getModel() {
//		return model;
//	}

	public boolean isTitleSelected() {
		return titleRBtn.isSelected();
	}

	public boolean isAuthorSelected() {
		return authorRBtn.isSelected();
	}

	public boolean isISBNSelected() {
		return isbnRBtn.isSelected();
	}

	public boolean isSellerIDSelected() {
		return selleridRBtn.isSelected();
	}
}
