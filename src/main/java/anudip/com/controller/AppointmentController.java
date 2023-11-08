//RestController class of Appointment entity
package anudip.com.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import anudip.com.entities.Appointment;
import anudip.com.service.AppointmentService;

@RestController
@RequestMapping("/appointment")
//class
public class AppointmentController 
{
	@Autowired
	AppointmentService aservice;
    //constructor
	public AppointmentController(AppointmentService aservice) 
	{
		super();
		this.aservice=aservice;
	}
	//fetching the records of Appointment details
	@GetMapping("/getall")
	public ResponseEntity<List<Appointment>> getall()
	{
		List<Appointment> list=aservice.getAppointment();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	//inserting the values into the relation
	@PostMapping("/insert")
	public ResponseEntity<String> insert(@RequestBody Appointment appointment)
	{
		String s=aservice.insertAppointment(appointment);
		return new ResponseEntity<>(s,HttpStatus.CREATED);
	}
	//getting the records of particular row based on status
	@GetMapping("/getstatus/{status}")
	public ResponseEntity<Appointment> getstatus(@PathVariable("status") String status)
    {
		Appointment a=aservice.getAppointment(status);
	    return new ResponseEntity<>(a,HttpStatus.OK);
    }
	//getting the records of particular row based on time
	@GetMapping("/getappointmenttime/{time}")
	public ResponseEntity<Appointment> getappointmenttime(@PathVariable("getappointmenttime") String getappointmenttime)
    {
		Appointment a=aservice.getAppointment(getappointmenttime);
	    return new ResponseEntity<>(a,HttpStatus.OK);
    }
	//getting the records of particular row based on id
	@GetMapping("/get/{id}")
	public ResponseEntity<Appointment> get(@PathVariable("id") Long id)
	{
		Appointment d=aservice.getAppointment(id);
		return new ResponseEntity<>(d,HttpStatus.OK);
	}
	//update operation
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody  Appointment appointment)
	{
		String s=aservice.updateAppointment(appointment);
		return new ResponseEntity<>(s,HttpStatus.CREATED);
	}
	//deleting the records by using id
    @DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Long id)
	{
		String s=aservice.deleteAppointment(id);
		return new ResponseEntity<>(s,HttpStatus.OK);
	}
	
}
