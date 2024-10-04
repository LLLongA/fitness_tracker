package com.FitnessTracker.demo.services.workout;


import com.FitnessTracker.demo.dto.WorkoutDto;

public interface WorkoutService {

    WorkoutDto postWorkout(WorkoutDto workoutDto);
}
