package usedbookmarketplace.main;

import usedbookmarketplace.model.database.Database;
import usedbookmarketplace.view.MainFrame;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Database db = new Database();
		MainFrame view = new MainFrame();
		new Controller(db, view);
		
	}

}
