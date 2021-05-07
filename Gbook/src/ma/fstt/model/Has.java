package ma.fstt.model;

public class Has {
	
	
	private Integer id_has ;
	
	private String date ;
	
	
	private Book book ;
	
	public Has() {
		super();
	}
	public Has(Integer id_has, String date, Book book, BookStore bookStore) {
		super();
		this.id_has = id_has;
		this.date = date;
		this.book = book;
		this.bookStore = bookStore;
	}

	private BookStore bookStore ;

	public Integer getId_has() {
		return id_has;
	}

	public void setId_has(Integer id_has) {
		this.id_has = id_has;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public BookStore getBookStore() {
		return bookStore;
	}

	public void setBookStore(BookStore bookStore) {
		this.bookStore = bookStore;
	}
	
	
	
	

}
