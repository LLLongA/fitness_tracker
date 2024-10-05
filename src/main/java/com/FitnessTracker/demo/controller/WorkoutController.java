package com.FitnessTracker.demo.controller;

import com.FitnessTracker.demo.dto.WorkoutDto;
import com.FitnessTracker.demo.services.workout.WorkoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*")
public class WorkoutController {
    private final WorkoutService workoutService;

    @PostMapping("/workout")
    public ResponseEntity<?> postWorkout(@RequestBody WorkoutDto workoutDto){
        try{
            return ResponseEntity.ok(workoutService.postWorkout(workoutDto));
        } catch (Exception e){
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went wrong");
        }

    }

    @GetMapping("/workouts")
    public ResponseEntity<?> getWorkout(){
        try{
            return ResponseEntity.ok(workoutService.getWorkouts());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went wrong");
        }
    }
}
