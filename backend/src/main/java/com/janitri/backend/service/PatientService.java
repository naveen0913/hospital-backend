package com.janitri.backend.service;

import com.janitri.backend.model.Patient;
import com.janitri.backend.model.User;
import com.janitri.backend.repository.PatientRepository;
import com.janitri.backend.repository.UserRepository;
import com.janitri.backend.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    PatientRepository patientRepository;

    @Autowired
    UserRepository userRepository;

    public ResponseEntity<?> addPatient(@NonNull Patient patient,String userId){
         User user = userRepository.findById(userId).orElseThrow(()-> new NoSuchElementException());
         if (user==null){
             return new ResponseEntity(new ApiResponse(HttpStatus.NOT_FOUND.value(), "user not found"), HttpStatus.NOT_FOUND) ;
         }
         patient.setDateOfAdmission(LocalDate.now());
         patient.setUser(user);
         patientRepository.save(patient);
         return new ResponseEntity(new ApiResponse(HttpStatus.CREATED.value(), "Patient Created Successfully"), HttpStatus.CREATED) ;
    }

    public ResponseEntity<?> getAllPatients(){
        List<Patient> allPatients = patientRepository.findAll();
        if (allPatients.isEmpty()){
            return new ResponseEntity(new ApiResponse(HttpStatus.NO_CONTENT.value(), "No data available"), HttpStatus.NO_CONTENT) ;
        }
        return new ResponseEntity(new ApiResponse(HttpStatus.OK.value(), "Patients data",allPatients), HttpStatus.OK) ;
    }

    public ResponseEntity<?> getPatientData(String id){
        Optional<Patient> existedpatient = patientRepository.findById(id);
        if (existedpatient.isEmpty()){
            return new ResponseEntity(new ApiResponse(HttpStatus.NOT_FOUND.value(), "patient not found"), HttpStatus.NOT_FOUND) ;
        }
        return new ResponseEntity(new ApiResponse(HttpStatus.OK.value(), "Patient fetched successfully",existedpatient), HttpStatus.OK);

    }

}
