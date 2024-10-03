package com.FitnessTracker.demo.services.activity;

import com.FitnessTracker.demo.dto.ActivityDTO;

import java.util.List;

public interface ActivityService {

    ActivityDTO postActivity(ActivityDTO dto);

    List<ActivityDTO> getActivity();

}
