package store.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import store.domain.Store;
import store.domain.StoreProduct;

public class StoreDao {

	/**
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 */
	public List<Store> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		List<Store> list = new ArrayList<>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/halal_products?" + "user=abdul&password=abdul123&serverTimezone=UTC");

			String sql = "select s.*, r.name as region_name from store s join region r on s.region_id = r.id order by `name`, `address`, `zipcode`";
			// String sql = "select * from store order by name";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			ResultSet resultSet = preparestatement.executeQuery();

			while (resultSet.next()) {
				Store store = new Store();
				store.setId(resultSet.getInt("id"));
				store.setRegion_id(resultSet.getInt("region_id"));
				store.setName(resultSet.getString("name"));
				store.setRegion_name(resultSet.getString("region_name"));
				store.setAddress(resultSet.getString("address"));
				store.setZipcode(resultSet.getInt("zipcode"));

				list.add(store);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return list;
	}

	/**
	 * @param store
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void add(Store store) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/halal_products?" + "user=abdul&password=abdul123&serverTimezone=UTC");

			String sql = "insert into store(`region_id`, `name`, `address`, `zipcode`) values(?, ?, ?, ?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			preparestatement.setInt(1, store.getRegion_id());
			preparestatement.setString(2, store.getName());
			preparestatement.setString(3, store.getAddress());
			preparestatement.setInt(4, store.getZipcode());
			preparestatement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @param store
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void update(Store store) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/halal_products?" + "user=abdul&password=abdul123&serverTimezone=UTC");

			String sql = "update store set `region_id` = ?, `name` = ?, `address` = ?, `zipcode` = ? where `id` = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			preparestatement.setInt(1, store.getRegion_id());
			preparestatement.setString(2, store.getName());
			preparestatement.setString(3, store.getAddress());
			preparestatement.setInt(4, store.getZipcode());
			preparestatement.setInt(5, store.getId());
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

			String sql = "delete from store where `id` = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			preparestatement.setInt(1, id);
			preparestatement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @param store
	 * @return
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public Store findIfDuplicate(Store store)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Store store1 = new Store();
		try {

			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/halal_products?" + "user=abdul&password=abdul123&serverTimezone=UTC");

			String sql = "select * from store where `name` = ? and `address` = ? and `zipcode` = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			preparestatement.setString(1, store.getName());
			preparestatement.setString(2, store.getAddress());
			preparestatement.setInt(3, store.getZipcode());
			ResultSet resultSet = preparestatement.executeQuery();

			while (resultSet.next()) {
				String store_name = resultSet.getString("name");
				String store_address = resultSet.getString("address");
				int store_zipcode = resultSet.getInt("zipcode");

				if (store_name.equals(store.getName()) && store_address.equals(store.getAddress())
						&& store_zipcode == store.getZipcode()) {
					store1.setId(resultSet.getInt("id"));
					store1.setRegion_id(resultSet.getInt("region_id"));
					store1.setName(resultSet.getString("name"));
					store1.setAddress(resultSet.getString("address"));
					store1.setZipcode(resultSet.getInt("zipcode"));
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return store1;
	}

	/**
	 * @param store
	 * @return
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public Store findIfDuplicateWithId(Store store)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Store store1 = new Store();
		try {

			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/halal_products?" + "user=abdul&password=abdul123&serverTimezone=UTC");

			String sql = "select * from store where `name` = ? and `address` = ? and `zipcode` = ? and `id` <> ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			preparestatement.setString(1, store.getName());
			preparestatement.setString(2, store.getAddress());
			preparestatement.setInt(3, store.getZipcode());
			preparestatement.setInt(4, store.getId());
			ResultSet resultSet = preparestatement.executeQuery();

			while (resultSet.next()) {
				String store_name = resultSet.getString("name");
				String store_address = resultSet.getString("address");
				int store_zipcode = resultSet.getInt("zipcode");

				if (store_name.equals(store.getName()) && store_address.equals(store.getAddress())
						&& store_zipcode == store.getZipcode()) {
					store1.setId(resultSet.getInt("id"));
					store1.setRegion_id(resultSet.getInt("region_id"));
					store1.setName(resultSet.getString("name"));
					store1.setAddress(resultSet.getString("address"));
					store1.setZipcode(resultSet.getInt("zipcode"));
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return store1;
	}

	/**
	 * @param id
	 * @return
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public Store findById(int id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Store store = new Store();

		try {

			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/halal_products?" + "user=abdul&password=abdul123&serverTimezone=UTC");

			String sql = "select * from store where `id` = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			preparestatement.setInt(1, id);
			ResultSet resultSet = preparestatement.executeQuery();

			while (resultSet.next()) {
				store.setId(resultSet.getInt("id"));
				store.setName(resultSet.getString("name"));
				store.setAddress(resultSet.getString("address"));
				store.setRegion_id(resultSet.getInt("region_id"));
				store.setZipcode(resultSet.getInt("zipcode"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return store;
	}

	public List<Store> searchByRegion_Id(String reg)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		List<Store> list = new ArrayList<>();

		int id = Integer.parseInt(reg);
		System.out.println("In StoreDao:" + reg);

		try {

			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/halal_products?" + "user=abdul&password=abdul123&serverTimezone=UTC");

			String sql = "select s.*,r.name as region_name FROM store s,region r WHERE r.id = s.region_id AND s.region_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			preparestatement.setInt(1, id);
			ResultSet resultSet = preparestatement.executeQuery();

			while (resultSet.next()) {
				Store store = new Store();
				store.setId(resultSet.getInt("id"));
				store.setRegion_id(resultSet.getInt("region_id"));
				store.setName(resultSet.getString("name"));
				store.setAddress(resultSet.getString("address"));
				store.setZipcode(resultSet.getInt("zipcode"));
				store.setRegion_name(resultSet.getString("region_name"));

				list.add(store);

			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return list;
	}

	public List<Store> searchByStore_Name(String reg)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		List<Store> list = new ArrayList<>();

		System.out.println("In StoreDao:" + reg);

		try {

			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/halal_products?" + "user=abdul&password=abdul123&serverTimezone=UTC");

			String sql = "select s.*, r.name as region_name from store s join region r on s.region_id = r.id  where s.name like concat(\"%\", ?, \"%\") order by name";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			preparestatement.setString(1, reg);
			ResultSet resultSet = preparestatement.executeQuery();

			while (resultSet.next()) {
				Store store = new Store();
				store.setId(resultSet.getInt("id"));
				store.setRegion_id(resultSet.getInt("region_id"));
				store.setName(resultSet.getString("name"));
				store.setAddress(resultSet.getString("address"));
				store.setZipcode(resultSet.getInt("zipcode"));
				store.setRegion_name(resultSet.getString("region_name"));

				list.add(store);

			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return list;
	}

	public List<Store> searchByZip(String reg)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		List<Store> list = new ArrayList<>();

		int zip = Integer.parseInt(reg);
		System.out.println("In StoreDao:" + reg);

		try {

			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/halal_products?" + "user=abdul&password=abdul123&serverTimezone=UTC");

			String sql = "select s.*, r.name as region_name from store s join region r on s.region_id = r.id  where s.zipcode = ? order by name";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			preparestatement.setInt(1, zip);
			ResultSet resultSet = preparestatement.executeQuery();

			while (resultSet.next()) {
				Store store = new Store();
				store.setId(resultSet.getInt("id"));
				store.setRegion_id(resultSet.getInt("region_id"));
				store.setName(resultSet.getString("name"));
				store.setAddress(resultSet.getString("address"));
				store.setZipcode(resultSet.getInt("zipcode"));
				store.setRegion_name(resultSet.getString("region_name"));

				list.add(store);

			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return list;
	}

	public List<Store> findByHalalProducts()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		List<Store> list = new ArrayList<>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/halal_products?" + "user=abdul&password=abdul123&serverTimezone=UTC");

//			String sql = "Select distinct s.*, r.name as region_name From store s join region r on s.region_id = r.id Join product_store ps on ps.store_id = s.id Where ps.availability = 1  Order By s.name";
//			
//			
//		PreparedStatement preparestatement = connect.prepareStatement(sql);
//			ResultSet resultSet = preparestatement.executeQuery();

			CallableStatement cStmt = connect.prepareCall("{call get_halal_stores}");
			ResultSet resultSet = cStmt.executeQuery();
			while (resultSet.next()) {
				Store store = new Store();
				store.setId(resultSet.getInt("id"));
				store.setRegion_id(resultSet.getInt("region_id"));
				store.setName(resultSet.getString("name"));
				store.setRegion_name(resultSet.getString("region_name"));
				store.setAddress(resultSet.getString("address"));
				store.setZipcode(resultSet.getInt("zipcode"));

				list.add(store);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return list;
	}

	public List<StoreProduct> getStoreByProduct(String product_name, Integer zipcode)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		List<StoreProduct> list = new ArrayList<>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/halal_products?" + "user=abdul&password=abdul123&serverTimezone=UTC");

			CallableStatement cStmt = connect.prepareCall("{call get_store_by_product(?,?)}");
			cStmt.setString(1, product_name);

			if (zipcode == null) {
				cStmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				cStmt.setInt(2, zipcode);
			}
			
			ResultSet rs = cStmt.executeQuery();

			while (rs.next()) {
				StoreProduct storeProduct = new StoreProduct();
				storeProduct.setId(Integer.parseInt(rs.getString("id")));
				storeProduct.setRegion_id(Integer.parseInt(rs.getString("region_id")));
				storeProduct.setName(rs.getString("name"));
				storeProduct.setAddress(rs.getString("address"));
				storeProduct.setZipcode(Integer.parseInt(rs.getString("zipcode")));
				storeProduct.setProduct_name(rs.getString("product_name"));

				list.add(storeProduct);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return list;
	}

}
