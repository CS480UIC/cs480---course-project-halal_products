package initialize.service;

import initialize.dao.InitializeDao;

public class InitializeService {
	private InitializeDao userDao = new InitializeDao();
	
	public void initialize() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		userDao.intialize_database();
	}
}
