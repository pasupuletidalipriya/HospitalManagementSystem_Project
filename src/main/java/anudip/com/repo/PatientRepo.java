package anudip.com.repo;
import org.springframework.data.jpa.repository.JpaRepository;


import anudip.com.entities.Patient;

public interface PatientRepo  extends JpaRepository<Patient,Long>
{
       public Patient findByPatientName(String patientName);  
       public Patient findByDiagnosis(String diagnosis);
      
}
