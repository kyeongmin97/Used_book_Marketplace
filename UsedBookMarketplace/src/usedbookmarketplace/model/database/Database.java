package usedbookmarketplace.model.database;

import java.util.Vector;

import usedbookmarketplace.model.data.Book;
import usedbookmarketplace.model.data.user.GeneralUser;
import usedbookmarketplace.model.filesystem.FileProcess;

public class Database {

	private Vector<Book> bookDB = new Vector<Book>();
	private Vector<GeneralUser> accountDB = new Vector<GeneralUser>();
	private FileProcess file = new FileProcess();
	
	public Database() {
		bookDB = file.readBookFile("DB_book.txt");
		accountDB = file.readAccountFile("DB_account.txt");

		for (int i = 0; i < bookDB.size(); i++) {
			for (int j = 0; j < accountDB.size(); j++) {
				if (bookDB.get(i).getSellerID().equals(accountDB.get(j).getID())) {
					accountDB.get(j).addBook(bookDB.get(i));
				}
			}
		}
	}
	
	public void addUser(GeneralUser newUser) {
		accountDB.add(newUser);
		file.writeFile(newUser.getGeneralUserInfo(), "DB_account.txt");
	}
	
	public Vector<Book> getBookDB(){
		return bookDB;
	}
	
	public Vector<GeneralUser> getAccountDB(){
		return accountDB;
	}
}
