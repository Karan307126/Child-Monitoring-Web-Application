package childcms.Child;

public class Child {

	private int id;
	private String name;
	private String username;
	private String password;
	private String DOB;
	
	
	
	public Child() {
		super();
	}



	public Child(int id, String name, String username, String password, String dOB) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		DOB = dOB;
	}
	
	
	
	public Child(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}



	public Child(String name, String username, String password, String dOB) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		DOB = dOB;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	
	
	
}
