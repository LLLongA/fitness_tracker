package com.FitnessTracker.demo.services.goal;
import com.FitnessTracker.demo.dto.GoalDto;
import com.FitnessTracker.demo.entity.Goal;
import com.FitnessTracker.demo.repository.GoalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GoalServiceImpl implements GoalService {

    private final GoalRepository goalRepository;

    public GoalDto postGoal(GoalDto dto){
        Goal goal = new Goal();
        goal.setDescription(dto.getDescription());
        goal.setStartDate(dto.getStartDate());
        goal.setEndDate(dto.getEndDate());
        goal.setAchieved(false);

        return goalRepository.save(goal).getGoalDto();
    }

    public List<GoalDto> getGoals(){
        List<Goal> goals = goalRepository.findAll();
        return goals.stream().map(Goal::getGoalDto).collect(Collectors.toList());
    }
}
