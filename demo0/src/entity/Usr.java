package entity;

public class Usr {
	private int id;
	private String name;
	private String password;
	private int roleId;
	private int flag;

	public Usr() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usr(int id, String name, String password, int roleId, int flag) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.roleId = roleId;
		this.flag = flag;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

}
