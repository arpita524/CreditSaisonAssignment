package com.threesum.assignment.controller;

import com.threesum.assignment.exception.UserServiceException;
import com.threesum.assignment.model.ThreeSum;
import com.threesum.assignment.service.ThreeSumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class tcontroller {
    @Autowired
    ThreeSumService service;

    @PostMapping("/api/insert")
    public Response createCalculation(@RequestBody ThreeSum tsum){
        String result=service.createEntry(tsum);
        if(result.contains("Error Code")) {
            throw new UserServiceException("Invalid input list in the request body.");
        }
        return new Response("Record is successfully created in the database");
    }

    @GetMapping("/api/fetchAllRecords")
    public ResponseEntity<List<ThreeSum>> getAllCalculations(){
        return ResponseEntity.ok().body(service.getAllRecords());
    }

    @GetMapping("/api/fetchAllRecords/code/{code}")
    public ResponseEntity<ThreeSum> getAllCalculationsError(@PathVariable String code){
        Optional<ThreeSum> td = service.getAllCalculationsForErrorCode(code);
        ThreeSum ts = td.get();
        if(!td.isPresent()) {
            throw new UserServiceException("Record doesn't exist");
        }
        return new ResponseEntity<>(ts, HttpStatus.OK);
    }

    @GetMapping("/api/fetchAllRecords/id/{id}")
    public ResponseEntity<ThreeSum> getAllCalculationsID(@PathVariable long id){
        Optional<ThreeSum> td = service.getAllRecordsForID(id);
        ThreeSum ts = td.get();
        if(!td.isPresent()) {
            throw new UserServiceException("Record doesn't exist");
        }
        return new ResponseEntity<ThreeSum>(ts, HttpStatus.OK);
    }
}
