package com.nnm.firstjob.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/jobs")
public class jobcontroller {
    private jobservice jobservice;


    public jobcontroller(com.nnm.firstjob.job.jobservice jobservice) {
        this.jobservice = jobservice;
    }

    @GetMapping
    public ResponseEntity<List<job>>findAll(){
        return ResponseEntity.ok(jobservice.findall());
    }

    @PostMapping
    public ResponseEntity<String> CreateJS(@RequestBody job job){
        jobservice.createjob(job);
        return new ResponseEntity<>("job added successfully",HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<job> getjobbyid(@PathVariable Long id){
        job job =jobservice.getjobbyid(id);
        if (job!=null)
            return new ResponseEntity<>(job,HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String>Deletejob(@PathVariable Long id){
        boolean deteted=jobservice.deletejobbyid(id);
        if (deteted)
            return  ResponseEntity.ok("Job Is Deleted with id "+id);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String>updatedjob(@PathVariable Long id, @RequestBody job updatejob){
        boolean updated=jobservice.updatejob(id,updatejob);
        if (updated)
            return new ResponseEntity<>("Job Updated Sucessfully",HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
