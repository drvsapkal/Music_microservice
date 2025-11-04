package com.brillio.Recommendation.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brillio.Recommendation.model.Recommended;
import com.brillio.Recommendation.repository.RecommendedRepository;

@Service
public class RecommendedServiceImpl implements RecommendedService {

	@Autowired
	public RecommendedRepository repo;

	@Override
	public Recommended saveRecommended(Recommended recommended, String userEmail) {
		Recommended recommend = new Recommended();
		recommend.setName(recommended.getName());
		recommend.setMbid(recommended.getMbid());
		recommend.setUrl(recommended.getUrl());
		recommend.setListeners(recommended.getListeners());
		recommend.setPlaycount(recommended.getPlaycount());
		recommend.setUserEmail(userEmail);
		return repo.save(recommend);
	}

	@Override
	public List<Recommended> getOtherRecommended(String userEmail) {
		List<Recommended> allRecommended = repo.findAll();
		List<Recommended> otherRecommended = allRecommended.stream()
				.filter(f -> !(f.getUserEmail().equalsIgnoreCase(userEmail))).collect(Collectors.toList());
		return otherRecommended;
	}

	@Override
	public List<Recommended> getUserRecommended(String userEmail) {
		List<Recommended> allRecommended = repo.findAll();
		List<Recommended> userRecommended = allRecommended.stream()
				.filter(f -> f.getUserEmail().equalsIgnoreCase(userEmail)).collect(Collectors.toList());
		return userRecommended;
	}

	@Override
	public void deleteuserRecommended(String userEmail, String mbid) {
		List<Recommended> allRecommended = repo.findAll();
		List<Recommended> deleteRecommended = allRecommended.stream()
				.filter(f -> f.getUserEmail().equalsIgnoreCase(userEmail) && f.getMbid().equals(mbid))
				.collect(Collectors.toList());
		repo.deleteAll(deleteRecommended);
	}

}
