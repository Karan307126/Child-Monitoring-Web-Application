package cms.Dao;

import java.sql.*;
import java.util.*;

import cms.User.Contact;

public class ContactDao {

	private Connection con;
	private PreparedStatement pmt;
	private ResultSet rs;

	public ContactDao(Connection con) {
		this.con = con;
	}

	public Contact getContact(int c_id) {
		Contact cnt = null;
		try {
			String query = "SELECT * FROM contact WHERE child_id=?";
			pmt = this.con.prepareStatement(query);
			pmt.setInt(1, c_id);

			rs = pmt.executeQuery();
			if (rs.next()) {
				cnt = new Contact();
				cnt.setId(rs.getInt("id"));
				cnt.setChild_id(rs.getInt("child_id"));
				cnt.setPhone_number(rs.getInt("phone_number"));
				cnt.setCtime(rs.getString("timestamp"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return cnt;
	}
	
	public List<Contact> childContacts(int c_id) {
        List<Contact> list = new ArrayList<>();
        try {
        	String query = "SELECT * FROM contact WHERE child_id=?";
            pmt = this.con.prepareStatement(query);
            pmt.setInt(1, c_id);
            
            rs = pmt.executeQuery();
            
            while (rs.next()) {
                Contact cnt = new Contact();	
				
				cnt.setId(rs.getInt("id"));
				cnt.setChild_id(rs.getInt("child_id"));
				cnt.setPhone_number(rs.getInt("phone_number"));
				cnt.setCtime(rs.getString("timestamp"));
                
                list.add(cnt);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return list;
    }

}
