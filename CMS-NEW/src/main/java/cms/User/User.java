package cms.User;

public class User {
	private String uname;
	private String password;
	private int id;
	private int child_id;

	public User(String uname, String password) {
		super(); 
		this.uname = uname;
		this.password = password;
	}


	
	public User(String uname, String password, int id , int c_id) {
		super();
		this.uname = uname;
		this.password = password;
		this.id = id;
		this.child_id = c_id;
	}



	public int getChild_id() {
		return child_id;
	}



	public void setChild_id(int cid) {
		this.child_id = cid;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public User() {
		super();
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	
}
