package ma.fstt.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ma.fstt.model.*;

public class Base_has extends BaseDao< Has >{

	public Base_has() {
		super();
	}
	
public boolean save(Has own) {
		
		
		try {
			String sql = "insert into has (id_has,date_has,id_book,id_bookstore) values(?,?,?,?);" ;
			PreparedStatement ps = BaseDao.getConnection().prepareStatement(sql);
		
		// mapping objet relation 
		
		ps.setInt(1,own.getId_has());
		ps.setString(2,own.getDate() );
		ps.setInt(3,own.getBook().getId_book() );

		ps.setInt(4,own.getBookStore().getId_bookstore() );
	
		ps.execute();
		
		return true;
		}
		catch(Exception e) {
			System.out.println("error in : "+ e);
			return false;
		}
		
		
	}
public boolean update(Has own) {
	
String sql = "update has set date_has=? ,id_book=?,id_bookstore=? where id_has=?;" ;
		
		try {
			PreparedStatement ps = BaseDao.getConnection().prepareStatement(sql);
		
		// mapping objet relation 
		
		
		ps.setString(1,own.getDate());
		ps.setInt(2,own.getBook().getId_book());
		ps.setInt(3,own.getBookStore().getId_bookstore());
		ps.setInt(4,own.getId_has());


		
		ps.execute();
		return true;
		}
		catch(Exception e) {
			System.out.println("error in : "+ e);

			return false;
		}
	}
public boolean delete(Has own){
	String sql="delete from has where id_has=?";
	try {
		PreparedStatement ps = BaseDao.getConnection().prepareStatement(sql);
	
	// mapping has relation 
	
	ps.setInt(1,own.getId_has() );
	
	
	ps.execute();
	return true;
	}
	catch(Exception e) {
		System.out.println("error in : "+ e);

		return false;
	
}
}


public List<Has> getAll() {
	
	try {
	List<Has> listHas  = new ArrayList<Has>() ;
	

	String sql = "select * from has" ;
	PreparedStatement ps=BaseDao.getConnection().prepareStatement(sql);
	
	ResultSet rs=ps.executeQuery();
  
  // iteration 
  
  while( rs.next()) {
	  Has has_ins=new Has();
	  Book has_book=new Book();
	  BookStore has_bookstore=new BookStore();
	  
	  has_ins.setId_has(rs.getInt("id_has"));
	 has_ins.setDate(rs.getString("date_has"));
	 
	  has_book.setId_book(rs.getInt("id_book"));
	has_bookstore.setId_bookstore(rs.getInt("id_bookstore"));
	
	has_ins.setBook(has_book);
	has_ins.setBookStore(has_bookstore);
	
	  listHas.add(has_ins);
	  
	  
  }
	
	return listHas ;
	
	}
	catch(Exception e) {
		System.out.println("error in : "+ e);
		return null;
	}
}
public Has getOne(int id ){
	try {
		Has  has_ins   = new Has() ;
		Book has_book =new Book();
		BookStore has_bookstore=new BookStore();
	
	String sql = "select * from has where id_has = ?" ;
	  PreparedStatement ps=BaseDao.getConnection().prepareStatement(sql);

	
	ps.setInt(1, id);
	
  ResultSet rs =ps.executeQuery() ;
  
  // iteration 
  
  while(rs.next()) {
	  
	     has_ins.setId_has(rs.getInt("id_has"));
		 has_ins.setDate(rs.getString("date_has"));
		 
		 has_book.setId_book(rs.getInt("id_book"));
		 has_bookstore.setId_bookstore(rs.getInt("id_bookstore"));
		 
		 has_ins.setBook(has_book);
		 has_ins.setBookStore(has_bookstore);
		 
	 
	  
  }
	
	return has_ins ;
}
	catch (Exception e) {
		System.out.println("error in "+e);
		return null;
	}
}


public List<Has> getAll_join() {
	try {
	List<Has> listHas  = new ArrayList<Has>() ;
	

	String sql = "select id_has,date_has ,book.id_book,bookstore."
		+ " id_bookstore,book.name,bookstore.nameBookstore from has "
		+ "inner join book on book.id_book=has.id_book "
		+ "inner join bookstore on bookstore. id_bookstore=has.id_bookstore order by bookstore.nameBookstore  ;" ;
	
	PreparedStatement ps=BaseDao.getConnection().prepareStatement(sql);
	ResultSet rs=ps.executeQuery();
  // iteration 
  while( rs.next()) {
	  Has has_ins=new Has();
	  Book has_book=new Book();
	  BookStore has_bookstore=new BookStore();
	  has_ins.setId_has(rs.getInt("id_has"));
	 has_ins.setDate(rs.getString("date_has"));
	has_book.setName(rs.getString("name"));
	has_book.setId_book(rs.getInt("id_book"));
	has_ins.setBook(has_book);
	has_bookstore.setName(rs.getString("nameBookstore"));
	has_bookstore.setId_bookstore(rs.getInt("id_bookstore"));
	has_ins.setBookStore(has_bookstore);
	  listHas.add(has_ins);
  }
	return listHas ;
	}
	catch(Exception e) {
		System.out.println("error in : "+ e);
		return null;
	}
}








}
