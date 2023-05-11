package cms.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cms.User.*;

public class HistoryDao {

	private Connection con;
	private PreparedStatement pmt;
	private ResultSet rs;

	public HistoryDao(Connection con) {
		this.con = con;
	}

	public History getHist(int c_id) {
		History hst = null;
		try {
			String query = "SELECT * FROM history WHERE child_id=?";
			pmt = this.con.prepareStatement(query);
			pmt.setInt(1, c_id);

			rs = pmt.executeQuery();
			if (rs.next()) {
				hst = new History();
				hst.setId(rs.getInt("id"));
				hst.setChild_id(rs.getInt("child_id"));
				hst.setUrl(rs.getString("url"));
				hst.setTitle(rs.getString("title"));
				hst.setV_time(rs.getString("visit_time"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return hst;
	}
	
	public List<History> childHistory(int c_id) {
        List<History> list = new ArrayList<>();
        try {
        	String query = "SELECT * FROM history WHERE child_id=?";
            pmt = this.con.prepareStatement(query);
            pmt.setInt(1, c_id);
            
            rs = pmt.executeQuery();
            
            while (rs.next()) {
                History hst = new History();	
				
				hst.setId(rs.getInt("id"));
				hst.setChild_id(rs.getInt("child_id"));
				hst.setUrl(rs.getString("url"));
				hst.setTitle(rs.getString("title"));
				hst.setV_time(rs.getString("visit_time"));
                
                list.add(hst);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return list;
    }


}
