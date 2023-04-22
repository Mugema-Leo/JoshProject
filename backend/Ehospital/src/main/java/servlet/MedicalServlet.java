package servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
import org.json.JSONObject;
//import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.ObjectMapper;


@WebServlet("/MedicalServlet")
public class MedicalServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //out.println("<html><body>");
        
        //out.println("<h2>Hello World</h2>");
        
        
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
		//out.println(patient.listPhysicians());
		
//		Set<String> physicianNames = patient.listPhysicians();
//		List<Physician> physicians = new ArrayList<>();
//		for(String physicianName : physicianNames) {
//		    physicians.add(new Physician());
//		}
//		for(Physician physiciant : physicians) {
//		    out.println(physiciant.toString());
//		}
		
		TreeSet<String> physicians = patient.listPhysicians();
		for(String physician1 : physicians) {
		   // out.println(physician1.toString());
		}

		// Convert the list of users to a JSON object
					ObjectMapper mapper = new ObjectMapper();
					String json = mapper.writeValueAsString(patient.listPhysicians());
					System.out.println("Data"+json);
					// Set the content type and character encoding of the response
					//out.print(json);
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
		//out.println("</body></html>");
    }
}
