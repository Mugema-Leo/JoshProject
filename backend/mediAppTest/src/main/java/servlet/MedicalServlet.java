package servlet;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import javax.servlet.*;
//import javax.servlet.http.*;
import users.Patient;
import users.Pharmacist;
import users.Physician;
import users.User;
import model.UserList;

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
		Physician physician = new Physician();
		Pharmacist pharmacist = new Pharmacist();
		Patient patient = new Patient();
		
		
		patient.listPhysician();
		patient.listPharmacist();
		Map<String, User> allUsers = UserList.getAllUsers();
		System.out.println("All users: " + allUsers);
		
		
		ObjectMapper mapper = new ObjectMapper();
		Map<String, ArrayList<String>> data = new HashMap<>();
		data.put("list1", patient.listPhysician());
		data.put("list2", patient.listPharmacist());
		String json = mapper.writeValueAsString(data);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		

		response.getWriter().write(json);
	}


	@SuppressWarnings("null")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	//	UserModel userModel = null;
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



		String returnValue4 = "";

		if (gender.length() > 0) {
			if (password.length() >= 4 && password.length() <= 6) {

				Patient patient = new Patient();
                String value=patient.register(email, password, username, phone, gender,  Integer.parseInt(age),role);
				
				if(value.equals("ok")) {
					
					response.getWriter().write("{\"success\": true, \"register\": \"sucessfully\"}");
				}

			}

			else if (password.length() >= 9 && password.length() <= 10) {

				Pharmacist pharmacist = new Pharmacist();
                String value=pharmacist.register(email, password, username, phone, gender,  Integer.parseInt(age),role);
				
				if(value.equals("ok")) {
					
					response.getWriter().write("{\"success\": true, \"register\": \"sucessfully\"}");
				}

			}

			else if (password.length() >= 7 && password.length() <= 8) {

				Physician physician = new Physician();
                String value=physician.register(email, password, username, phone, gender,  Integer.parseInt(age),role);
				
				if(value.equals("ok")) {
					
					response.getWriter().write("{\"success\": true, \"register\": \"sucessfully\"}");
				}
				

			} else {

				returnValue4 = "Wrong Password or Username";
				response.getWriter().write("{\"success\": false, \"register\": \"failed\"}");
			}
		} else {
			
			// login Patient // Pharmacist // Physician

			boolean loginSuccess = false;
			if (password.length() >= 4 && password.length() <= 6) {

				Patient patient = new Patient();
				loginSuccess = patient.login(email, password);
				System.out.println("Login success: " + loginSuccess);
				
				if(loginSuccess==true) {
					response.getWriter().write("{\"success\": true, \"role\": \"patient\"}");
				}
				

			} 
			

			if (password.length() >= 9 && password.length() <= 10) {

				Pharmacist pharmacist = new Pharmacist();
				loginSuccess = pharmacist.login(email, password);
				System.out.println("Login success: " + loginSuccess);
				if(loginSuccess==true) {
					response.getWriter().write("{\"success\": true, \"role\": \"pharmacist\"}");
				}
			}

			if (password.length() >= 7 && password.length() <= 8) {

				Physician physician = new Physician();
				loginSuccess = physician.login(email, password);
				System.out.println("Login success: " + loginSuccess);
				if(loginSuccess==true) {
					response.getWriter().write("{\"success\": true, \"role\": \"physician\"}");
				}

			}


		}

		
		// Grant the access to the Physican and Pharmacist
		
//		if(physicianAccess.length() > 0 || pharmacistAcess.length() > 0) 
//		{
//			boolean access=false;
//			if (physicianAccess.length() > 0 ) {
//				Patient patientGrant = new Patient();
//				patientGrant.listPharmacists();
//				patientGrant.grantAccessToPhysician(physicianAccess);
//				access=true;
//			}
//
//			if (pharmacistAcess.length() > 0) {
//				Patient pharmacist = new Patient();
//				pharmacist.grantAccessToPharmacist(pharmacistAcess);
//				access=true;
//			}
//			 
//			if(access==true) {
//				response.getWriter().write("{\"success\": true}");
//				
//			}else {
//				response.getWriter().write("{\"success\": false}");
//			}
//		}

//		//Patient patientGrant = new Patient();
//		//patientGrant.outputPatients();
//		System.out.println("done Fail");
//		//System.out.println("list pharmacist"+patientGrant.outputRegisteredPatients());
//		System.out.println("Available Patients:");
		
		
		
//		System.out.println(userModel.toString());
		//userModel.toString();

	}
}
