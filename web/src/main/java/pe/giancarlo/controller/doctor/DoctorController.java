package pe.giancarlo.controller.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.giancarlo.model.doctor.Doctor;
import pe.giancarlo.service.doctor.DoctorService;

import java.util.List;
import java.util.logging.Logger;

@RequestMapping("/doctors")
@RestController
public class DoctorController {
    Logger logger = Logger.getLogger(DoctorController.class.getName());

    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/all")
    public List<Doctor> findAll() {
        logger.info("Doctors found");
        return doctorService.findAll();
    }

    @GetMapping("/find/{id}")
    public Doctor findById(@PathVariable int id) {
        logger.info("Doctor found");
        return doctorService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(int id) {
        doctorService.delete(id);
        logger.info("Doctor deleted");
        return "Doctor deleted";
    }

    @PutMapping("/update/{id}")
    public Doctor update(@PathVariable int id,@RequestBody Doctor doctor) {
        logger.info("Doctor updated");
        return doctorService.update(id, doctor);
    }

    @PostMapping("/save")
    public String save(@RequestBody Doctor doctor) {
        doctorService.save(doctor);
        logger.info("Doctor saved");
        return "Doctor saved";
    }
}
