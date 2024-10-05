package com.FitnessTracker.demo.services.workout;

import com.FitnessTracker.demo.dto.WorkoutDto;
import com.FitnessTracker.demo.entity.Workout;
import com.FitnessTracker.demo.repository.WorkoutRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.jdbc.Work;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WorkoutServicelmpl implements WorkoutService{
    private final WorkoutRepository workoutRepository;

    public WorkoutDto postWorkout(WorkoutDto workoutDto){
        Workout workout = new Workout();

        workout.setDate(workoutDto.getDate());
        workout.setType(workoutDto.getType());
        workout.setDuration(workoutDto.getDuration());
        workout.setCaloriesBurned(workoutDto.getCaloriesBurned());
        return workoutRepository.save(workout).getWorkoutDto();
    }
    public List<WorkoutDto> getWorkouts(){
        List<Workout> workouts = workoutRepository.findAll();
        return workouts.stream().map(Workout::getWorkoutDto).collect(Collectors.toList());
    }
}
