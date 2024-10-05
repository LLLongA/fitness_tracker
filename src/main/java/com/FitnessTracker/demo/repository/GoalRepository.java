package com.FitnessTracker.demo.repository;

import com.FitnessTracker.demo.entity.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalRepository extends JpaRepository<Goal,Long> {

}
