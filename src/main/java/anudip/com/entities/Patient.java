//Patient entity class with accounts and transaction details
//importing required packages and classes 
package anudip.com.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Data;

@Data //generates the constructors,setters-getters, toString methods
@Entity //Entity annotation
public class Patient
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String patientName;
	private int age;
	private String gender;
	private String address;
	private String emergencyContactNumber;
	private String diagnosis;
    private String treatment;
    private double bill;
}