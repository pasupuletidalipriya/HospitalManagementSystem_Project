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

	@Override
	public Patient getPatient(Long id) 
	{
	   java.util.Optional<Patient> p=patientRepo.findById(id);
	   Patient p1=(Patient) p.get();
	   return p1;
	}

	@Override
	public Patient getPatient(String patientName)
	{
		Patient p=patientRepo.findByPatientName(patientName);
		return p;
	}
	@Override
	public Patient getPatients(String diagnosis)
	{
		Patient p=patientRepo.findByDiagnosis(diagnosis);
		return p;
	}

	@Override
	public List<Patient> getAllPatients() 
	{
		List<Patient> list=patientRepo.findAll();
		return list;
	}

	@Override
	public String insertPatient(Patient patient) 
	{
		patientRepo.save(patient);
		return "One record has been inserted";
	}

	@Override
	public String updatePatient(Patient patient) 
	{
		patientRepo.save(patient);
		return "One record has been updated";
	}

	@Override
	public String deletePatient(Long id)
	{
		patientRepo.deleteById(id);
		return  "one record has been deleted";
	}
	
	
}
