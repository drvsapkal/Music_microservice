package com.brillio.Favourites.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brillio.Favourites.model.Favourite;

@Repository
public interface FavouriteRepository extends JpaRepository<Favourite, Integer> {

}
