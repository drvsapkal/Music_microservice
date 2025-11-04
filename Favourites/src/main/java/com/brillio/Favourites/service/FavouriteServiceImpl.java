package com.brillio.Favourites.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.brillio.Favourites.model.Favourite;
import com.brillio.Favourites.repository.FavouriteRepository;

@Service
public class FavouriteServiceImpl implements FavouriteService {

	@Autowired
	public FavouriteRepository repo;

	public List<Favourite> getAllUserFavs(String userEmail) {
		List<Favourite> allFavourites = repo.findAll();
		List<Favourite> userFavourites = allFavourites.stream()
				.filter(f -> f.getUserEmail().equalsIgnoreCase(userEmail)).collect(Collectors.toList());
		return userFavourites;
	}

	@Override
	public void deleteUserFavourites(String userEmail, String mbid) {
		List<Favourite> allFavourites = repo.findAll();
		List<Favourite> deleteFavourites = allFavourites.stream()
				.filter(f -> f.getUserEmail().equalsIgnoreCase(userEmail) && f.getMbid().equals(mbid))
				.collect(Collectors.toList());
		repo.deleteAll(deleteFavourites);
	}

	@Override
	public Favourite saveFavoriteService(Favourite favourite, String userEmail) {
		Favourite fav = new Favourite();
		fav.setName(favourite.getName());
		fav.setMbid(favourite.getMbid());
		fav.setUrl(favourite.getUrl());
		fav.setListeners(favourite.getListeners());
		fav.setPlaycount(favourite.getPlaycount());
		fav.setUserEmail(userEmail);
		return repo.save(fav);
	}
	
}
