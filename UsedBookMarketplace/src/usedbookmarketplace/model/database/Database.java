package usedbookmarketplace.model.database;

import java.util.ArrayList;
import java.util.Vector;

import usedbookmarketplace.model.data.Book;
import usedbookmarketplace.model.data.user.Admin;
import usedbookmarketplace.model.data.user.GeneralUser;
import usedbookmarketplace.model.data.user.User;
import usedbookmarketplace.model.filesystem.FileProcess;

public class Database {

	private Vector<Book> bookDB = new Vector<Book>();
	private Vector<User> accountDB = new Vector<User>();
	private FileProcess file = new FileProcess();
	private ArrayList<Integer> searchedIndex = new ArrayList<Integer>();
	
	public Database() {
		bookDB = file.readBookFile("DB_book.txt");
		accountDB = file.readAccountFile("DB_account.txt");

		for (int i = 0; i < bookDB.size(); i++) {
			for (int j = 0; j < accountDB.size() - 1; j++) {
				if (bookDB.get(i).getSellerID().equals(accountDB.get(j).getID())) {
					((GeneralUser)accountDB.get(j)).addBook(bookDB.get(i));
					bookDB.get(i).setSeller((GeneralUser)accountDB.get(j));
				}
			}
			searchedIndex.add(i);
		}
	}
	
	public void initSearchIndex() {
		searchedIndex = new ArrayList<Integer>();
		for (int i = 0; i < bookDB.size(); i++)
			searchedIndex.add(i);
	}
	
	public void addUser(User newUser) {
		accountDB.add(newUser);
		file.writeFile(accountDB, "DB_account.txt");
	}
	
	public void addBook() {
		
	}
	
	public void removeBook(int searchedIndex) {
		int realIndex = getRealIndex(searchedIndex); 
		bookDB.remove(realIndex);
		updateBookDB();
	}
	
	public void updateBookDB() {
		file.writeFile(bookDB, "DB_book.txt");
	}
	
	
	public Vector<Book> searchByTitle(String title) {
		searchedIndex = new ArrayList<Integer>();
		Vector<Book> bookList = new Vector<Book>();
		for (int i = 0; i<bookDB.size();i++) {
			if (bookDB.get(i).getTitle().equals(title)) {
				bookList.add(bookDB.get(i));
				searchedIndex.add(i);
			}
		}
		return bookList;
	}
	
	public Vector<Book> searchByAuthor(String author) {
		searchedIndex = new ArrayList<Integer>();
		Vector<Book> bookList = new Vector<Book>();
		for (int i = 0; i<bookDB.size();i++) {
			if (bookDB.get(i).getAuthor().equals(author)) {
				bookList.add(bookDB.get(i));
				searchedIndex.add(i);
			}
		}
		return bookList;
	}
	
	public Vector<Book> searchByISBN(String isbn) {
		searchedIndex = new ArrayList<Integer>();
		Vector<Book> bookList = new Vector<Book>();
		for (int i = 0; i<bookDB.size();i++) {
			if (bookDB.get(i).getISBN().equals(isbn)) {
				bookList.add(bookDB.get(i));
				searchedIndex.add(i);
			}
		}
		return bookList;
	}
	
	public Vector<Book> searchBySellerID(String sellerID) {
		searchedIndex = new ArrayList<Integer>();
		Vector<Book> bookList = new Vector<Book>();
		for (int i = 0; i<bookDB.size();i++) {
			if (bookDB.get(i).getSellerID().equals(sellerID)) {
				bookList.add(bookDB.get(i));
				searchedIndex.add(i);
			}
		}
		return bookList;
	}
	
	public int getRealIndex(int searchedIndex) {
		return this.searchedIndex.get(searchedIndex);
	}
	public Vector<Book> getBookDB(){
		return bookDB;
	}
	public Vector<User> getAccountDB(){
		return accountDB;
	}
}
