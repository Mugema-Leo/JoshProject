package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import javax.servlet.*;
//import javax.servlet.http.*;
import medical.Patient;
import medical.Pharmacist;
import medical.Physician;
import medical.UserModel;

import org.json.JSONObject;

import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/MedicalServlet")
public class MedicalServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// out.println("<html><body>");

		// out.println("<h2>Hello World</h2>");

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
		// out.println(patient.listPhysicians());

//		Set<String> physicianNames = patient.listPhysicians();
//		List<Physician> physicians = new ArrayList<>();
//		for(String physicianName : physicianNames) {
//		    physicians.add(new Physician());
//		}
//		for(Physician physiciant : physicians) {
//		    out.println(physiciant.toString());
//		}

		TreeSet<String> physicians = patient.listPhysicians();
		for (String physician1 : physicians) {
			// out.println(physician1.toString());
		}

		// Convert the list of users to a JSON object
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(patient.listPhysicians());
		System.out.println("Data" + json);
		// Set the content type and character encoding of the response
		// out.print(json);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		// Write the JSON object to the response

		response.getWriter().write(json);

//					PrintWriter outt = response.getWriter();
//					out.println(outt);
		//
//									    // Write the result to the output stream
////									    out.println(result);

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
		// out.println("</body></html>");

		Map<String, UserModel> users = Patient.getAllUsers();
		System.out.println("Size" + users.size());

		for (Map.Entry<String, UserModel> entry : users.entrySet()) {
			System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		StringBuilder sb = new StringBuilder();
		BufferedReader reader = request.getReader();
		String line;
		while ((line = reader.readLine()) != null) {
			System.out.println("role2: " + line);
			sb.append(line);
		}
		String json = sb.toString();
		ObjectMapper mapper = new ObjectMapper();
		Map<String, String> formData = mapper.readValue(json, new TypeReference<Map<String, String>>() {
		});
//		Map<String, String> formData = mapper.readValue(json, new TypeReference<>() {});

		String username = "";
		String password = "";
		String email = "";
		String gender = "";
		String role = "";
		String age = "";
		String phone = "";
		String pharmacistAcess = "";
		String physicianAccess = "";

		for (Map.Entry<String, String> entry : formData.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());

			if (entry.getKey().equals("email")) {
				email = entry.getValue();
				System.out.println(email);

			}
			if (entry.getKey().equals("password")) {
				password = entry.getValue();
				System.out.println(password);

			}
//			if (entry.getKey().equals("firstName")) {
//				firstName = entry.getValue();
//				action = "firstName";
//
//			}
			if (entry.getKey().equals("username")) {
				username = entry.getValue();
				System.out.println(username);

			}
			if (entry.getKey().equals("gender")) {
				gender = entry.getValue();
				System.out.println(gender);

			}
			if (entry.getKey().equals("role")) {
				role = entry.getValue();
				System.out.println(role);

			}

			if (entry.getKey().equals("age")) {
				age = entry.getValue();
				System.out.println(age);

			}

		}

		// Signup Patient , Pharmacist, and Physician

//		if (role.equalsIgnoreCase("Pharmacist")) {
//
//			Patient patient = new Patient();
//			patient.register(username, password, username, Integer.parseInt(age), gender);
//
//			Map<String, UserModel> users = Patient.getAllUsers();
//			System.out.println("Size" + users.size());
//
//			for (Map.Entry<String, UserModel> entry : users.entrySet()) {
//				System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
//			}
//
//			
//			
//			if (role.equalsIgnoreCase("Pharmacist")) {
//
//				Pharmacist pharmacist = new Pharmacist();
//				pharmacist.register(phone, username, password, username, Integer.parseInt(age), gender);
//
//
//			}
//			
//			
//			if (role.equalsIgnoreCase("Pharmacist")) {
//				
//				Physician physician = new Physician();
//				physician.register(email, password, username, Integer.parseInt(age), gender);
//				
//
//			}

		String returnValue4 = "";

		if (gender.length() > 0) {
			if (password.length() >= 4 && password.length() <= 6) {

				Patient patient = new Patient();
				patient.register(username, password, username, Integer.parseInt(age), gender);

				response.getWriter().write("{\"success\": true, \"username\": \"gender\"}");

				Map<String, UserModel> users = Patient.getAllUsers();
				System.out.println("Size" + users.size());

				for (Map.Entry<String, UserModel> entry : users.entrySet()) {
					System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
				}

			}

			else if (password.length() >= 9 && password.length() <= 10) {

				Pharmacist pharmacist = new Pharmacist();
				pharmacist.register(phone, username, password, username, Integer.parseInt(age), gender);

			}

			else if (password.length() >= 7 && password.length() <= 8) {

				Physician physician = new Physician();
				physician.register(email, password, username, Integer.parseInt(age), gender);

			} else {

				returnValue4 = "Wrong Password or Username";
			}
		} else {
			
			// login Patient // Pharmacist // Physician

			boolean loginSuccess = false;
			if (password.length() >= 4 && password.length() <= 6) {

				Patient patient = new Patient();
				loginSuccess = patient.login(username, password);
				System.out.println("Login success: " + loginSuccess);

			} 
			

			if (password.length() >= 9 && password.length() <= 10) {

				Pharmacist pharmacist = new Pharmacist();
				loginSuccess = pharmacist.login(phone, username, password);
				System.out.println("Login success: " + loginSuccess);
			}

			if (password.length() >= 7 && password.length() <= 8) {

				Physician physician = new Physician();
				loginSuccess = physician.login(email, password);
				System.out.println("Login success: " + loginSuccess);

			}

			if (loginSuccess == false) {

				response.getWriter().write("{\"success\": false}");

			}

			if (loginSuccess == true) {

				response.getWriter().write("{\"success\": true}");

			}

		}

		
		// Grant the access to the Physican and Pharmacist
		
		if(physicianAccess.length() > 0 || pharmacistAcess.length() > 0) 
		{
			boolean access=false;
			if (physicianAccess.length() > 0 ) {
				Patient patientGrant = new Patient();
				patientGrant.listPharmacists();
				patientGrant.grantAccessToPhysician(physicianAccess);
				access=true;
			}

			if (pharmacistAcess.length() > 0) {
				Patient pharmacist = new Patient();
				pharmacist.grantAccessToPharmacist(pharmacistAcess);
				access=true;
			}
			
			if(access==true) {
				response.getWriter().write("{\"success\": true}");
				
			}else {
				response.getWriter().write("{\"success\": false}");
			}
		}

		Patient patientGrant = new Patient();
		System.out.println("list pharmacist"+patientGrant.listPharmacists());

	}
}
