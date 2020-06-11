package usedbookmarketplace.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import usedbookmarketplace.model.data.Book;

public class Sale extends Table{

	private ManageBookDialog manageDialog; 
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

	public void showModifyDialog(Book book) {
		manageDialog = new ManageBookDialog(book);
	}
	
	@Override
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


class ManageBookDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	
	private JLabel title_label = new JLabel("Title :"); 
	private JLabel author_label = new JLabel("Author :");
	private JLabel publisher_label = new JLabel("Publisher :");
	private JLabel publicationYear_label = new JLabel("Publication Year :");
	private JLabel price_label = new JLabel("Price :");
	private JLabel bookState_label = new JLabel("Book State :");
	
	private JTextField title_txt, author_txt, publisher_txt, publicationYear_txt, price_txt, bookState_txt;
	private JButton btn = new JButton("temp");
	
    public ManageBookDialog(Book book){
    	
    	title_txt = new JTextField(book.getTitle());
    	author_txt = new JTextField(book.getAuthor());
    	publisher_txt = new JTextField(book.getPublisher());    	
    	publicationYear_txt = new JTextField(book.getPublicationYear());
    	price_txt = new JTextField(book.getPrice());
    	bookState_txt = new JTextField(book.getBookState());
    	
    	title_label.setBounds(160, 100, 100, 20); 		title_label.setHorizontalAlignment(JLabel.RIGHT);
    	author_label.setBounds(160, 130, 100, 20);  	author_label.setHorizontalAlignment(JLabel.RIGHT);
    	publisher_label.setBounds(160, 160, 100, 20); 	publisher_label.setHorizontalAlignment(JLabel.RIGHT);
    	publicationYear_label.setBounds(160, 190, 100, 20); publicationYear_label.setHorizontalAlignment(JLabel.RIGHT);
    	price_label.setBounds(160, 220, 100, 20); 		price_label.setHorizontalAlignment(JLabel.RIGHT);
    	bookState_label.setBounds(160, 250, 100, 20); 	bookState_label.setHorizontalAlignment(JLabel.RIGHT);
    	
    	title_txt.setBounds(280, 100, 120, 20);
    	author_txt.setBounds(280, 130, 120, 20);
    	publisher_txt.setBounds(280, 160, 120, 20);
    	publicationYear_txt.setBounds(280, 190, 120, 20);
    	price_txt.setBounds(280, 220, 120, 20);
    	bookState_txt.setBounds(280, 250, 120, 20);
    	
    	btn.setBounds(250, 300, 100, 35);
		
    	setLayout(null);
    	setLocation(300, 200);
        setSize(640,480);
        //setModal(true);
        setVisible(true);
        
    	add(title_label);			add(title_txt);
    	add(author_label);			add(author_txt);
    	add(publisher_label);		add(publisher_txt);
    	add(publicationYear_label);	add(publicationYear_txt);
    	add(price_label);			add(price_txt);
    	add(bookState_label);		add(bookState_txt);
        add(btn);
    }
    
    public void addActionListeners(ActionListener action) {
    	btn.addActionListener(action);
	}
}