package region.service;

import java.util.List;

import region.domain.Region;
import region.dao.RegionDao;



public class RegionService {
private RegionDao regionDao = new RegionDao();
	
	/**
	 * register a user
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void regist(Region form) throws RegionException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		// check the user name
		Region region = regionDao.findByRegionName(form.getName());
		if(region.getName()!=null && region.getName().equals(region.getName())) throw new RegionException("This region name has been registered!");
		regionDao.add(form);
	}
	
	public List<Object> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return RegionDao.findall();
		
	}
	

}
