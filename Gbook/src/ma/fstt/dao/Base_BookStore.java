package ma.fstt.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ma.fstt.model.BookStore;

public class Base_BookStore extends BaseDao<BookStore>{
	
	public Base_BookStore() {
		super();
	}

	
	public boolean save(BookStore object) {

		try {
			String sql = "INSERT INTO `bookstore` (`nameBookstore`, `adresse`, `email`,`telephone`) VALUES (?,?,?,?); " ;
			PreparedStatement ps = BaseDao.getConnection().prepareStatement(sql);
		
		// mapping objet relation 
		
		//ps.setInt(1,object.getId_bookstore());
		ps.setString(1,object.getName());
		ps.setString(2,object.getAddresse());
		ps.setString(3,object.getEmail());
		ps.setString(4,object.getTelephone());

		
	
		ps.execute();
		
		return true;
		}
		catch(Exception e) {
			System.out.println("error in : "+ e);
			return false;
		}	}

	
	public boolean update(BookStore object) {
	
String sql = "update bookstore set nameBookstore=? , adresse=? , email=?,telephone=? where id_bookstore=?" ;
		
		try {
			PreparedStatement ps = BaseDao.getConnection().prepareStatement(sql);
		
		// mapping objet relation 
		
			ps.setString(1,object.getName());
			ps.setString(2,object.getAddresse());
			ps.setString(3,object.getEmail());
			ps.setString(4,object.getTelephone());
			ps.setInt(5,object.getId_bookstore());

		
		ps.execute();
		return true;
		}
		catch(Exception e) {
			System.out.println("error in : "+ e);

			return false;
		}
	}

	@Override
	public boolean delete(BookStore object) {
		
		String sql="delete from bookstore where id_bookstore=?";
		try {
			PreparedStatement ps = BaseDao.getConnection().prepareStatement(sql);
		
		// mapping objet relation 
		
		ps.setInt(1,object.getId_bookstore() );
		
		
		ps.execute();
		return true;
		}
		catch(Exception e) {
			System.out.println("error in : "+ e);
			
			return false;
		
	}
	}

	@Override
	public List<BookStore> getAll() {
		
		try {
		List<BookStore> listBookstore  = new ArrayList<BookStore>() ;
		
	
		String sql = "select * from bookstore" ;
		PreparedStatement ps=BaseDao.getConnection().prepareStatement(sql);
		
		ResultSet rs=ps.executeQuery();

	  
	  // iteration 
	  
	  while( rs.next()) {
		  BookStore bookstore_ins=new BookStore();

		  bookstore_ins.setId_bookstore(rs.getInt("id_bookstore"));
		  bookstore_ins.setName(rs.getString("nameBookstore"));
		  bookstore_ins.setAddresse(rs.getString("adresse"));
		  bookstore_ins.setEmail(rs.getString("email"));
		  bookstore_ins.setTelephone(rs.getString("telephone"));
		  
		  listBookstore.add(bookstore_ins);
		  
		  
	  }
		
		return listBookstore ;
		
		}
		catch(Exception e) {
			System.out.println("error in anas : "+ e);
			return null;
		}
	}

	@Override
	public BookStore getOne(int id) {
		try {
			  BookStore bookstore_ins=new BookStore();

					
					String sql = "select * from bookstore where id_bookstore = ?" ;
					  PreparedStatement ps=BaseDao.getConnection().prepareStatement(sql);

					
					ps.setInt(1, id);
					
				  ResultSet rs =ps.executeQuery() ;
				  
				  // iteration 
				  
				  while(rs.next()) {
					  bookstore_ins.setId_bookstore(rs.getInt("id_bookstore"));
					  bookstore_ins.setName(rs.getString("nameBookstore"));
					  bookstore_ins.setAddresse(rs.getString("adresse"));
					  bookstore_ins.setEmail(rs.getString("email"));
					  bookstore_ins.setTelephone(rs.getString("telephone"));
				  }
					return bookstore_ins ;
				}
					catch (Exception e) {
						System.out.println("error in anas"+e);
						return null;
					}
				}
	
}




