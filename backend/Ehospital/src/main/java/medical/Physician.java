package medical;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeSet;

public class Physician implements User {
	Map<String, String> physicians = new LinkedHashMap<>();

	@Override
	public void register(String email, String password, String name, int age, String gender) {
		
		if (password.length() >= 7 && password.length() <= 8) {
			physicians.put(email, password);
			System.out.println("Physician registered successfully!");
		} else {
			System.out.println("Password must be 7-8 characters long.");
		}
	}

	@Override
	public boolean login(String email, String password) {
		if (physicians.containsKey(email) && physicians.get(email).equals(password)) {
			System.out.println("Physician logged in successfully!");
			return true;
		} else {
			System.out.println("Invalid email or password.");
			return false;
		}
	}

	@Override
	public void register(String identifier1, String identifier2, String password, String name, int age, String gender) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean login(String phone, String identifier, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	public Map<String, String> getPhysicians() {
		return physicians;
	}

	public void setPhysicians(Map<String, String> physicians) {
		this.physicians = physicians;
	}

	@Override
	public String toString() {
		return "Physician [physicians=" + physicians + "]";
	}
	
	
	
	
}
