package com.janitri.backend.controller;

import com.janitri.backend.model.HeartRate;
import com.janitri.backend.service.HeartRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/heartrate/")
public class HeartRateController {
    @Autowired
    HeartRateService heartRateService;


    @PostMapping("add/{patientId}")
    public ResponseEntity<?> addHeartRate(@PathVariable String patientId, @RequestBody HeartRate heartRate){
        return heartRateService.addHeartRate(patientId,heartRate);
    }

    @GetMapping("all")
    public ResponseEntity<?> getAllHeartrateData(){
        return heartRateService.getAllData();
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getDataById(@PathVariable String id){
        return heartRateService.getDataById(id);
    }

}
