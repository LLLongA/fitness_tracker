package com.FitnessTracker.demo.repository;

import com.FitnessTracker.demo.entity.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout,Long> {
    @Query("SELECT SUM(w.duration) FROM Workout w")
    Integer getTotalDuration();

    @Query("SELECT SUM(w.caloriesBurned) FROM Workout w")
    Integer getTotalCaloriesBurned();
}
