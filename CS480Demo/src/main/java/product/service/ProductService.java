package product.service;

import java.util.List;

import product.dao.ProductDao;
import product.domain.Product;
import product.service.ProductException;

public class ProductService {
	private ProductDao productDao = new ProductDao();

	public List<Product> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		return productDao.findall();
	}

	public void add(Product product)
			throws ProductException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		// check the product name
		Product product1 = productDao.findByName(product.getName());

		if (product1.getName() != null && product1.getName().equals(product.getName()))
			throw new ProductException("This product exists!!!");

		productDao.add(product);
	}

	public void update(Product product)
			throws ProductException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		// check the user name
		Product product1 = productDao.findByNameAndId(product);

		if (product1.getName() != null && product1.getName().equals(product.getName()))
			throw new ProductException("This product exists!!!");

		productDao.update(product);
	}
	
	public void delete(int id) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		productDao.delete(id);
	}
	
	public Product findById(int id) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		return productDao.findById(id);
	}
}
