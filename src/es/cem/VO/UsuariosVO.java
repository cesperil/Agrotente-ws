package es.cem.VO;

public class UsuariosVO {

	private String user;
	
	private String pass;
	
	private String id;
	
	public String getId() {
		return id;
	}

	public String getUser() {
		return user;
	}

	public String getPass() {
		return pass;
	}

	public UsuariosVO(String  username, String password){
		this.user = username;
		this.pass = password;
	}
	
	public UsuariosVO(String  id){
		this.id = id;
	}
	
}
