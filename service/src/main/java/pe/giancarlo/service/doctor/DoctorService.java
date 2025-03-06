package pe.giancarlo.service.doctor;

import pe.giancarlo.model.doctor.Doctor;

import java.util.List;

public interface DoctorService {
    void save(Doctor doctor);
    void delete(int id);
    Doctor update(int id, Doctor doctor);
    Doctor findById(int id);
    List<Doctor> findAll();
}
