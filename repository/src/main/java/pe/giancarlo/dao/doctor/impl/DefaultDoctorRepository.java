package pe.giancarlo.dao.doctor.impl;

import pe.giancarlo.dao.doctor.DoctorRepository;
import org.springframework.stereotype.Repository;
import pe.giancarlo.model.doctor.Doctor;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Repository
public class DefaultDoctorRepository implements DoctorRepository {
    Logger logger = Logger.getLogger(DefaultDoctorRepository.class.getName());

    private final List<Doctor> doctors = new ArrayList<>();

    @Override
    public void save(Doctor doctor){
        doctors.add(doctor);
        logger.log(Level.INFO, "Doctor saved");
    }
    @Override
    public void delete(Doctor doctor){
        doctors.stream().filter(d -> d.getId() == doctor.getId()).findFirst().ifPresent(doctors::remove);
        logger.log(Level.INFO, "Doctor deleted");
    }
    @Override
    public Doctor update(Doctor doctor){
        doctors.stream().filter(d -> d.getId() == doctor.getId())
                .findFirst()
                .ifPresent(d -> {
                    d.setName(doctor.getName());
                    d.setLastName(doctor.getLastName());
                    d.setSpeciality(doctor.getSpeciality());
                });
        logger.log(Level.INFO,"Doctor updated");
        return doctor;
    }
    @Override
    public Doctor findById(int id){
        logger.log(Level.INFO,"Doctor found");
        return doctors.stream().filter(d -> d.getId() == id).findFirst().orElse(null);
    }
    @Override
    public List<Doctor> findAll(){
        // Find all doctors
        logger.log(Level.INFO,"Doctors found");
        return doctors;
    }
}
