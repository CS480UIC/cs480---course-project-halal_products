package product.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import product.domain.Product;
/**
 * @author meraj
 *
 */
public class ProductDao {

	/**
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 */
	public List<Product> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		List<Product> list = new ArrayList<>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/halal_products?" + "user=abdul&password=abdul123&serverTimezone=UTC");

			String sql = "select * from product order by id";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			ResultSet resultSet = preparestatement.executeQuery();

			while (resultSet.next()) {
				Product product = new Product();
				product.setId(resultSet.getInt("id"));
				product.setName(resultSet.getString("name"));
				product.setCategory_id(resultSet.getInt("category_id"));
				product.setManufacturer_id(resultSet.getInt("manufacturer_id"));
				product.setHalal_status_id(resultSet.getInt("halal_status_id"));
				product.setCertifications(resultSet.getString("certifications"));

				list.add(product);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return list;
	}

	/**
	 * @param product
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void add(Product product)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/halal_products?" + "user=abdul&password=abdul123&serverTimezone=UTC");

			String sql = "insert into product(`name`) values(?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			preparestatement.setString(1, product.getName());
			preparestatement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @param product
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void update(Product product)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/halal_products?" + "user=abdul&password=abdul123&serverTimezone=UTC");

			String sql = "update product set name=? where id=?";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			preparestatement.setString(1, product.getName());
			preparestatement.setInt(2, product.getId());
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

			String sql = "delete from product where id=?";
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
	public Product findByName(String name)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Product Product = new Product();

		try {

			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/halal_products?" + "user=abdul&password=abdul123&serverTimezone=UTC");

			String sql = "select * from product where name=?";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			preparestatement.setString(1, name);
			ResultSet resultSet = preparestatement.executeQuery();

			while (resultSet.next()) {
				String Product_name = resultSet.getString("name");

				if (Product_name.equals(name)) {
					Product.setId(resultSet.getInt("id"));
					Product.setName(resultSet.getString("name"));
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return Product;
	}
	
	/**
	 * @param product
	 * @return
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public Product findByNameAndId(Product product)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Product product1 = new Product();

		try {

			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/halal_products?" + "user=abdul&password=abdul123&serverTimezone=UTC");

			String sql = "select * from product where name=? and id<>?";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			preparestatement.setString(1, product.getName());
			preparestatement.setInt(2, product.getId());
			ResultSet resultSet = preparestatement.executeQuery();

			while (resultSet.next()) {
				String product_name = resultSet.getString("name");

				if (product_name.equals(product.getName())) {
					product1.setId(resultSet.getInt("id"));
					product1.setName(resultSet.getString("name"));
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return product1;
	}
	
	public Product findById(int id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Product product = new Product();

		try {

			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/halal_products?" + "user=abdul&password=abdul123&serverTimezone=UTC");

			String sql = "select * from product where id=?";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			preparestatement.setInt(1, id);
			ResultSet resultSet = preparestatement.executeQuery();

			while (resultSet.next()) {
				product.setId(resultSet.getInt("id"));
				product.setName(resultSet.getString("name"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return product;
	}
	
	public Product findUnavailableProducts(int category_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Product product = new Product();

		try {

			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/halal_products?" + "user=abdul&password=abdul123&serverTimezone=UTC");

			String sql = "select * from product where id=?";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			preparestatement.setInt(1, category_id);
			ResultSet resultSet = preparestatement.executeQuery();

			while (resultSet.next()) {
				product.setId(resultSet.getInt("id"));
				product.setName(resultSet.getString("name"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return product;
	}
	
}
