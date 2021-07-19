package store.service;

import java.util.List;

import store.dao.StoreDao;
import store.domain.Store;



public class StoreService {
	
	private StoreDao storeDao = new StoreDao();
	
	/**
	 * register a store
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	/*
	 * regist might need changes to made
	 * since the function checks the address exists or not.
	 */
	
	public void regist(Store form) throws StoreException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		// check the store name
		Store store = storeDao.findByStoreName(form.getName());
		if(store.getAddress()!=null && store.getAddress().equals(form.getAddress())) 
			throw new StoreException("This store already exists in the database!");
		storeDao.add(form);
	}
	
	
	public List<Object> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return storeDao.findall();
		
	}
	
	
	
	

}
