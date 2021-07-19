package store.service;

import java.util.List;

import manufacturer.domain.Manufacturer;
import manufacturer.service.ManufacturerException;
import store.dao.StoreDao;
import store.domain.Store;

public class StoreService {

	private StoreDao storeDao = new StoreDao();

	public List<Store> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		return storeDao.findall();
	}

	public void add(Store store)
			throws ManufacturerException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		// check the user name
		Store store1 = storeDao.findIfDuplicate(store);

		if (store1.getName() != null && store1.getName().equals(store.getName()))
			throw new ManufacturerException("This store exists!!!");

		storeDao.add(store);
	}

	public void update(Store store)
			throws ManufacturerException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		// check the user name
		Store store1 = storeDao.findIfDuplicateWithId(store);

		if (store1.getName() != null && store1.getName().equals(store.getName()))
			throw new ManufacturerException("This store exists!!!");

		storeDao.update(store);
	}

	public void delete(int id) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		storeDao.delete(id);
	}

	public Store findById(int id) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		return storeDao.findById(id);
	}
}
