package ma.fstt.model;

import java.util.List;

// java bean
public class BookStore {
	
	
	private Integer id_bookstore ;
	
	private String name_bookstore ;
	
	private String addresse ;
	private String telephone;
	
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	private String email ;
	
	
	private List<Book> listbooks ;
	
	

	public BookStore() {
		super();
		// TODO Auto-generated constructor stub
	}

	/*
	 public List<Book> getListbooks() {
		return listbooks;
	}

	public void setListbooks(List<Book> listbooks) {
		this.listbooks = listbooks;
	}
	 */

	public BookStore(Integer id_bookstore, String name, String addresse, String email,String telephone) {
		super();
		this.id_bookstore = id_bookstore;
		this.name_bookstore = name;
		this.addresse = addresse;
		this.email = email;
		this.telephone=telephone;
	}

	public Integer getId_bookstore() {
		return id_bookstore;
	}

	public void setId_bookstore(int id_bookstore) {
		this.id_bookstore = id_bookstore;
	}

	public String getName() {
		return name_bookstore;
	}

	public void setName(String name) {
		this.name_bookstore = name;
	}

	public String getAddresse() {
		return addresse;
	}

	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
	
	
	
	

}
