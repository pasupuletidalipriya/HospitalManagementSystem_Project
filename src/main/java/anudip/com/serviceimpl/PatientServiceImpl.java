//PatientServiceImpl class
//importing required classes and packages
package anudip.com.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import anudip.com.entities.Patient;
import anudip.com.repo.PatientRepo;
import anudip.com.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService
{
	@Autowired
	PatientRepo patientRepo;

	public PatientServiceImpl(PatientRepo patientRepo)
	{
		super();
		this.patientRepo=patientRepo;
	}
	 //retrieving the records by using patient Id
	@Override
	public Patient getPatient(Long id) 
	{
	   java.util.Optional<Patient> p=patientRepo.findById(id);
	   Patient p1=(Patient) p.get();
	   return p1;
	}
	 //retrieving the records by using patient name
	@Override
	public Patient getPatient(String patientName)
	{
		Patient p=patientRepo.findByPatientName(patientName);
		return p;
	}
	 //retrieving the records by using diagnosis
	@Override
	public Patient getPatients(String diagnosis)
	{
		Patient p=patientRepo.findByDiagnosis(diagnosis);
		return p;
	}
    //fetching the records
	@Override
	public List<Patient> getAllPatients() 
	{
		List<Patient> list=patientRepo.findAll();
		return list;
	}
    //insertion operation
	@Override
	public String insertPatient(Patient patient) 
	{
		patientRepo.save(patient);
		return "One record has been inserted";
	}
    //update operation
	@Override
	public String updatePatient(Patient patient) 
	{
		patientRepo.save(patient);
		return "One record has been updated";
	}
    //delete operation
	@Override
	public String deletePatient(Long id)
	{
		patientRepo.deleteById(id);
		return  "one record has been deleted";
	}
	
	
}
