package anudip.com.service;

import java.time.LocalDateTime;
import java.util.List;
import anudip.com.entities.Appointment;


public interface AppointmentService
{
	public Appointment getAppointment(Long id);
	public Appointment getAppointment(String appointmentStatus);
	public Appointment getAppointment(LocalDateTime appointmentTime);
	public List<Appointment> getAppointment();
	public String insertAppointment(Appointment appointment);
	public String updateAppointment(Appointment appointment);
	public String deleteAppointment(Long id);
	
	
}
