package manufacturer.service;

import java.util.List;

import manufacturer.dao.ManufacturerDao;
import manufacturer.domain.Manufacturer;

public class ManufacturerService {
	private ManufacturerDao manufacturerDao = new ManufacturerDao();

	public List<Manufacturer> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		return manufacturerDao.findall();
	}

	public void add(Manufacturer manufacturer)
			throws ManufacturerException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		// check the user name
		Manufacturer manufacturer1 = manufacturerDao.findByName(manufacturer.getName());

		if (manufacturer1.getName() != null && manufacturer1.getName().equals(manufacturer.getName()))
			throw new ManufacturerException("This manufacturer exists!!!");

		manufacturerDao.add(manufacturer);
	}

	public void update(Manufacturer manufacturer)
			throws ManufacturerException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		// check the user name
		Manufacturer manufacturer1 = manufacturerDao.findByNameAndId(manufacturer);

		if (manufacturer1.getName() != null && manufacturer1.getName().equals(manufacturer.getName()))
			throw new ManufacturerException("This manufacturer exists!!!");

		manufacturerDao.update(manufacturer);
	}
	
	public void delete(int id) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		manufacturerDao.delete(id);
	}
	
	public Manufacturer findById(int id) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		return manufacturerDao.findById(id);
	}
}
