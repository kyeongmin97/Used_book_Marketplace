package usedbookmarketplace.model.data.user;

import java.util.Vector;

import usedbookmarketplace.model.data.Book;

public class GeneralUser extends User {
	private String name;
	private String phoneNum;
	private String email;
	
	private Vector<Book> bookList = new Vector<Book>();
	
	public GeneralUser(String[] tokens) {
		super.id = tokens[0];
		super.pw = tokens[1];
		this.name = tokens[2];
		this.phoneNum = tokens[3];
		this.email = tokens[4];
	}
	
	public void addBook(Book book) {
		bookList.add(book);
	}
	
	public String[] getGeneralUserInfo() {
		String[] userInfo = new String[5];
		
		userInfo[0] = id;
		userInfo[1] = pw;
		userInfo[2] = name;
		userInfo[3] = phoneNum;
		userInfo[4] = email;
		
		return userInfo;
	}
}