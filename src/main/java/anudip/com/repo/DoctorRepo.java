package anudip.com.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import anudip.com.entities.Doctor;

public interface DoctorRepo extends JpaRepository<Doctor,Long>
{
    public Doctor findByDoctorName(String name);
    public Doctor findBySpecialization(String specialization);
    

}
