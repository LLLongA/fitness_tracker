package com.FitnessTracker.demo.dto;

import lombok.Data;

import java.util.List;

@Data
public class GraphDTO {

    private List<WorkoutDto> workouts;

    private  List<ActivityDTO> activities;



}
