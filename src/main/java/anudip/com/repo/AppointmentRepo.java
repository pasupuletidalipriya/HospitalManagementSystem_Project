//Appointment Repository Interface
//importing required classes and packages
package anudip.com.repo;
import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;

import anudip.com.entities.Appointment;


public interface AppointmentRepo extends JpaRepository<Appointment,Long>
{
	 public Appointment findByAppointmentStatus(String appointmentStatus); //finding details using Appointment status
	 public Appointment findByAppointmentTime(LocalDateTime appointmentTime); //finding details using Appointment time
}
