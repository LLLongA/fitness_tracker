package com.FitnessTracker.demo.services.stats;

import com.FitnessTracker.demo.dto.StatsDTO;
import com.FitnessTracker.demo.repository.ActivityRepository;
import com.FitnessTracker.demo.repository.GoalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class StatsServicelmpl implements StatsService {
    private final GoalRepository goalRepository;
    private final ActivityRepository activityRepository;

    public StatsDTO getStats(){
        Long achievedGoals = goalRepository.countAchieveGoals();
        Long notAchieveGoals = goalRepository.countNotAchieveGoals();

        Integer totalsteps = activityRepository.getTotalSteps();
        Double totalDistance = activityRepository.getTotalDistance();
        Integer totalActivityCaloriesBurned =activityRepository.getTotalActivityCaloriesBurned();

        StatsDTO dto = new StatsDTO();
        dto.setAchievedGoals(achievedGoals !=null ? achievedGoals:0);
        dto.setNotAchievedGoals(notAchieveGoals !=null ? notAchieveGoals:0);
        dto.setSteps(totalsteps !=null ? totalsteps:0);
        dto.setDistance(totalDistance !=null ? totalDistance:0);
        dto.setTotalCaloriesBurned(totalActivityCaloriesBurned !=null ? totalActivityCaloriesBurned:0);


        return dto;
    }
}
