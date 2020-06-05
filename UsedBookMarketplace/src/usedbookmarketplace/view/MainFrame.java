package usedbookmarketplace.view;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainFrame extends JFrame{
	private CardLayout card = new CardLayout();
	public Login login = new Login();
	public Register register = new Register();
	public Search search = new Search();

	public MainFrame(){
		
		setLayout(card);
		this.add("LOGIN", login);
		this.add("REGISTER", register);
		this.add("SEARCH", search);
		
		setTitle("Used-book Marketplace");
		setSize(640, 480);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setVisible(true);
	}
	
	public void addActionListener(ActionListener action) {
		login.addActionListeners(action);
		register.addActionListeners(action);
		//...
	}
	
	public CardLayout getCardLayout(){
		return this.card;
	}
}
