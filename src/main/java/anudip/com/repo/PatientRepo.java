//Patient Repository Interface
//importing required classes and packages
package anudip.com.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import anudip.com.entities.Patient;

public interface PatientRepo  extends JpaRepository<Patient,Long>
{
       public Patient findByPatientName(String patientName);  //finding the details using patient name
       public Patient findByDiagnosis(String diagnosis);   //finding details using diagnosis
      
}
 