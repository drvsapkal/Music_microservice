package com.brillio.Recommendation.service;

import java.util.List;

import com.brillio.Recommendation.model.Recommended;

public interface RecommendedService {

	public Recommended saveRecommended(Recommended recommended, String userEmail);

	public List<Recommended> getOtherRecommended(String userEmail);

	public List<Recommended> getUserRecommended(String userEmail);

	public void deleteuserRecommended(String userEmail, String mbid);

}
