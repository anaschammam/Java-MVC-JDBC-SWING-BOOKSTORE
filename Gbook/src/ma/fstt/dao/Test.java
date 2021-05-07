package ma.fstt.dao;

import java.sql.SQLException;
import java.util.List;


import ma.fstt.model.*;

public class Test {

	public static void main(String[] args) throws SQLException {
		
		
		 
			
			
			/* BaseBook baseBook=new BaseBook();
		 Book myfirstBook=new Book(0,"anas","anas","2020");
		 List<Book> malist = 	baseBook.getAll();
			  for (Book book : malist) {
				
				System.out.println(book.getAnnee());
				
			}
			*/
		/* test BaseBookstore
			Base_BookStore base_bk_manipulate=new Base_BookStore();
			BookStore myBK=new BookStore(0,"thirBookstore","El jadida","anass@gmail.com","000000");
			List<BookStore> listBK=base_bk_manipulate.getAll();

			for (BookStore bookS : listBK) {
				
				System.out.println(bookS.getName());
				
			}
			boolean a=base_bk_manipulate.save(myBK);
			System.out.println(a);
			myBK.setEmail("oth@");
			base_bk_manipulate.update(myBK);
			System.out.println(myBK.getEmail());
			myBK.setTelephone("oth@");
			base_bk_manipulate.update(myBK);
			System.out.println(myBK.getTelephone());
		
			System.out.println(base_bk_manipulate.getOne(2).getId_bookstore());
			
			

			
		/*
		//test has save
		Book mybook=new Book();
		mybook.setId_book(8);
		BookStore mybookstore=new BookStore();
		mybookstore.setId_bookstore(1);
		
		Has own=new Has(1,"2016",mybook ,mybookstore);
		Base_has has_Manipulation=new Base_has();
		//has_Manipulation.save(own);
		
		
		 
		
		/*List<Has> malist=has_Manipulation.getAll();
			
			for(Has list : malist) {
				
				System.out.println(list.getDate());
				own.setId_has(1);
		own.setDate("330");
		has_Manipulation.update(own);
		System.out.println(has_Manipulation.getOne(own.getId_has()).getDate());

			}
		
		List<Has> malist3=has_Manipulation.getAll_join();
		
		for(Has lista : malist3) {
			
			System.out.println(lista.getBookStore().getAddresse());
		}
		*/
		
		

/*
 	// test Update
		BaseBook baseBook=new BaseBook();
		Book alifon=new Book();
		alifon.setId_book(1);
		Book foundbook=baseBook.getOne(alifon.getId_book());
		System.out.println(foundbook.getAnnee());
		foundbook.setAnnee("3000");
		baseBook.update(foundbook);

		System.out.println(foundbook.getAnnee());
 //test save
  BaseBook bookmanipule=new BaseBook();
  Book myfirstBook=new Book(0,"anas","anas","2020");
  bookmanipule.save(myfirstBook);
  //test delete
   bookmanipule(myfirstBook);
   
 		//test getone by id
		BaseBook bs=new BaseBook();
		Book mybook=new Book();
		mybook.setId_book(10);
		Book newbook=bs.getOne(mybook.getId_book());
		System.out.println(newbook.getAuteur());

	*/	
		
		
	
		
	/*
	 // test getall
	  List<Book> malist = 	baseBook.getAll();
		 
			
			
			for (Book book : malist) {
				
				System.out.println(book.getName());
				
			}
	System.out.println(baseBook.getOne(1).getName());
		
		// TODO Auto-generated method stub

	}
	*/
}
}