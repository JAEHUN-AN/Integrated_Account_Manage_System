package vo;

public class AdminVO {
	String id;
	String pw;
	String name;
	
	public AdminVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public AdminVO(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}

	public AdminVO(String id, String pw, String name) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
