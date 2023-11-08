//DoctorServiceImpl class
//importing required classes and packages
package anudip.com.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import anudip.com.entities.Doctor;
import anudip.com.repo.DoctorRepo;
import anudip.com.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService
{
	@Autowired
    DoctorRepo doctorRepo;
    
	public DoctorServiceImpl(DoctorRepo doctorRepo) 
	{
		super();
		this.doctorRepo = doctorRepo;
	}
	//retrieving records by using Doctor Id
	@Override
	public Doctor getDoctor(Long id) 
	{
		Optional<Doctor> d=doctorRepo.findById(id);
		Doctor d1=d.get();
		return d1;
	}
	//retrieving records by using Doctor name
	@Override
	public Doctor getDoctor(String doctorName)
	{
		Doctor d=doctorRepo.findByDoctorName(doctorName);
		return d;
	}
	//retrieving records by using specialization
	@Override
	public Doctor getDoctors(String specialization) 
	{
		Doctor d=doctorRepo.findBySpecialization(specialization);
		return d;
	}
    //fetching the records
	@Override
	public List<Doctor> getAllDoctors() 
	{
		List<Doctor> list=doctorRepo.findAll();
		return list;
	}
    //insertion operation
	@Override
	public String insertDoctor(Doctor doctor) 
	{
		doctorRepo.save(doctor);
		return "One record has been inserted";
	}
    //update operation
	@Override
	public String updateDoctor(Doctor doctor)
	{
		doctorRepo.save(doctor);
		return "One record has been updated";
	}
    //delete operation
	@Override
	public String deleteDoctor(Long id)
	{
		doctorRepo.deleteById(id);
		return "one record has been deleted";
	}
	
}
