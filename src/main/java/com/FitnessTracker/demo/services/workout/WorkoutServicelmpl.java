package com.FitnessTracker.demo.services.workout;

import com.FitnessTracker.demo.dto.WorkoutDto;
import com.FitnessTracker.demo.entity.Workout;
import com.FitnessTracker.demo.repository.WorkoutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorkoutServicelmpl implements WorkoutService{
    private final WorkoutRepository workoutRepository;

    public WorkoutDto postWorkout(WorkoutDto workoutDto){
        Workout workout = new Workout();

        workout.setDate(workoutDto.getDate());
        workout.setType(workoutDto.getType());
        workoutDto.setDuration(workoutDto.getDuration());
        workout.setCaloriesBurned(workoutDto.getCaloriesBurned());
        return workoutRepository.save(workout).getWorkoutDto();
    }
}
