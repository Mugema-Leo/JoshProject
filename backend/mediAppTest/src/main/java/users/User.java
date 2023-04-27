package users;

public abstract class User {
	protected String email;
	protected String password;
	protected String username;
	protected String phone;
	protected String gender;
	protected int age;
	protected String role;

	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String email, String password, String username, String phone, String gender, int age, String role) {
		super();
		this.email = email;
		this.password = password;
		this.username = username;
		this.phone = phone;
		this.gender = gender;
		this.age = age;
		this.role = role;
	}

	public abstract String register(String email, String password, String username, String phone,String gender, int age, 
			String role);

	public abstract boolean login(String email, String password);

	public abstract boolean login(String phone, String username, String password);

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + ", username=" + username + ", phone=" + phone
				+ ", gender=" + gender + ", age=" + age + ", role=" + role + "]";
	}

}
