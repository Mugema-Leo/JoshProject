package users;

import java.util.Map;

import model.UserList;

public class Physician extends User {

	public Physician(String email, String password, String username, String phone, String gender, int age,
			String role) {
		super(email, password, username, phone, gender, age, role);
		// TODO Auto-generated constructor stub
	}

	public Physician() {
		// TODO Auto-generated constructor stub
		User user = new Pharmacist("physician@example.com", "12345678", "Jane", "Doe", "Female", 25, "Physician");
		UserList.addUser(user);
	}

	@Override
	public String register(String email, String password, String username, String phone,String gender, int age, 
			String role) {
		if (password.length() >= 7 && password.length() <= 8) {
			User  user1= new Pharmacist ( email, password,  username,  phone, gender,  age, role);
			UserList.addUser(user1);
			System.out.println("physician registered successfully!");
			return "ok";
		} else {
			
			System.out.println("Pharmacist must be 7-8 characters long.");
		
		}
		return null;
	}

	@Override
	public boolean login(String email, String password) {
		
	    // check if the provided email and password match the ones stored in this user object
		  
		  Map<String, User> allUsers = UserList.getAllUsers();
		 
		  for (Map.Entry<String, User> entry : allUsers.entrySet()) {

			  if(entry.getKey().equalsIgnoreCase(email)&&entry.getValue().getPassword().equalsIgnoreCase(password)) {
				  System.out.println("Physian logged in successfully!");
				  return true;
				  
			  }
//			  else {
//					System.out.println("Invalid username or password.");
//
//				  return false;
//			  }
		  }
		  
	    return false;
	  }

	@Override
	public boolean login(String phone, String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

}
