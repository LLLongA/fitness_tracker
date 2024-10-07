package com.FitnessTracker.demo.services.stats;

import com.FitnessTracker.demo.dto.GraphDTO;
import com.FitnessTracker.demo.dto.StatsDTO;

public interface StatsService {
    StatsDTO getStats();

    GraphDTO getGraphStats();

}
