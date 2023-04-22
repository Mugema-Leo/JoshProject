package medical;

public class Main {
	public static void main(String[] args) {
		Patient patient = new Patient();
		Physician physician = new Physician();
		Pharmacist pharmacist = new Pharmacist();
// Register patients
		patient.register("john123", "1234", "John Doe", 35, "Male");
		patient.register("jane456", "56789", "Jane Smith", 25, "Female");

// Register physicians
		physician.register("drsmith@gmail.com", "password", "Dr. Smith", 40, "Male");
		physician.register("drjones@gmail.com", "password123", "Dr. Jones", 45, "Female");

// Register pharmacists
		pharmacist.register("111-222-3333", "ID123", "password123", "Bob Johnson", 30, "Male");
		pharmacist.register("444-555-6666", "ID456", "password456", "Alice Smith", 35, "Female");

// Add physicians to patient's list
		patient.physicians.add("Dr. Jones");
		patient.physicians.add("Dr. Smith");

// Add pharmacists to patient's list
		patient.pharmacists.add("Alice Smith");
		patient.pharmacists.add("Bob Johnson");

// List available physicians
		System.out.println("Available physicians:");
		patient.listPhysicians();

// Grant access to physician
		patient.grantAccessToPhysician("Dr. Smith");

// Login patient
		patient.login("john123", "1234");

// Try to access physician consultation without access
		System.out.println("Trying to access physician consultation without access:");
		patient.grantAccessToPhysician("Dr. Jones");

// Grant access to physician
		patient.grantAccessToPhysician("Dr. Jones");

// List available pharmacists
		System.out.println("Available pharmacists:");
		patient.listPharmacists();

// Grant access to pharmacist
		patient.grantAccessToPharmacist("Bob Johnson");

// Try to access pharmacist consultation without access
		System.out.println("Trying to access pharmacist consultation without access:");
		patient.grantAccessToPharmacist("Alice Smith");

// Grant access to pharmacist
		patient.grantAccessToPharmacist("Alice Smith");
	}
}
