//PatientService interface
//importing required classes and packages
package anudip.com.service;
import java.util.List;
import anudip.com.entities.Patient;

public interface PatientService 
{
	public Patient getPatient(Long id);
	public Patient getPatient(String patientName);
	public Patient getPatients(String diagnosis);
	public List<Patient> getAllPatients();
	public String insertPatient(Patient patient);
	public String updatePatient(Patient patient);
	public String deletePatient(Long id);
	

}
