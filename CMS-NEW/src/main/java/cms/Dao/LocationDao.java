package cms.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cms.User.*;

public class LocationDao {

	private Connection con;
	private PreparedStatement pmt;
	private ResultSet rs;

	public LocationDao(Connection con) {
		this.con = con;
	}

	public Location getLoc(int c_id) {
		Location loct = null;
		try {
			String query = "SELECT * FROM location WHERE child_id=?";
			pmt = this.con.prepareStatement(query);
			pmt.setInt(1, c_id);

			rs = pmt.executeQuery();
			if (rs.next()) {
				loct = new Location();
				loct.setId(rs.getInt("id"));
				loct.setChild_id(rs.getInt("child_id"));
				loct.setLat(rs.getDouble("latitude"));
				loct.setLon(rs.getDouble("longitude"));
				loct.setL_time(rs.getString("timestamp"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return loct;
	}

	public Location getTemp(int id) {
		Location loct = null;
		try {
			String query = "SELECT * FROM location WHERE id=?";
			pmt = this.con.prepareStatement(query);
			pmt.setInt(1, id);

			rs = pmt.executeQuery();
			if (rs.next()) {
				loct = new Location();
				loct.setId(rs.getInt("id"));
				loct.setChild_id(rs.getInt("child_id"));
				loct.setLat(rs.getDouble("latitude"));
				loct.setLon(rs.getDouble("longitude"));
				loct.setL_time(rs.getString("timestamp"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return loct;
	}

	
	public List<Location> childLocation(int c_id) {
        List<Location> list = new ArrayList<>();
        try {
        	String query = "SELECT * FROM location WHERE child_id=?";
            pmt = this.con.prepareStatement(query);
            pmt.setInt(1, c_id);
            
            rs = pmt.executeQuery();
            
            while (rs.next()) {
                Location lct = new Location();	
				
				lct.setId(rs.getInt("id"));
				lct.setChild_id(rs.getInt("child_id"));
				lct.setLat(rs.getDouble("latitude"));
				lct.setLon(rs.getDouble("longitude"));
				lct.setL_time(rs.getString("timestamp"));
                
                list.add(lct);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return list;
    }

	
}
