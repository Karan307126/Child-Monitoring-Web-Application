package cms.Dao;

import java.sql.*;

import cms.User.User;

public class UserDao {

	private Connection con;
	private PreparedStatement pmt;
	private ResultSet rs;

	
	public UserDao(Connection con) {
		this.con = con;
	}

	public boolean saveUser(User user) {
		boolean f = false;
		try {
			String query = "insert into user(username,password) values(?,?)";
			pmt = this.con.prepareStatement(query);
			pmt.setString(1,user.getUname());
			pmt.setString(2,user.getPassword());
			
			pmt.executeUpdate();
			f = true;
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return f;
	}
		
	public User checkUser(String username, String password) {
		User user = null;
		try {
			String query = "SELECT * FROM user WHERE username=? and password=?";
			pmt = this.con.prepareStatement(query);
			pmt.setString(1,username);
			pmt.setString(2,password);
			
			rs = pmt.executeQuery();
            if(rs.next()){
            	user = new User();
            	user.setId(rs.getInt("id"));
            	user.setUname(rs.getString("username"));
            	user.setPassword(rs.getString("password"));
            	user.setChild_id(rs.getInt("child_id"));
            }
			
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	return user;	
	}
	
}
