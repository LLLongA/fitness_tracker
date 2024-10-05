package com.FitnessTracker.demo.services.workout;


import com.FitnessTracker.demo.dto.WorkoutDto;

import java.util.List;

public interface WorkoutService {

    WorkoutDto postWorkout(WorkoutDto workoutDto);
    List<WorkoutDto> getWorkouts();
}
