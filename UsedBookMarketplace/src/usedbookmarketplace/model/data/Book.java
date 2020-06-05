package usedbookmarketplace.model.data;

public class Book {
	private String title;
	private String author;
	private String publisher;
	private String publicationYear;
	private String ISBN;
	private String price;
	private String bookState;
	private String sellerID;

	public Book(String[] bookinfo) {
		title = bookinfo[0];
		author = bookinfo[1];
		publisher = bookinfo[2];
		publicationYear = bookinfo[3];
		ISBN = bookinfo[4];
		price = bookinfo[5];
		bookState = bookinfo[6]; // excellent, good, fair
		sellerID = bookinfo[7];
	}

// need to change a condition
//	private BookState strToBookState(String s) {
//		switch (Integer.parseInt(s)) {
//		case 0: return BookState.EXCELLENT;
//		case 1: return BookState.GOOD;
//		case 2: return BookState.FIAR;
//		default:
//			return null;
//		} 
//	}
	public String[] getAllBookInfo() {
		String[] bookInfo = { title, author, publisher, publicationYear, ISBN, price, bookState, sellerID };
		
		return bookInfo;
	}

	public String getSellerID() { return this.sellerID; }
	public String getTitle() { return title; }
	public String getAuthor() { return author; }
	public String getPublisher() { return publisher; }
	public String getPublicationYear() { return publicationYear; }
	public String getISBN() { return ISBN; }
	public String getPrice() { return price; }
	public String getBookState() { return bookState; }
}