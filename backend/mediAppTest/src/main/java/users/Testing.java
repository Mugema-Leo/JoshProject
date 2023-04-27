package users;


import java.util.Map;

import model.UserList;

public class Testing {
	
	public static void main(String[] args) {
	
//		Patient patient = new Patient();
//		patient.register("patient@example.com", "123456", "Jane", "Doe", "Female", 25,"Patient");
//		patient.register("mugema@example.com", "1234", "Jane", "Doe", "Female", 25,"Patient");
//		
//
//	    // logins
//		boolean flag=patient.login("patient@example.com", "123");
//		System.out.println(flag);
//		
//		// Pharmacist
//		
//		
//		Pharmacist pharmacist = new Pharmacist();
//		pharmacist.register("pharmacist@example.com", "123456789", "Jane", "Doe", "Female", 25,"pharmacist");
//		pharmacist.register("mugema@example.com", "1234", "Jane", "Doe", "Female", 25,"pharmacist");
//		
//
//	    // logins
//		boolean flag2=pharmacist.login("pharmacist@example.com", "123456789");
//		System.out.println(flag2);
		
		
		// physician
		
		Physician physician = new Physician();
		physician.register("physician@example.com", "12345678", "Jane", "Doe", "Female", 25,"physician");
		physician.register("Yves@example.com", "1234", "Jane", "Doe", "Female", 25,"physician");
		

	    // logins
		boolean flag3=physician.login("physician@example.com", "12345678");
		System.out.println(flag3);

		
		
		  
//		///gettting one user
//		 User user = UserList.getUser("patient@example.com");
//		 System.out.println("User: " + user.age + " " + user.phone );
//		  
		 
		 
		  //all users
		  
		  Map<String, User> allUsers = UserList.getAllUsers();
		  System.out.println("All users: " + allUsers);
		}


}
