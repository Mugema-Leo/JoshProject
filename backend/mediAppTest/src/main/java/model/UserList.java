package model;



import java.util.LinkedHashMap;
import java.util.Map;


import users.Patient;
import users.Pharmacist;
import users.Physician;
import users.User;

public class UserList {
  private static LinkedHashMap<String, User> users = new LinkedHashMap<>();
  
  public UserList() {
	  User  user1=  new Patient ("mugema@gmail.com","12345","mugema","leonidas","male", 30,"Patient");
	  User  user3=  new Pharmacist ("Keza@gmail.com","12345","mugema","Keza","male", 70,"Pharmacist");
	  User  user4= new Physician ("sinzi@gmail.com","12345","sinzi","leo","female", 80,"Physician");
	  users.put("mugema@gmail.com",user1 ); 
	  users.put("Keza@gmail.com",user3 );
	  users.put("sinzi@gmail.com",user4 );
  }
 
  public static void addUser(User user) {
    users.put(user.getEmail(), user);
  }
 
  public static User getUser(String email) {
    return users.get(email);
  }

  public static boolean containsEmail(String email) {
    return users.containsKey(email);
  }

  public static void removeUser(String email) {
    users.remove(email);
  }

  public static Map<String, User> getAllUsers() {
    return users;
  }
}

