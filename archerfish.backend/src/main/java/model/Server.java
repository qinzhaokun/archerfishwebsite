package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="server")
public class Server {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(cascade = {}, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "server_transport")
	private String serverTransport;
	
	@Column(name = "port")
	private Long port;
	
	@Column(name = "to_create")
	private Boolean toCreate;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "cmd")
	private String cmd;
	
	@Column(name = "source")
	private String source;
	
	@Column(name = "destination")
	private String destination;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getServerTransport() {
		return serverTransport;
	}

	public void setServerTransport(String serverTransport) {
		this.serverTransport = serverTransport;
	}

	public Long getPort() {
		return port;
	}

	public void setPort(Long port) {
		this.port = port;
	}

	public Boolean getToCreate() {
		return toCreate;
	}

	public void setToCreate(Boolean toCreate) {
		this.toCreate = toCreate;
	}

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	public Server(){
		serverTransport = "TCP";
		toCreate = false;
		port= new Long(0);
	}
	
	

}
