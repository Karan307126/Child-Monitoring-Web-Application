package childcms.Dao;

import java.sql.*;
import childcms.Child.*;

public class ChildDao {
	
		private Connection con;
		private PreparedStatement pmt;
		private ResultSet rs;

		
		public ChildDao(Connection con) {
			this.con = con;
		}

		public boolean saveUser(Child user) {
			boolean f = false;
			try {
				String query = "insert into child(username,password) values(?,?)";
				pmt = this.con.prepareStatement(query);
				pmt.setString(1,user.getUsername());
				pmt.setString(2,user.getPassword());
				
				pmt.executeUpdate();
				f = true;
				
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
			return f;
		}
			
		public Child checkUser(String username, String password) {
			Child user = null;
			try {
				String query = "SELECT * FROM child WHERE username=? and password=?";
				pmt = this.con.prepareStatement(query);
				pmt.setString(1,username);
				pmt.setString(2,password);
				
				rs = pmt.executeQuery();
	            if(rs.next()){
	            	user = new Child();
	            	user.setId(rs.getInt("id"));
	            	user.setUsername(rs.getString("username"));
	            	user.setPassword(rs.getString("password"));
	            	user.setDOB(rs.getString("date_of_birth"));
	            	user.setName(rs.getString("name"));
	            }
				
				
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		return user;	
		}
		
	}

	

