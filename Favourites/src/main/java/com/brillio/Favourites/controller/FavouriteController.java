package com.brillio.Favourites.controller;

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

import com.brillio.Favourites.model.Favourite;
import com.brillio.Favourites.service.FavouriteService;

@RestController
@RequestMapping("/music")
public class FavouriteController {

	@Autowired
	public FavouriteService favouriteService;

	@GetMapping(value = "/userfavs/{userEmail}")
	public ResponseEntity<List<Favourite>> getUserFavorite(@PathVariable("userEmail") String userEmail) {
		return new ResponseEntity<List<Favourite>>(favouriteService.getAllUserFavs(userEmail), HttpStatus.OK);
	}

	@PostMapping(value = "/favsave/{userEmail}")
	public ResponseEntity<Favourite> saveFavorite(@RequestBody Favourite favourite, @PathVariable("userEmail") String userEmail) {
		System.out.println(favourite);
//		ResponseEntity<Favourite> rs = null;
//		try {
//			Favourite fav = favouriteService.saveFavoriteService(favourite);
//
//			if (fav != null)
//				rs = ResponseEntity.status(HttpStatus.CREATED).build();
//			else
//				rs = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//		} catch (Exception e) {
//			rs = ResponseEntity.status(HttpStatus.CONFLICT).build();
//		}
//		return rs;

		return new ResponseEntity<Favourite>(favouriteService.saveFavoriteService(favourite, userEmail), HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/favdelete/{userEmail}/{mbid}")
	public ResponseEntity<String> deleteUserFavorite(@PathVariable("userEmail") String userEmail,
			@PathVariable("mbid") String mbid) {
		favouriteService.deleteUserFavourites(userEmail, mbid);
		return new ResponseEntity<String>("OK", HttpStatus.OK);
	}
}