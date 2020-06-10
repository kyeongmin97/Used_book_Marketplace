package usedbookmarketplace.view;

import java.awt.CardLayout;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class MainFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private CardLayout card = new CardLayout();
	public Login login = new Login();
	public Menu menu = new Menu();
	public Register register = new Register();
	public Search_GeneralUser search = new Search_GeneralUser();
	public Search_Admin search_admin = new Search_Admin();
	private Sale sale = new Sale();
	private AccountPanel accountPanel = new AccountPanel();
	


	public MainFrame(){
		
		setLayout(card);
		this.add("LOGIN", login);
		this.add("REGISTER", register);
		this.add("MENU", menu);
		//this.add("SEARCH", search);
		
		setTitle("Used-book Marketplace");
		setSize(800, 600);
		setLocation(200, 100);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setVisible(true);
	}
	
	public void addActionListener(ActionListener action) {
		login.addActionListeners(action);
		register.addActionListeners(action);
		//menu.addActionListeners(action);
		//search.addActionListeners(action);
		//...
	}
	
	public void setMenu(Menu _menu) {
		this.menu = _menu;
		this.add("MENU", _menu);
	}
	
	public void changeCardToSearch(Search _search) {
		this.add("SEARCH", _search);
		this.getCardLayout().show(this.getContentPane(), "SEARCH");
	}
	public void changeCardToSale(Sale _sale) {
		this.add("SALE", _sale);
		this.getCardLayout().show(this.getContentPane(), "SALE");
	}
	public void changeCardToAccount(AccountPanel _account) {
		this.add("ACCOUNT", _account);
		this.getCardLayout().show(this.getContentPane(), "ACCOUNT");
	}
		
	public void setMessageFrame(String msg) {
		new messageFrame(msg);
	}
	
	// getter, setter
	public CardLayout getCardLayout()			{	return this.card;	}
	public AccountPanel getAccountPanel()		{	return accountPanel;	}
	public void setAccountPanel(AccountPanel manageAcc) {	this.accountPanel = manageAcc;	}
	public Sale getSale() 				{	return sale;	}
	public void setSale(Sale sale)		{	this.sale = sale;	}
}

class messageFrame extends JDialog {
	private static final long serialVersionUID = 1L;
	JLabel label = new JLabel("");
    public messageFrame(String str){
            getContentPane().add(label);
           
            label.setText(str.toString());
            label.setHorizontalAlignment(JLabel.CENTER);
            
            this.setSize(360,240);
            setLocation(300, 200);
            this.setModal(true);
            this.setVisible(true);
    }
}
