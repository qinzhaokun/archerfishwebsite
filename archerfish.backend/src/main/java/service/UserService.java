package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Server;
import model.User;
import repository.IUserDao;

@Service
public class UserService {

	@Autowired
	private IUserDao iUserDao;
	
	public User getUserByName(String name){
		return iUserDao.findByName(name);
	}
	
	public List<Server> getServer(String name){
		User user = getUserByName(name);
		if(user == null){
			return new ArrayList<Server>();
		}
		else{
			return user.getServers();
		}
	}
	
	public User createUser(User user2){
		User user = new User();
		user.setName(user2.getName());
		user.setPassword(user2.getPassword());
		return iUserDao.save(user);
	}

	
	
}
