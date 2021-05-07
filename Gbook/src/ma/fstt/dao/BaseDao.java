package ma.fstt.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
public abstract class   BaseDao <T> {
	//methode abstraite pour la redefinir dans les classes derivés  :CRUD
	public abstract boolean save(T object);
	public abstract boolean update(T object);
	public abstract boolean delete(T object);
	public abstract List<T> getAll();
	public abstract T getOne(int id );
	/*jdbc :  Java API to connect and execute the query with the database.
	 mysql : nom du SGBD
	 localhost or 127.0.0.1 : nom d'hôte standard de mysql
	 3306 : numero de port
	 gbook : nom de mon base de données*/
	private static String url = "jdbc:mysql://localhost:3306/gbook"; 
	private static String user = "root";
	private static String password = "";
	// methode static puisque elle depend de la classe BaseDao et n'ont pas des objets
	public static Connection getConnection() {
		Connection connection= null;
		try { // nome de la driver que j'ai telechargé
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,user,password);
		} catch (Exception e) {
			connection=null; System.out.println("There is an Error : "+ e);		}
		return connection;		
	}
	
}
