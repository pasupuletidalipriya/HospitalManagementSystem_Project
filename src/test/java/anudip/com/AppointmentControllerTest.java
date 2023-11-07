//importing necessary packages and classes
package anudip.com;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import anudip.com.controller.AppointmentController;
import anudip.com.entities.Appointment;
import anudip.com.service.AppointmentService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

//AppointmentControllerTest class for jUnit testing
public class AppointmentControllerTest
{
	private AppointmentController appointmentController;

	// creating mock bean for appointmentService
	@Mock
	private AppointmentService appointmentService;

	@BeforeEach
	void setUp() 
	{
		MockitoAnnotations.openMocks(this);
		appointmentController = new AppointmentController(appointmentService);
	}
	
	// creating methods for testing the methods of the controller class and
	// verifying the expected and actual output

	@Test
	void testGetAllAppointment() 
	{
		List<Appointment> projects = Arrays.asList(new Appointment(), new Appointment());
		Mockito.when(appointmentService.getAppointment()).thenReturn(projects);

		ResponseEntity<List<Appointment>> responseEntity = appointmentController.getall();

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(projects, responseEntity.getBody());
	}

	@Test
	void testInsertAppointment() {
		Appointment appointment = new Appointment();
		Mockito.when(appointmentService.insertAppointment(appointment)).thenReturn("Appointment inserted successfully.");

		ResponseEntity<String> responseEntity = appointmentController.insert(appointment);

		assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
		assertEquals("Appointment inserted successfully.", responseEntity.getBody());
	}

	@Test
	void testUpdateAppointmentt() {
		Appointment appointment = new Appointment();
		
		Mockito.when(appointmentService.updateAppointment(appointment)).thenReturn("Appointment updated successfully.");

		ResponseEntity<String> responseEntity = appointmentController.update(appointment);

		assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
		assertEquals("Appointment updated successfully.", responseEntity.getBody());
	}

	@Test
	void testDeleteAppointment() {
		Long appointmentId = (long) 1;
		Mockito.when(appointmentService.deleteAppointment(appointmentId)).thenReturn("Appointment deleted successfully.");

		ResponseEntity<String> responseEntity = appointmentController.delete(appointmentId);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals("Appointment deleted successfully.", responseEntity.getBody());
	}

	@Test
	void testGetAppointmentById() {
		Long appointmentId = (long) 1;
		Appointment appointment = new Appointment();
		Mockito.when(appointmentService.getAppointment(appointmentId)).thenReturn(appointment);

		ResponseEntity<Appointment> responseEntity = appointmentController.get(appointmentId);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(appointment, responseEntity.getBody());
	}

	/*
	 * @Test void testGetAppointmentByName() { String projectName = "TestProject";
	 * Project project = new Project();
	 * Mockito.when(projectService.getProjectByName(projectName)).thenReturn(project
	 * );
	 * 
	 * ResponseEntity<Project> responseEntity =
	 * projectController.getPN(projectName);
	 * 
	 * assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	 * assertEquals(project, responseEntity.getBody()); }
	 */

	@Test
	void testGetAppointmentStatus() {
		String appointmentStatus = "Scheduled";
		Appointment appointment = new Appointment();
		Mockito.when(appointmentService.getAppointment(appointmentStatus)).thenReturn(appointment);

		ResponseEntity<Appointment> responseEntity = appointmentController.getstatus(appointmentStatus);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(appointment, responseEntity.getBody());
	}

	@Test
	void testGetAppointmentTime() {
		String appointmentTime = "10:00:00";
		Appointment appointment = new Appointment();
		Mockito.when(appointmentService.getAppointment(appointmentTime)).thenReturn(appointment);

		ResponseEntity<Appointment> responseEntity = appointmentController.getappointmenttime(appointmentTime);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(appointment, responseEntity.getBody());
	}
}