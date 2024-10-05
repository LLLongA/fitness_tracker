package com.FitnessTracker.demo.services.goal;

import com.FitnessTracker.demo.dto.GoalDto;

import java.util.List;

public interface GoalService {

    GoalDto postGoal(GoalDto dto);
    List<GoalDto> getGoals();

    GoalDto updateStatus(Long id);
}
