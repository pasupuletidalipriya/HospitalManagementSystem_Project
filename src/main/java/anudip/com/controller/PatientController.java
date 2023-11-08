//RestController class of Patient entity
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

import anudip.com.entities.Patient;
import anudip.com.service.PatientService;

@RestController
@RequestMapping("/patients")
//class
public class PatientController
{
	@Autowired
	PatientService pservice;
    //constructor
	public PatientController(PatientService pservice) 
	{
		super();
		this.pservice=pservice;
	}
	//fetching the records of Patient details
	@GetMapping("/getall")
	public ResponseEntity<List<Patient>> getall()
	{
		List<Patient> list=pservice.getAllPatients();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	//inserting the values into the relation
	@PostMapping("/insert")
	public ResponseEntity<String> insert(@RequestBody Patient patient)
	{
		String p=pservice.insertPatient(patient);
		return new ResponseEntity<>(p,HttpStatus.CREATED);
	}
	//getting the records of particular row based on name
	@GetMapping("/getname/{name}")
	public ResponseEntity<Patient> getname(@PathVariable("name") String name)
    {
	    Patient p=pservice.getPatient(name);
	    return new ResponseEntity<>(p,HttpStatus.OK);
    }
	//getting the records of particular row based on diagnosis
	@GetMapping("/getdiagnosis/{diagnosis}")
	public ResponseEntity<Patient> getdiagnosis(@PathVariable("diagnosis") String diagnosis)
    {
	    Patient p=pservice.getPatient(diagnosis);
	    return new ResponseEntity<>(p,HttpStatus.OK);
    }
	//getting the records of particular row based on id
	@GetMapping("/get/{id}")
	public ResponseEntity<Patient> get(@PathVariable("id") Long patientId)
	{
		Patient p=pservice.getPatient(patientId);
		return new ResponseEntity<>(p,HttpStatus.OK);
	}
	//update operation
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody Patient patient)
	{
		String s=pservice.updatePatient(patient);
		return new ResponseEntity<>(s,HttpStatus.CREATED);
	}
	//deleting the records by using id
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Long id)
	{
		String s=pservice.deletePatient(id);
		return new ResponseEntity<>(s,HttpStatus.OK);
	}
	
	
}
