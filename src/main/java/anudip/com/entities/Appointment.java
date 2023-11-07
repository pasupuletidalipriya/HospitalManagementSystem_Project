package anudip.com.entities;


import java.time.LocalDate;
import java.time.LocalTime;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Appointment
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	private Long doctorId;
    private Long patientId;
	private LocalDate appointmentDate;
	private LocalTime appointmentTime;
	private String appointmentStatus;
	
}