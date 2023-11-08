//AppointmentServiceImpl class
//importing required classes and packages
package anudip.com.serviceimpl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import anudip.com.entities.Appointment;
import anudip.com.repo.AppointmentRepo;
import anudip.com.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService
{
    @Autowired
    AppointmentRepo appointmentRepo;
    
	public AppointmentServiceImpl(AppointmentRepo appointmentRepo) 
	{
		super();
		this.appointmentRepo=appointmentRepo;
	}
	 //retrieving the records by using appointment Id
	@Override
	public Appointment getAppointment(Long id)
	{
	java.util.Optional<Appointment> a=appointmentRepo.findById(id);
	Appointment a1=a.get();
	return a1 ;
	}
	//retrieving the records by using appointment status
	@Override
	public Appointment getAppointment(String appointmentStatus)
	{
		Appointment a=appointmentRepo.findByAppointmentStatus(appointmentStatus);
		return a;
	}
	//retrieving the records by using appointment time
	@Override
	public Appointment getAppointment(LocalDateTime appointmentTime) 
	{
		Appointment a=appointmentRepo.findByAppointmentTime(appointmentTime);
		return a;
	}
	//fetching the records
	@Override
	public List<Appointment> getAppointment()
	{
	    List<Appointment>  list=appointmentRepo.findAll();
		return list;
	}
    //insertion operation
	@Override
	public String insertAppointment(Appointment appointment)
	{
		appointmentRepo.save(appointment);
		return "One record has been inserted";
	}
    //update operation
	@Override
	public String updateAppointment(Appointment appointment) 
	{
		appointmentRepo.save(appointment);
		return "One record has been updated";
	}
    //delete operation
	@Override
	public String deleteAppointment(Long id) 
	{
		appointmentRepo.deleteById(id);
		return  "one record has been deleted";
	}

	
    
}
