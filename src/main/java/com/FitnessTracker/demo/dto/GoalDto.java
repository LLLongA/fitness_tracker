package com.FitnessTracker.demo.dto;

import lombok.Data;

import java.util.Date;

@Data
public class GoalDto {
    private Long id;

    private String description;

    private Date startDate;

    private Date endDate;

    private boolean achieved;
}
