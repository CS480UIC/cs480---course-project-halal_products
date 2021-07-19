package region.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import manufacturer.domain.Manufacturer;
import region.domain.Region;

/**
 * @author meraj
 *
 */
public class RegionDao {

	/**
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 */
	public List<Region> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		List<Region> list = new ArrayList<>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/halal_products?" + "user=abdul&password=abdul123&serverTimezone=UTC");

			String sql = "select * from region order by name";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			ResultSet resultSet = preparestatement.executeQuery();

			while (resultSet.next()) {
				Region region = new Region();
				region.setId(resultSet.getInt("id"));
				region.setName(resultSet.getString("name"));

				list.add(region);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return list;
	}

	/**
	 * @param region
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void add(Region region)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/halal_products?" + "user=abdul&password=abdul123&serverTimezone=UTC");

			String sql = "insert into region(`name`) values(?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			preparestatement.setString(1, region.getName());
			preparestatement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @param manufacturer
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void update(Region region)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/halal_products?" + "user=abdul&password=abdul123&serverTimezone=UTC");

			String sql = "update region set name=? where id=?";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			preparestatement.setString(1, region.getName());
			preparestatement.setInt(2, region.getId());
			preparestatement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @param id
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void delete(int id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/halal_products?" + "user=abdul&password=abdul123&serverTimezone=UTC");

			String sql = "delete from region where id=?";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			preparestatement.setInt(1, id);
			preparestatement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @param name
	 * @return
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public Region findByName(String name)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Region region = new Region();

		try {

			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/halal_products?" + "user=abdul&password=abdul123&serverTimezone=UTC");

			String sql = "select * from region where name=?";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			preparestatement.setString(1, name);
			ResultSet resultSet = preparestatement.executeQuery();

			while (resultSet.next()) {
				String region_name = resultSet.getString("name");

				if (region_name.equals(name)) {
					region.setId(resultSet.getInt("id"));
					region.setName(resultSet.getString("name"));
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return region;
	}
	
	/**
	 * @param manufacturer
	 * @return
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public Region findByNameAndId(Region region)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Region region1 = new Region();

		try {

			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/halal_products?" + "user=abdul&password=abdul123&serverTimezone=UTC");

			String sql = "select * from region where name=? and id<>?";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			preparestatement.setString(1, region.getName());
			preparestatement.setInt(2, region.getId());
			ResultSet resultSet = preparestatement.executeQuery();

			while (resultSet.next()) {
				String region_name = resultSet.getString("name");

				if (region_name.equals(region.getName())) {
					region1.setId(resultSet.getInt("id"));
					region1.setName(resultSet.getString("name"));
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return region1;
	}
	
	public Region findById(int id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Region region = new Region();

		try {

			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/halal_products?" + "user=abdul&password=abdul123&serverTimezone=UTC");

			String sql = "select * from region where id=?";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			preparestatement.setInt(1, id);
			ResultSet resultSet = preparestatement.executeQuery();

			while (resultSet.next()) {
				region.setId(resultSet.getInt("id"));
				region.setName(resultSet.getString("name"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return region;
	}
	
}
