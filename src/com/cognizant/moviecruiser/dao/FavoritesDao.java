package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.model.MovieItem;

public interface FavoritesDao {
	public void addFavoritesItem(long userId, long movieItemId);

	public List<MovieItem> getAllFavoritesItems(long userId) throws FavoritesEmptyException;

	public void removeFavoritesItem(long userId, long movieItemId);
}
