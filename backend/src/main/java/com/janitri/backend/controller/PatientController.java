package com.janitri.backend.controller;

import com.janitri.backend.model.Patient;
import com.janitri.backend.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patient/")
public class PatientController {

    @Autowired
    PatientService patientService;

    @PostMapping("add/{userId}")
    public ResponseEntity<?> addPatient(@PathVariable String userId, @RequestBody Patient patient){
        return patientService.addPatient(patient,userId);
    }

    @GetMapping("all")
    public ResponseEntity<?> getAllPatients(){
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPatientData(@PathVariable String id){
        return patientService.getPatientData(id);
    }
}
