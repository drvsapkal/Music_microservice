package com.brillio.Favourites.service;

import java.util.List;

import com.brillio.Favourites.model.Favourite;

public interface FavouriteService {

	List<Favourite> getAllUserFavs(String userEmail);

	void deleteUserFavourites(String userEmail, String mbid);

	Favourite saveFavoriteService(Favourite favourite, String userEmail);

}
