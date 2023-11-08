//DoctorService  interface
//importing required classes and packages
package anudip.com.service;
import java.util.List;
import anudip.com.entities.Doctor;

public interface DoctorService 
{
	public Doctor getDoctor(Long doctorId);
    public Doctor getDoctor(String doctorName);
    public Doctor getDoctors(String specialization);
    public List<Doctor> getAllDoctors();
    public String insertDoctor(Doctor doctor);
    public String updateDoctor(Doctor doctor);
    public String deleteDoctor(Long doctorId);
    
}

