package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.model.MovieItem;

public class FavoritesDaoCollectionImplTest {

	public static void main(String[] args) throws FavoritesEmptyException {
		System.out.println("\n============= All Favorites Items=============");
		testGetAllfavoriteItems();
		System.out.println("\n==================Added Favorites List===========");
		testAddFavoriteItem();
		System.out.println("\n============== All Favorites Items=============");
		testGetAllfavoriteItems();
		System.out.println("\n===============After Removing=============");
		testRemoveFavoriteItem();
		System.out.println("\n================= All Favorites Items============");
		testGetAllfavoriteItems();

	}

	private static void testRemoveFavoriteItem() {
		FavoritesDao favoritesDao = new FavoritesDaoCollectionImpl();
		
		try {
			favoritesDao.removeFavoritesItem(1, 2L);
			favoritesDao.removeFavoritesItem(1, 5L);
			List<MovieItem> movieItemListCustomer = favoritesDao.getAllFavoritesItems(1);
			for (MovieItem movieItem : movieItemListCustomer) {
				System.out.println(movieItem);
			}
		} catch (FavoritesEmptyException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void testAddFavoriteItem() throws FavoritesEmptyException {
		FavoritesDao favoritesDao = new FavoritesDaoCollectionImpl();
		favoritesDao.addFavoritesItem(1, 2L);
		favoritesDao.addFavoritesItem(1, 5L);
		favoritesDao.addFavoritesItem(1, 3L);
		List<MovieItem> movieItemListCustomer = favoritesDao.getAllFavoritesItems(1);
		
		for (MovieItem movieItem : movieItemListCustomer) {
			System.out.println(movieItem);

		}

	}

	public static void testGetAllfavoriteItems() throws FavoritesEmptyException {
		FavoritesDao favoritesDao = new FavoritesDaoCollectionImpl();
		try {
			List<MovieItem> movieItemListCustomer = favoritesDao.getAllFavoritesItems(1l);
		
			for (MovieItem movieItem : movieItemListCustomer) {
				System.out.println(movieItem);

			}
		} catch (FavoritesEmptyException e) {
			System.out.println("Favorites is Empty");

		}
	}
}
