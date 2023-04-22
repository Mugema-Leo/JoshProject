
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeSet;
class Patient implements User {
    Map<String, String> patients = new LinkedHashMap<>();
    Map<String, UserModel> patientInfo = new LinkedHashMap<>();
    TreeSet<String> physicians = new TreeSet<>();
    TreeSet<String> pharmacists = new TreeSet<>();

    @Override
    public void register(String username, String password, String name, int age, String gender) {
        if (password.length() >= 4 && password.length() <= 6) {
            patients.put(username, password);
            patientInfo.put(username, new UserModel(name, age, gender));
            System.out.println("Patient registered successfully!");
        } else {
            System.out.println("Password must be 4-6 characters long.");
        }
    }

    @Override
    public boolean login(String username, String password) {
        if (patients.containsKey(username) && patients.get(username).equals(password)) {
            System.out.println("Patient logged in successfully!");
            return true;
        } else {
            System.out.println("Invalid username or password.");
            return false;
        }
    }

    public void listPhysicians() {
        for (String physician : physicians) {
            System.out.println(physician);
        }
    }

    public void grantAccessToPhysician(String physician) {
        if (physicians.contains(physician)) {
            System.out.println("Access granted to " + physician);
        } else {
            System.out.println("Physician not found.");
        }
    }

    public void listPharmacists() {
        for (String pharmacist : pharmacists) {
            System.out.println(pharmacist);
        }
    }

    public void grantAccessToPharmacist(String pharmacist) {
        if (pharmacists.contains(pharmacist)) {
            System.out.println("Access granted to " + pharmacist);
        } else {
            System.out.println("Pharmacist not found.");
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
}
