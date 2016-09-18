package controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Server;
import model.User;
import service.ServerService;
import service.UserService;

@RestController
public class ServerController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ServerService serverService;
	
	@RequestMapping("/server") 
	public Map createServer(@RequestParam(required = true) String name,
			@RequestParam(required = true) String serverName,
			@RequestParam(required = true) String userName,
			@RequestParam(required = true) String password,
			@RequestParam(required = false, value="TCP") String serverTransport,
			@RequestParam(required = false) Long port,
			@RequestParam(required = false) Boolean toCreate,
			@RequestParam(required = false) String cmd,
			@RequestParam(required = false) String source,
			@RequestParam(required = false) String destination){
		Map<String,Object> map = new HashMap<String,Object>();
		User user = userService.getUserByName(name);
		if(user == null){
			map.put("result", "user not exists");
		}
		else{
			Server server = serverService.getServer(user, serverName);
			if(server == null) server = new Server();
			server.setUser(user);
			server.setName(serverName);
			server.setUserName(userName);
			server.setPassword(password);
			if(serverTransport != null) server.setServerTransport(serverTransport);
			if(port != null) server.setPort(port);
			if(toCreate != null) server.setToCreate(toCreate);
			if(cmd != null) server.setCmd(cmd);
			if(source != null) server.setSource(source);
			if(destination != null) server.setDestination(destination);
			serverService.saveServer(server);
			map.put("result", "success");
		}
		
		return map;
	}
	
	@RequestMapping("/server/delete/{id}") 
	public Map deleteServer(@PathVariable("id") Long id){
		Map<String, Object> map = new HashMap<String,Object>();
		if(!serverService.serverExist(id)){
			map.put("result", "server not exists");
		}
		else{
			serverService.deleteServer(id);
			map.put("result", "success");
		}
		return map;
	}
}
