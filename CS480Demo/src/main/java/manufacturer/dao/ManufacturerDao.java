package manufacturer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import manufacturer.domain.Manufacturer;

/**
 * @author abdul
 *
 */
public class ManufacturerDao {

	/**
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 */
	public List<Manufacturer> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		List<Manufacturer> list = new ArrayList<>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/halal_products?" + "user=abdul&password=abdul123&serverTimezone=UTC");

			String sql = "select * from manufacturer order by name";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			ResultSet resultSet = preparestatement.executeQuery();

			while (resultSet.next()) {
				Manufacturer manufacturer = new Manufacturer();
				manufacturer.setId(resultSet.getInt("id"));
				manufacturer.setName(resultSet.getString("name"));

				list.add(manufacturer);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return list;
	}

	/**
	 * @param manufacturer
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void add(Manufacturer manufacturer)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/halal_products?" + "user=abdul&password=abdul123&serverTimezone=UTC");

			String sql = "insert into manufacturer(`name`) values(?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			preparestatement.setString(1, manufacturer.getName());
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
	public void update(Manufacturer manufacturer)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/halal_products?" + "user=abdul&password=abdul123&serverTimezone=UTC");

			String sql = "update manufacturer set name=? where id=?";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			preparestatement.setString(1, manufacturer.getName());
			preparestatement.setInt(2, manufacturer.getId());
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

			String sql = "delete from manufacturer where id=?";
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
	public Manufacturer findByName(String name)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Manufacturer manufacturer = new Manufacturer();

		try {

			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/halal_products?" + "user=abdul&password=abdul123&serverTimezone=UTC");

			String sql = "select * from manufacturer where name=?";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			preparestatement.setString(1, name);
			ResultSet resultSet = preparestatement.executeQuery();

			while (resultSet.next()) {
				String manufacturer_name = resultSet.getString("name");

				if (manufacturer_name.equals(name)) {
					manufacturer.setId(resultSet.getInt("id"));
					manufacturer.setName(resultSet.getString("name"));
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return manufacturer;
	}
	
	/**
	 * @param manufacturer
	 * @return
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public Manufacturer findByNameAndId(Manufacturer manufacturer)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Manufacturer manufacturer1 = new Manufacturer();

		try {

			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/halal_products?" + "user=abdul&password=abdul123&serverTimezone=UTC");

			String sql = "select * from manufacturer where name=? and id<>?";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			preparestatement.setString(1, manufacturer.getName());
			preparestatement.setInt(2, manufacturer.getId());
			ResultSet resultSet = preparestatement.executeQuery();

			while (resultSet.next()) {
				String manufacturer_name = resultSet.getString("name");

				if (manufacturer_name.equals(manufacturer.getName())) {
					manufacturer1.setId(resultSet.getInt("id"));
					manufacturer1.setName(resultSet.getString("name"));
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return manufacturer1;
	}
}
