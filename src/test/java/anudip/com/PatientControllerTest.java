//importing necessary packages and classes

package anudip.com;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import anudip.com.controller.PatientController;
import anudip.com.entities.Patient;
import anudip.com.service.PatientService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
//public class PatientControllerTest class for jUnit testing

public class PatientControllerTest 
{
	private PatientController patientController;

	// creating mock bean for patientService
	@Mock
	private PatientService patientService;

	@BeforeEach
	void setUp() 
	{
		MockitoAnnotations.openMocks(this);
		patientController = new PatientController(patientService);
	}

	// creating methods for testing the methods of the controller class and
	// verifying the expected and actual output
	@Test
	void testGetAllPatients() {
		List<Patient> patients = Arrays.asList(new Patient(), new Patient());
		Mockito.when(patientService.getAllPatients()).thenReturn(patients);

		ResponseEntity<List<Patient>> responseEntity = patientController.getall();

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(patients, responseEntity.getBody());
	}

	@Test
	void testInsertPatient() {
		Patient patients = new Patient();
		Mockito.when(patientService.insertPatient(patients)).thenReturn("Patient inserted successfully.");

		ResponseEntity<String> responseEntity = patientController.insert(patients);

		assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
		assertEquals("Patient inserted successfully.", responseEntity.getBody());
	}

	@Test
	void testUpdatePatient()
	{
		Patient patients = new Patient();		
		Mockito.when(patientService.updatePatient(patients)).thenReturn("Patients updated successfully.");

		ResponseEntity<String> responseEntity = patientController.update(patients);

		assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
		assertEquals("Patients updated successfully.", responseEntity.getBody());
	}

	@Test
	void testDeletePatient() {
		Long patientId = (long) 1;
		Mockito.when(patientService.deletePatient(patientId)).thenReturn("Patients deleted successfully.");

		ResponseEntity<String> responseEntity = patientController.delete(patientId);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals("Patients deleted successfully.", responseEntity.getBody());
	}

	@Test
	void testGetPatientById() {
		Long patientId = (long) 1;
		Patient patients = new Patient();
		Mockito.when(patientService.getPatient(patientId)).thenReturn(patients);

		ResponseEntity<Patient> responseEntity = patientController.get(patientId);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(patients, responseEntity.getBody());
	}

	@Test
	void testGetPatientByName() {
		String patientName = "Venu";
		Patient patients = new Patient();
		Mockito.when(patientService.getPatient(patientName)).thenReturn(patients);

		ResponseEntity<Patient> responseEntity = patientController.getname(patientName);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(patients, responseEntity.getBody());
	}

	/*
	 * @Test void testGetPatientByDiagnosis() { String diagnosis = "Hair Fall";
	 * Patient patients = new Patient();
	 * Mockito.when(patientService.getPatients(diagnosis)).thenReturn(patients);
	 * 
	 * ResponseEntity<Patient> responseEntity =
	 * patientController.getdiagnosis(diagnosis);
	 * 
	 * assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	 * assertEquals(patients, responseEntity.getBody()); }
	 */
	
	
}