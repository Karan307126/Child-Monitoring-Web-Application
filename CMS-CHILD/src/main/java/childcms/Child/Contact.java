package childcms.Child;

public class Contact {

	private int id;
	private int child_id;
	private int phone_number;
	private String Ctime;

	public Contact() {
	}

	public Contact(int child_id, int phone_number) {
		this.child_id = child_id;
		this.phone_number = phone_number;
	}

	
	
	public Contact(int child_id, int phone_number, String ctime) {
		super();
		this.child_id = child_id;
		this.phone_number = phone_number;
		Ctime = ctime;
	}

	public Contact(int id, int child_id, int phone_number, String ctime) {
		this.id = id;
		this.child_id = child_id;
		this.phone_number = phone_number;
		Ctime = ctime;
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

	public int getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(int phone_number) {
		this.phone_number = phone_number;
	}

	public String getCtime() {
		return Ctime;
	}

	public void setCtime(String ctime) {
		Ctime = ctime;
	}

	
	
}
