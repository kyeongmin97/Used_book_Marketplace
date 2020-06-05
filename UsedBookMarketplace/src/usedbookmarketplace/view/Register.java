package usedbookmarketplace.view;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Register extends JPanel {

	public JButton register_btn;
	
	private JLabel id_label, pw_label, name_label, phoneNum_label, email_label;
	private JTextField id_txtf, name_txtf, phoneNum_txtf, email_txtf;
	private JPasswordField pw_pwf;

	//������
	public Register() {		
		id_label = new JLabel("ID :"); 
		pw_label = new JLabel("PW :");
		name_label = new JLabel("Use Name :");
		phoneNum_label = new JLabel("Phone Number :");
		email_label = new JLabel("E-mail :");
		
		id_txtf = new JTextField(15);
		pw_pwf = new JPasswordField(15);
		name_txtf = new JTextField(15);
		phoneNum_txtf = new JTextField(15);
		email_txtf = new JTextField(15);
		
		register_btn = new JButton("Register");
		
		setLayout(null);
		
		id_label.setBounds(160, 100, 100, 20); id_label.setHorizontalAlignment(JLabel.RIGHT);
		pw_label.setBounds(160, 130, 100, 20);  pw_label.setHorizontalAlignment(JLabel.RIGHT);
		name_label.setBounds(160, 160, 100, 20); name_label.setHorizontalAlignment(JLabel.RIGHT);
		phoneNum_label.setBounds(160, 190, 100, 20); phoneNum_label.setHorizontalAlignment(JLabel.RIGHT);
		email_label.setBounds(160, 220, 100, 20); email_label.setHorizontalAlignment(JLabel.RIGHT);
		
		id_txtf.setBounds(280, 100, 120, 20);
		pw_pwf.setBounds(280, 130, 120, 20);
		name_txtf.setBounds(280, 160, 120, 20);
		phoneNum_txtf.setBounds(280, 190, 120, 20);
		email_txtf.setBounds(280, 220, 120, 20);
		
		register_btn.setOpaque(false);
		register_btn.setBounds(230, 280, 175, 35);
		
		add(id_label);
		add(id_txtf);
		add(pw_label);
		add(pw_pwf);
		add(name_label);
		add(name_txtf);
		add(phoneNum_label);
		add(phoneNum_txtf);
		add(email_label);
		add(email_txtf);
		add(register_btn);
		
	}
	
	public void addActionListeners(ActionListener action){
		register_btn.addActionListener(action);
	}
	
	public String[] getAlltxt() {
		String[] tokens = new String[5];
		
		tokens[0] = id_txtf.getText();
		tokens[1] = new String(pw_pwf.getPassword());
		tokens[2] = name_txtf.getText();
		tokens[3] = phoneNum_txtf.getText();
		tokens[4] = email_txtf.getText();
		
		return tokens;
	}
	
	public String getIDtxt() {
		return id_txtf.getText();
	}
	
	public String getPWtxt() {
		return new String(pw_pwf.getPassword());
	}
	
	public String getNametxt() {
		return name_txtf.getText();
	}
	
	public String getPhoneNumtxt() {
		return phoneNum_txtf.getText();
	}
	
	public String getEmailtxt() {
		return email_txtf.getText();
	}
}
