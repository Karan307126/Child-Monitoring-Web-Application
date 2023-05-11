package cms.User;

public class Location {
	private int id;
	private int child_id;
	private double lat;
	private double lon;
	private String l_time;

	public Location() {
		super();
	}

	
	
	public Location(int child_id, double lat, double lon, String l_time) {
		super();
		this.child_id = child_id;
		this.lat = lat;
		this.lon = lon;
		this.l_time = l_time;
	}



	public Location(int id, int child_id, double lat, double lon, String l_time) {
		super();
		this.id = id;
		this.child_id = child_id;
		this.lat = lat;
		this.lon = lon;
		this.l_time = l_time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getChild_id() {
		return child_id;
	}

	public void setChild_id(int child_id) {
		this.child_id = child_id;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public String getL_time() {
		return l_time;
	}

	public void setL_time(String l_time) {
		this.l_time = l_time;
	}

}
