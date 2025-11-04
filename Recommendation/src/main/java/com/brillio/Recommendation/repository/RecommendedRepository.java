package com.brillio.Recommendation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.brillio.Recommendation.model.Recommended;

@Repository
public interface RecommendedRepository extends JpaRepository<Recommended, Integer> {

}