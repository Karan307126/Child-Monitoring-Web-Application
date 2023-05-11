package cms.User;

public class History {
	private int id;
	private int child_id;
	private String url;
	private String title;
	private String v_time;

	public History() {
		
	}
	
	




	public History(String title, String v_time) {
		super();
		this.title = title;
		this.v_time = v_time;
	}

	public History(int id, int child_id, String url, String title, String v_time) {

		this.id = id;
		this.child_id = child_id;
		this.url = url;
		this.title = title;
		this.v_time = v_time;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getV_time() {
		return v_time;
	}

	public void setV_time(String v_time) {
		this.v_time = v_time;
	}

}
