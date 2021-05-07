package ma.fstt.model;

import java.util.List;

public class Book {
	
	
private Integer id_book ;
	
	private String name ;
	
	private String auteur ;
	
	private String annee ;
	
	
	private List<BookStore> listbookstores ;
	

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(Integer id_book, String name, String auteur, String annee) {
		super();
		this.id_book = id_book;
		this.name = name;
		this.auteur = auteur;
		this.annee = annee;
	}

	public Integer getId_book() {
		return id_book;
	}

	public void setId_book(Integer id_book) {
		this.id_book = id_book;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getAnnee() {
		return annee;
	}

	public void setAnnee(String annee) {
		this.annee = annee;
	}

	public List<BookStore> getListbookstores() {
		return listbookstores;
	}

	public void setListbookstores(List<BookStore> listbookstores) {
		this.listbookstores = listbookstores;
	}
	
	
	
	
	
	

}
