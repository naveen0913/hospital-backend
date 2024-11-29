package com.janitri.backend.service;

import com.janitri.backend.model.HeartRate;
import com.janitri.backend.model.Patient;
import com.janitri.backend.repository.HeartRateRepository;
import com.janitri.backend.repository.PatientRepository;
import com.janitri.backend.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class HeartRateService {

    @Autowired
    HeartRateRepository heartRateRepository;

    @Autowired
    PatientRepository patientRepository;

    public ResponseEntity<?> addHeartRate(String patientId, HeartRate heartRate){
        Patient existedpatient = patientRepository.findById(patientId).orElseThrow();
        if (existedpatient==null){
            return new ResponseEntity(new ApiResponse(HttpStatus.NOT_FOUND.value(), "patient not found"), HttpStatus.NOT_FOUND) ;
        }
        heartRate.setTimestamp(LocalDateTime.now());
        heartRate.setPatient(existedpatient);
        heartRateRepository.save(heartRate);
        return new ResponseEntity(new ApiResponse(HttpStatus.CREATED.value(), "Heart rate added successfully"), HttpStatus.CREATED) ;
    }

    public ResponseEntity<?> getAllData(){
        List<HeartRate> heartRatesData = heartRateRepository.findAll();
        if (heartRatesData.isEmpty()){
            return new ResponseEntity(new ApiResponse(HttpStatus.NO_CONTENT.value(), "No data available"), HttpStatus.NO_CONTENT) ;
        }
        return new ResponseEntity(new ApiResponse(HttpStatus.OK.value(), "Patients data",heartRatesData), HttpStatus.OK) ;

    }

    public ResponseEntity<?> getDataById(String id){
        Optional<HeartRate> heartRate = heartRateRepository.findById(id);
        if (heartRate.isEmpty()){
            return new ResponseEntity(new ApiResponse(HttpStatus.NOT_FOUND.value(), "Heart rate data not found"), HttpStatus.NOT_FOUND) ;
        }
        return new ResponseEntity(new ApiResponse(HttpStatus.OK.value(), "Heart rate fetched successfully",heartRate), HttpStatus.OK);
    }

}
