//Doctor  entity class with accounts and transaction details
//importing required packages and classes
package anudip.com.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data //generates the constructors,setters-getters, toString methods
@Entity //entity annotation
public class Doctor 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String doctorName;
	private String specialization;
	private String qualification;
	private String contactInfo;
	
}
