package repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import model.Server;
import model.User;

@Repository
public interface IServerDao extends CrudRepository<Server, Long>{

	public Server findByUserAndName(User user, String name);
}
