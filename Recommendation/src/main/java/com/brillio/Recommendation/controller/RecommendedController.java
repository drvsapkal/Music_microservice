package com.brillio.Recommendation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brillio.Recommendation.model.Recommended;
import com.brillio.Recommendation.service.RecommendedService;

@RestController
@RequestMapping("/music")
public class RecommendedController {

	@Autowired
	private RecommendedService recommendedService;

	@GetMapping(value = "/otherRecommended/{userEmail}")
	public ResponseEntity<List<Recommended>> getOtherRecommended(@PathVariable("userEmail") String userEmail) {
		return new ResponseEntity<List<Recommended>>(recommendedService.getOtherRecommended(userEmail), HttpStatus.OK);
	}

	@GetMapping(value = "/userRecommended/{userEmail}")
	public ResponseEntity<List<Recommended>> getUserRecommended(@PathVariable("userEmail") String userEmail) {
		return new ResponseEntity<List<Recommended>>(recommendedService.getUserRecommended(userEmail), HttpStatus.OK);
	}

	@PostMapping(value = "/saveRecommended/{userEmail}")
	public ResponseEntity<Recommended> saveRecommended(@RequestBody Recommended recommended,
			@PathVariable("userEmail") String userEmail) {
		return new ResponseEntity<Recommended>(recommendedService.saveRecommended(recommended, userEmail),
				HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/deleteUserRecommended/{userEmail}/{mbid}")
	public ResponseEntity<String> deleteUserRecommended(@PathVariable("userEmail") String userEmail,
			@PathVariable("mbid") String mbid) {
		recommendedService.deleteuserRecommended(userEmail, mbid);
		return new ResponseEntity<String>("OK", HttpStatus.OK);
	}

}
