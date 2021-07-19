package store.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import store.domain.Store;
import user.domain.User;

public class StoreDao {
	
	
	public Store findByStoreName(String storename) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Store store = new Store();
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://127.0.0.1:3306/halal_products?"
				              + "user=abdul&password=abdul123&serverTimezone=UTC");
		    String sql = "select * from store where name=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,storename);
		    ResultSet resultSet = preparestatement.executeQuery();
		    //ResultSet resultSet  = preparestatement.executeUpdate();
		    while(resultSet.next()){
		    	String store_name = resultSet.getString("name");
		    	if(store_name.equals(storename)){
		    		store.setId(resultSet.getInt("id"));
		    		store.setRegion_id(resultSet.getInt("region_id"));
		    		store.setName(resultSet.getString("name"));
		    		store.setAddress(resultSet.getString("address"));
		    		store.setZipcode(resultSet.getInt("zipcode"));
		    		
		    	}
		    }
		
		    
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return store;
	}
	
	
	
	public void add(Store store) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://127.0.0.1:3306/halal_products?"
				              + "user=abdul&password=abdul123&serverTimezone=UTC");
			
			
			String sql = "insert into store values(?,?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,store.getId());
		    preparestatement.setInt(2,store.getRegion_id());
		    preparestatement.setString(3,store.getName());
		    preparestatement.setString(4,store.getAddress());
		    preparestatement.setInt(5,store.getZipcode());
		    preparestatement.executeUpdate();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public List<Object> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://127.0.0.1:3306/halal_products?"
				              + "user=abdul&password=abdul123&serverTimezone=UTC");
			
			
			String sql = "select * from store";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();
			
			while(resultSet.next()){
				Store store = new Store();
				store.setId(resultSet.getInt("id"));
				store.setRegion_id(resultSet.getInt("region_id"));
				store.setName(resultSet.getString("name"));
	    		store.setAddress(resultSet.getString("address"));
	    		store.setZipcode(resultSet.getInt("zipcode"));
	    		list.add(store);
			 }
			 
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
	
	
	
	
	
	
	
	
	
	
}
