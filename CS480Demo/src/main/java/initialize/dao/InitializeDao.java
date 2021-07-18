package initialize.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class InitializeDao {
	public void intialize_database() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://127.0.0.1:3306/halal_products?"
				              + "user=abdul&password=abdul123&serverTimezone=UTC");
			
			CallableStatement cStmt = connect.prepareCall("{call initialize_tables()}");
			cStmt.execute();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
