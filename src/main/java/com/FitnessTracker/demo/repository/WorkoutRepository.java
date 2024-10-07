package com.FitnessTracker.demo.repository;

import com.FitnessTracker.demo.entity.Workout;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout,Long> {
    @Query("SELECT SUM(w.duration) FROM Workout w")
    Integer getTotalDuration();

    @Query("SELECT SUM(w.caloriesBurned) FROM Workout w")
    Integer getTotalCaloriesBurned();


    @Query("SELECT w FROM Workout w ORDER BY w.date DESC")

    List<Workout> findLast7Workout(Pageable pageable);
}
