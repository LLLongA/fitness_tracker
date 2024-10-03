package com.FitnessTracker.demo.controller;

import com.FitnessTracker.demo.dto.ActivityDTO;
import com.FitnessTracker.demo.services.activity.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ActivityController {
    private final ActivityService activityService;

    @PostMapping("/activity")
    public ResponseEntity<?>postActivity(@RequestBody ActivityDTO dto){
        ActivityDTO createActivity = activityService.postActivity(dto);
        if(createActivity !=null){
            return ResponseEntity.status(HttpStatus.CREATED).body(createActivity);
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");

        }    }

    @GetMapping("/activities")
    public ResponseEntity<?> getActivity(){
        try{
            return ResponseEntity.ok(activityService.getActivity());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
    }
}
