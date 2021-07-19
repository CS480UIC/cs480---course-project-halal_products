package region.service;

import java.util.List;

import region.domain.Region;
import region.dao.RegionDao;

/*
 * @author meraj
 */

public class RegionService {
	private RegionDao regionDao = new RegionDao();

	public List<Region> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		return (List<Region>) regionDao.findall();
	}

	public void add(Region region)
			throws RegionException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		// check the region name
		Region region1 = regionDao.findByName(region.getName());

		if (region1.getName() != null && region1.getName().equals(region.getName()))
			throw new RegionException("This region exists!!!");

		regionDao.add(region);
	}

	public void update(Region region)
			throws RegionException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		// check the region name
		Region region1 = regionDao.findByNameAndId(region);

		if (region1.getName() != null && region1.getName().equals(region.getName()))
			throw new RegionException("This region exists!!!");

		regionDao.update(region);
	}

	public void delete(int id) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		regionDao.delete(id);
	}

	public Region findById(int id) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		return regionDao.findById(id);

	}
}
