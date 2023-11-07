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
public class PatientController
{
	@Autowired
	PatientService pservice;

	public PatientController(PatientService pservice) 
	{
		super();
		this.pservice=pservice;
	}
	@GetMapping("/getall")
	public ResponseEntity<List<Patient>> getall()
	{
		List<Patient> list=pservice.getAllPatients();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}

	@PostMapping("/insert")
	public ResponseEntity<String> insert(@RequestBody Patient patient)
	{
		String p=pservice.insertPatient(patient);
		return new ResponseEntity<>(p,HttpStatus.CREATED);
	}
	@GetMapping("/getname/{name}")
	public ResponseEntity<Patient> getname(@PathVariable("name") String name)
    {
	    Patient p=pservice.getPatient(name);
	    return new ResponseEntity<>(p,HttpStatus.OK);
    }
	@GetMapping("/getdiagnosis/{diagnosis}")
	public ResponseEntity<Patient> getdiagnosis(@PathVariable("diagnosis") String diagnosis)
    {
	    Patient p=pservice.getPatient(diagnosis);
	    return new ResponseEntity<>(p,HttpStatus.OK);
    }
	@GetMapping("/get/{id}")
	public ResponseEntity<Patient> get(@PathVariable("id") Long patientId)
	{
		Patient p=pservice.getPatient(patientId);
		return new ResponseEntity<>(p,HttpStatus.OK);
	}
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody Patient patient)
	{
		String s=pservice.updatePatient(patient);
		return new ResponseEntity<>(s,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Long id)
	{
		String s=pservice.deletePatient(id);
		return new ResponseEntity<>(s,HttpStatus.OK);
	}
	
	
}
