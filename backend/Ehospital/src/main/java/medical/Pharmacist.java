package medical;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeSet;
public class Pharmacist implements User {
    Map<String, String> pharmacists = new LinkedHashMap<>();

    @Override
    public void register(String phone, String identifier, String password, String name, int age, String gender) {
        if (password.length() >= 9 && password.length() <= 10) {
            pharmacists.put(String.format("%s %s", phone, identifier), password);
            System.out.println("Pharmacist registered successfully!");
        } else {
        System.out.println("Password must be 9-10 characters long.");
        }
        }
    @Override
    public boolean login(String phone, String identifier, String password) {
        if (pharmacists.containsKey(String.format("%s %s", phone, identifier)) && pharmacists.get(String.format("%s %s", phone, identifier)).equals(password)) {
            System.out.println("Pharmacist logged in successfully!");
            return true;
        } else {
            System.out.println("Invalid phone, identifier, or password.");
            return false;
        }
    }

    public void provideMedicines() {
        System.out.println("Providing medicines...");
    }
	@Override
	public boolean login(String identifier1, String identifier2) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void register(String email, String password, String name, int age, String gender) {
		// TODO Auto-generated method stub
		
	}
}
