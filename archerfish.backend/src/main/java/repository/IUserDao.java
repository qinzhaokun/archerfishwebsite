package repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import model.User;

@Repository
public interface IUserDao extends CrudRepository<User, Long>{
	
	public User findByName(String name);
}
