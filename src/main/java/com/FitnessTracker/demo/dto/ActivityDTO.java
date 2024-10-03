package com.FitnessTracker.demo.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ActivityDTO {
    private Long id;

    private Date date;

    private int steps;

    private double distance;

    private int caloriesBurned;
}
