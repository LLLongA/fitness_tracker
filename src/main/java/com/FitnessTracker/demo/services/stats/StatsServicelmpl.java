package com.FitnessTracker.demo.services.stats;

import com.FitnessTracker.demo.dto.GraphDTO;
import com.FitnessTracker.demo.dto.StatsDTO;
import com.FitnessTracker.demo.entity.Activity;
import com.FitnessTracker.demo.entity.Workout;
import com.FitnessTracker.demo.repository.ActivityRepository;
import com.FitnessTracker.demo.repository.GoalRepository;
import com.FitnessTracker.demo.repository.WorkoutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class StatsServicelmpl implements StatsService {
    private final GoalRepository goalRepository;
    private final ActivityRepository activityRepository;
    private final WorkoutRepository workoutRepository;

    public StatsDTO getStats(){
        Long achievedGoals = goalRepository.countAchieveGoals();
        Long notAchieveGoals = goalRepository.countNotAchieveGoals();

        Integer totalsteps = activityRepository.getTotalSteps();
        Double totalDistance = activityRepository.getTotalDistance();
        Integer totalActivityCaloriesBurned =activityRepository.getTotalActivityCaloriesBurned();

        Integer totalWorkDuration = workoutRepository.getTotalDuration();
        Integer totalWorkoutCaloriesBurned = workoutRepository.getTotalCaloriesBurned();

        int totalCaloriesBurned = (totalActivityCaloriesBurned !=null ? totalActivityCaloriesBurned:0) +
                (totalWorkoutCaloriesBurned !=null ? totalWorkoutCaloriesBurned:0);

        StatsDTO dto = new StatsDTO();
        dto.setAchievedGoals(achievedGoals !=null ? achievedGoals:0);
        dto.setNotAchievedGoals(notAchieveGoals !=null ? notAchieveGoals:0);
        dto.setSteps(totalsteps !=null ? totalsteps:0);
        dto.setDistance(totalDistance !=null ? totalDistance:0);
        dto.setTotalCaloriesBurned(totalCaloriesBurned);
        dto.setDuration(totalWorkDuration !=null ? totalWorkDuration:0);


        return dto;
    }

    public GraphDTO getGraphStats(){
        Pageable pageable = PageRequest.of(0,7);
        List<Workout> workouts = workoutRepository.findLast7Workout(pageable);
        List<Activity> activities = activityRepository.findLast7Activies(pageable);

        GraphDTO graphDTO = new GraphDTO();
        graphDTO.setWorkouts(workouts.stream().map(Workout::getWorkoutDto).collect(Collectors.toList()));
        graphDTO.setActivities(activities.stream().map(Activity::getActivityDTO).collect(Collectors.toList()));
        return graphDTO;
    }
}
