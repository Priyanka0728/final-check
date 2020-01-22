package com.cognizant.moviecruiser.dao;
                                                                                                                                                                                                                             
import java.util.List;

import com.cognizant.moviecruiser.model.MovieItem;


public class FavoritesDaoSqlImplTest {

	public static void main(String[] args) throws FavoritesEmptyException {
		

		testAddFavoritesItem();

		testRemoveFavoritesItem();

		testGetAllFavoritesItems();

	}

	static void testAddFavoritesItem() throws FavoritesEmptyException {

		FavoritesDaoSqlImpl favoritesDaoSqlImpl = new FavoritesDaoSqlImpl();

		FavoritesDao favoritesDao = favoritesDaoSqlImpl;

		favoritesDao.addFavoritesItem(1, 4);

		favoritesDao.addFavoritesItem(1, 3);

		List<MovieItem> movieItemList = favoritesDao.getAllFavoritesItems(1);

	}

	static void testGetAllFavoritesItems() throws FavoritesEmptyException {

		FavoritesDao favoritesDaoSqlImpl = new FavoritesDaoSqlImpl();

		FavoritesDao favoritesDao = favoritesDaoSqlImpl;

		List<MovieItem> movieItemList = favoritesDao.getAllFavoritesItems(1);
		for (MovieItem x : movieItemList) {
			System.out.println(x);
		}

	}

	static void testRemoveFavoritesItem() throws FavoritesEmptyException {

		FavoritesDao favoritesDaoSqlImpl = new FavoritesDaoSqlImpl();

		FavoritesDao favoritesDao = favoritesDaoSqlImpl;

		try {

			favoritesDao.removeFavoritesItem(1, 4);

			List<MovieItem> movieItemList = favoritesDao.getAllFavoritesItems(1);

		} catch (Exception e) {

			throw new FavoritesEmptyException("Favorites is empty");

		}

	}

}
