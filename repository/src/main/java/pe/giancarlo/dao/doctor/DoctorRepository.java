package pe.giancarlo.dao.doctor;

import pe.giancarlo.model.doctor.Doctor;

import java.util.List;

public interface DoctorRepository {
    void save(Doctor doctor);
    void delete(Doctor doctor);
    Doctor update(Doctor doctor);
    Doctor findById(int id);
    List<Doctor> findAll();
}
