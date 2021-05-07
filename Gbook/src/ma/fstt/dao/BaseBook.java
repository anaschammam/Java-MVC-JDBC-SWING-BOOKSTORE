package ma.fstt.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ma.fstt.model.Book;
public class BaseBook extends BaseDao<Book> {

	public BaseBook(){
		super();
	}

	public boolean save(Book object) {
		
		
		try {
			//requete sql
			String sql = "insert into book (name , auteur , annee) values ( ? ,? ,?)" ;
			PreparedStatement ps = BaseDao.getConnection().prepareStatement(sql);
		
		// mapping objet relation 
		
		ps.setString(1,object.getName() );
		ps.setString(2,object.getAuteur() );
		ps.setString(3,object.getAnnee() );
	
		ps.execute();
		
		return true;
		}
		catch(Exception e) {
			System.out.println("error in : "+ e);
			return false;
		}
		
		
	}

	public boolean update(Book object) {
		
String sql = "update book set name=? , auteur=? , annee=? where id_book=?" ;
		
		try {
			PreparedStatement ps = BaseDao.getConnection().prepareStatement(sql);
		
		// mapping objet relation 
		
		ps.setString(1,object.getName() );
		ps.setString(2,object.getAuteur() );
		ps.setString(3,object.getAnnee() );
		ps.setInt(4, object.getId_book());
		
		ps.execute();
		return true;
		}
		catch(Exception e) {
			System.out.println("error in : "+ e);

			return false;
		}
	}

	
	public boolean delete(Book object){
		String sql="delete from book where id_book=?";
		try {
			PreparedStatement ps = BaseDao.getConnection().prepareStatement(sql);
		
		// mapping objet relation 
		
		ps.setInt(1,object.getId_book() );
		
		
		ps.execute();
		return true;
		}
		catch(Exception e) {
			System.out.println("error in : "+ e);
			
			return false;
		
	}
	}

	public List<Book> getAll() {
		
		try {
		List<Book> listBooks  = new ArrayList<Book>() ;
		
	
		String sql = "select * from book" ;
		PreparedStatement ps=BaseDao.getConnection().prepareStatement(sql);
		
		ResultSet rs=ps.executeQuery();
	  
	  // iteration 
	  
	  while( rs.next()) {
		  Book book_ins=new Book();
		  book_ins.setId_book(rs.getInt("id_book"));
		  book_ins.setName(rs.getString("name"));
		  book_ins.setAuteur(rs.getString("auteur"));
		  book_ins.setAnnee(rs.getString("annee"));
		  listBooks.add(book_ins);
		  
		  
	  }
		
		return listBooks ;
		
		}
		catch(Exception e) {
			System.out.println("error in : "+ e);
			return null;
		}
	}

	
	public Book getOne(int id ){
		try {
   Book  book_ins   = new Book() ;
		//requete sql
		String sql = "select * from book where id_book = ?" ;
		  PreparedStatement ps=BaseDao.getConnection().prepareStatement(sql);
		ps.setInt(1, id);
		
	  ResultSet rs =ps.executeQuery() ;
	  // iteration 
	  while(rs.next()) {
		  book_ins.setId_book(rs.getInt("id_book"));
		  book_ins.setName(rs.getString("name"));
		  book_ins.setAuteur(rs.getString("auteur"));
		  book_ins.setAnnee(rs.getString("annee"));
	  }
		return book_ins ;
	}
		catch (Exception e) {
			System.out.println("error in "+e);
			return null;
		}
	}
	

}
