package users;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import model.UserList;

public class Patient extends User {

	//UserList test= new UserList();
	
	public Patient(String email, String password, String username, String phone, String gender, int age, String role) {
		super(email, password, username, phone, gender, age, role);
		// TODO Auto-generated constructor stub
	}

	public Patient() {
		
		User user = new Patient("patient@example.com", "123456", "Jane", "Doe", "Female", 25, "Patient");
		UserList.addUser(user);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String register(String email, String password, String username, String phone,String gender, int age, 
			String role) {
		if (password.length() >= 4 && password.length() <= 6) {
			User  user1= new Patient ( email, password,  username,  phone, gender,  age, role);
			UserList.addUser(user1);
			System.out.println("Patient registered successfully!");
			return "ok";
		} else {
			
			System.out.println("Password must be 4-6 characters long.");
		
		}
		return null;
	}

	@Override
	public boolean login(String email, String password) {
		
			    // check if the provided email and password match the ones stored in this user object
				  
				  Map<String, User> allUsers = UserList.getAllUsers();
				 
				  for (Map.Entry<String, User> entry : allUsers.entrySet()) {
 
					  if(entry.getKey().equalsIgnoreCase(email)&&entry.getValue().getPassword().equalsIgnoreCase(password)) {
						  System.out.println("Patient logged in successfully!");
						  return true;
						  
					  }
//					  else {
//							System.out.println("Invalid username or password.");
//
//						  return false;
//					  }
				  }
				  
			    return false;
			  }
	
	public ArrayList<String> listPhysician() {
		
		  ArrayList<String> list = new ArrayList<String>();
		  Map<String, User> allUsers = UserList.getAllUsers();
			 
		  for (Map.Entry<String, User> entry : allUsers.entrySet()) {

			  if(entry.getValue().getRole().equalsIgnoreCase("Physician")) {
				  
				 list.add(entry.getValue().getUsername());
				 
				  
			  }
		  }
		  Collections.sort(list);
		  
		  return list;
	}
	
	public ArrayList<String> listPharmacist() {
		
		  ArrayList<String> list = new ArrayList<String>();
		  Map<String, User> allUsers = UserList.getAllUsers();
		  
		  List<Map.Entry<String, User>> userList = new ArrayList<>(allUsers.entrySet());
		  Collections.sort(userList, Comparator.comparingInt(entry -> entry.getValue().getAge()));
		  
		  Map<String, User> sortedUsers = new LinkedHashMap<>();
	        for (Map.Entry<String, User> entry : userList) {
	            sortedUsers.put(entry.getKey(), entry.getValue());
	        }
			 
		  for (Map.Entry<String, User> entry : sortedUsers.entrySet()) {

			  if(entry.getValue().getRole().equalsIgnoreCase("Pharmacist")) {
				  
				 list.add(entry.getValue().getUsername());
				 
				  
			  }
		  }
		  
		  
		  return list;
	}

	@Override
	public boolean login(String phone, String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

}
