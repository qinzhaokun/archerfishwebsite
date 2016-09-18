package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Server;
import model.User;
import repository.IServerDao;

@Service
public class ServerService {

	@Autowired
	private IServerDao iServerDao;
	
	public Server getServer(User user, String name){
		return iServerDao.findByUserAndName(user, name);
	}
	
	public Server saveServer(Server server){
		return iServerDao.save(server);
	}
	
	public boolean serverExist(Long id){
		return iServerDao.exists(id);
	}
	
	public void deleteServer(Long id){
		iServerDao.delete(id);
	}
}
