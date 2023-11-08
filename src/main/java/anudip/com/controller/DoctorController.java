//RestController class of Doctor entity
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

import anudip.com.entities.Doctor;
import anudip.com.service.DoctorService;

@RestController
@RequestMapping("/doctors")
//class
public class DoctorController 
{
     @Autowired
     DoctorService dservice;
    //constructor
	public DoctorController( DoctorService dservice)
	{
		super();
		this.dservice=dservice;
	}
	//fetching the records of Doctor details
	@GetMapping("/getall")
	public ResponseEntity<List<Doctor>> getall()
	{
		List<Doctor> list=dservice.getAllDoctors();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	//inserting the values into the relation
	@PostMapping("/insert")
	public ResponseEntity<String> insert(@RequestBody Doctor doctor)
	{
		String s=dservice.insertDoctor(doctor);
		return new ResponseEntity<>(s,HttpStatus.CREATED);
	}
	//getting the records of particular row based on name
	@GetMapping("/getname/{name}")
	public ResponseEntity<Doctor> getname(@PathVariable("name") String name)
    {
	    Doctor d=dservice.getDoctor(name);
	    return new ResponseEntity<>(d,HttpStatus.OK);
    }
	//getting the records of particular row based on specialization
	@GetMapping("/getspecialization/{specialization}")
	public ResponseEntity<Doctor> getspecialization(@PathVariable("specialization") String specialization)
    {
	    Doctor d=dservice.getDoctor(specialization);
	    return new ResponseEntity<>(d,HttpStatus.OK);
    }
	//getting the records of particular row based on id
	@GetMapping("/get/{id}")
	public ResponseEntity<Doctor> get(@PathVariable("id")Long doctorName)
	{
		Doctor d=dservice.getDoctor(doctorName);
		return new ResponseEntity<>(d,HttpStatus.OK);
	}
	//update operation
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody Doctor doctor)
	{
		String s=dservice.updateDoctor(doctor);
		return new ResponseEntity<>(s,HttpStatus.CREATED);
	}
	//deleting the records by using id
	@DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id)
	{
		String s=dservice.deleteDoctor(id);
		return new ResponseEntity<>(s,HttpStatus.OK);
	}	
}
