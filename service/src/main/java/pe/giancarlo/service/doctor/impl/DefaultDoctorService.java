package pe.giancarlo.service.doctor.impl;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.giancarlo.dao.doctor.DoctorRepository;
import pe.giancarlo.model.doctor.Doctor;
import pe.giancarlo.service.doctor.DoctorService;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class DefaultDoctorService implements DoctorService {

    Logger logger = Logger.getLogger(DefaultDoctorService.class.getName());

    private final DoctorRepository doctorRepository;

    @Autowired
    public DefaultDoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @PostConstruct
    public void init() {
        logger.log(Level.INFO, "Doctor service started post construct");
        doctorRepository.save(new Doctor(correlativeId(),"Juan", "Perez", "Cardiologist"));
    }

    @Override
    public void save(Doctor doctor) {
        doctor.setId(correlativeId());
        doctorRepository.save(doctor);
        logger.log(Level.INFO, "Doctor saved");
    }

    @Override
    public void delete(int id) {
        Doctor doctor = this.findById(id);
        if(doctor == null) {
            return;
        }
        doctorRepository.delete(doctor);
        logger.log(Level.INFO, "Doctor deleted");
    }

    @Override
    public Doctor update(int id, Doctor doctor) {
        Doctor doctorFound = this.findById(id);
        if(doctorFound == null) {
            return null;
        }
        logger.log(Level.INFO,"Doctor updated");
        return doctorRepository.update(doctor);
    }

    @Override
    public Doctor findById(int id) {
        Doctor doctorFound = doctorRepository.findById(id);
        if(doctorFound == null) {
            logger.log(Level.INFO, "Doctor not found");
            return null;
        }
        logger.log(Level.INFO,"Doctor found");
        return doctorFound;
    }

    @Override
    public List<Doctor> findAll() {
        logger.log(Level.INFO,"Doctors found");
        return doctorRepository.findAll();
    }

    private int correlativeId() {
        return doctorRepository.findAll().size() + 1;
    }
}
