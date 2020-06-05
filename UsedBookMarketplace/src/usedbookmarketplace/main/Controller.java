package usedbookmarketplace.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import usedbookmarketplace.model.data.user.GeneralUser;
import usedbookmarketplace.model.database.Database;
import usedbookmarketplace.view.MainFrame;
import usedbookmarketplace.view.Search;

public class Controller implements ActionListener {
	Database DB;
	MainFrame view;

	public Controller(Database db, MainFrame view) {
		this.DB = db;
		this.view = view;

		view.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		try {
			// Class Login
			// login view : click login button
			if (event.getSource() == view.login.login_btn) {
				String id = view.login.getIDtxt();
				String pw = view.login.getPWtxt();

				if (id.equals("1") && pw.equals("1")){
					view.search = new Search(DB.getBookDB());
					view.search.addActionListeners(this);
					view.changeCard(view.search);
				}
			}
			// login view : click register button
			else if (event.getSource() == view.login.register_btn) {
				view.getCardLayout().show(view.getContentPane(), "REGISTER");
			}
			
			// Class Register
			// register view : click register button
			else if (event.getSource() == view.register.register_btn) {
				if (view.register.getIDtxt().isEmpty() || view.register.getPWtxt().isEmpty()
						|| view.register.getNametxt().isEmpty() || view.register.getEmailtxt().isEmpty()
						|| !view.register.getPhoneNumtxt().matches("[0-9|-]+"))
					throw new Exception();
				
				for (int i = 0; i < DB.getAccountDB().size(); i++) {
					if (view.register.getIDtxt().equals(DB.getAccountDB().get(i)))
						throw new Exception();
				}

				GeneralUser newUser = new GeneralUser(view.register.getAlltxt());
				DB.addUser(newUser);

				view.getCardLayout().show(view.getContentPane(), "LOGIN");
			}
			
			// Class Search
			else if(event.getSource() == view.search.searchBtn) {
				if (!view.search.getSearchtxt().isEmpty())
					if(view.search.isTitleSelected())
						view.search.updateTable(DB.searchByTitle(view.search.getSearchtxt()));
			}
			else if(event.getSource() == view.search.purchaseBtn) {
							
			}
			else if(event.getSource() == view.search.logoutBtn) {
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}