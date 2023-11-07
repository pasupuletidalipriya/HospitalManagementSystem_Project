//importing necessary packages and classes
package anudip.com;

import anudip.com.controller.DoctorController;
import anudip.com.entities.Doctor;
import anudip.com.service.DoctorService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

//DoctorControllerTest class for jUnit testing
public class DoctorControllerTest 
{
  private DoctorController doctorController;

  //creating mock bean for doctorService
  @Mock
  private DoctorService doctorService;

  @BeforeEach
  void setUp() 
  {
      MockitoAnnotations.openMocks(this);
      doctorController = new DoctorController(doctorService);
  }

  //creating methods for testing the methods of the controller class and verifying the expected and actual output
  @Test
  void testGetAllDoctors()
  {
      List<Doctor> doctors = Arrays.asList(new Doctor(), new Doctor());
      Mockito.when(doctorService.getAllDoctors()).thenReturn(doctors);

      ResponseEntity<List<Doctor>> responseEntity = doctorController.getall();

      assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
      assertEquals(doctors, responseEntity.getBody());
  }

  @Test
  void testInsertDoctor() 
  {
      Doctor doctor = new Doctor();
      Mockito.when(doctorService.insertDoctor(doctor)).thenReturn("Doctor inserted successfully.");

      ResponseEntity<String> responseEntity = doctorController.insert(doctor);

      assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
      assertEquals("Doctor inserted successfully.", responseEntity.getBody());
  }

  @Test
  void testUpdateDoctor()
  {
	  Doctor doctor = new Doctor();
      Mockito.when(doctorService.updateDoctor(doctor)).thenReturn("Doctor updated successfully.");

      ResponseEntity<String> responseEntity = doctorController.update(doctor);

      assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
      assertEquals("Doctor updated successfully.", responseEntity.getBody());
  }

  @Test
  void testDeleteDoctor() {
      Long doctorId = (long) 1;
      Mockito.when(doctorService.deleteDoctor(doctorId)).thenReturn("Doctor deleted successfully.");

      ResponseEntity<String> responseEntity = doctorController.delete(doctorId);

      assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
      assertEquals("Doctor deleted successfully.", responseEntity.getBody());
  }

  @Test
  void testGetDoctorById() 
  {
      Long doctorId = (long) 1;
      Doctor doctor = new Doctor();
      Mockito.when(doctorService.getDoctor(doctorId)).thenReturn(doctor);

      ResponseEntity<Doctor> responseEntity = doctorController.get(doctorId);

      assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
      assertEquals(doctor, responseEntity.getBody());
  }

  @Test
  void testGetDoctorByName() {
      String doctorName = "Sumalatha Reddy";
      Doctor doctor = new Doctor();
      Mockito.when(doctorService.getDoctor(doctorName)).thenReturn(doctor);

      ResponseEntity<Doctor> responseEntity =doctorController.getname(doctorName);

      assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
      assertEquals(doctor, responseEntity.getBody());
  }

	
	/*
	 * @Test void testGetDoctorByspecialization() { String specialization
	 * ="Dermatologist"; Doctor doctor = new Doctor();
	 * Mockito.when(doctorService.getDoctors(specialization)).thenReturn(doctor);
	 * 
	 * ResponseEntity<Doctor> responseEntity
	 * =doctorController.getspecialization(specialization);
	 * 
	 * assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	 * assertEquals(doctor, responseEntity.getBody()); }
	 */
  
  
}