package com.FitnessTracker.demo.entity;

import com.FitnessTracker.demo.dto.GoalDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private Date startDate;

    private Date endDate;

    private boolean achieved;

    public GoalDto getGoalDto(){
        GoalDto goalDto = new GoalDto();

        goalDto.setId(id);
        goalDto.setDescription(description);
        goalDto.setStartDate(startDate);
        goalDto.setEndDate(endDate);
        goalDto.setAchieved(achieved);

        return goalDto;

    }


}
