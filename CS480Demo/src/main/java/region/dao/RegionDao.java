package region.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import java.util.ArrayList;
import java.util.List;

import region.domain.Region;



public class RegionDao 
{
	
	
	
	

	public Region findByRegionName(String regionName) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Region region = new Region();
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://127.0.0.1:3306/halal_products?"
				              + "user=abdul&password=abdul123&serverTimezone=UTC");
		    String sql = "select * from region where name=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,regionName);
		    ResultSet resultSet = preparestatement.executeQuery();
		    //ResultSet resultSet  = preparestatement.executeUpdate();
		    while(resultSet.next()){
		    	String region_name = resultSet.getString("name");
		    	if(region_name.equals(regionName)){
		    		region.setName(resultSet.getString("name"));
		    		
		    	}
		    }
		
		    
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return region;
	}
	
	
	
	public void add(Region region) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://127.0.0.1:3306/halal_products?"
				              + "user=abdul&password=abdul123&serverTimezone=UTC");
			
			
			String sql = "insert into region values(?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,region.getName());
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
			
			
			String sql = "select * from region";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();
			
			while(resultSet.next()){
				
				Region region = new Region();
				region.setName(resultSet.getString("name"));
	    		list.add(region);
			 }
			 
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}
}
