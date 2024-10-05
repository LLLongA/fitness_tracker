package com.FitnessTracker.demo.repository;

import com.FitnessTracker.demo.entity.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalRepository extends JpaRepository<Goal,Long> {

    @Query("SELECT COUNT(g) FROM Goal g where g.achieved=true")
    Long countAchieveGoals();


    @Query("SELECT COUNT(g) FROM Goal g where g.achieved=false")
    Long countNotAchieveGoals();


}
