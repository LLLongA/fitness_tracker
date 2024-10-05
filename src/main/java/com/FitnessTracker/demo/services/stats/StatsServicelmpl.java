package com.FitnessTracker.demo.services.stats;

import com.FitnessTracker.demo.dto.StatsDTO;
import com.FitnessTracker.demo.repository.ActivityRepository;
import com.FitnessTracker.demo.repository.GoalRepository;
import com.FitnessTracker.demo.repository.WorkoutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
