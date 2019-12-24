package com.cognizant.moviecruiser.dao;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;

import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.MovieItem;

public class FavoritesDaoCollectionImpl implements FavoritesDao {

	private static HashMap<Long, Favorites> userFavorites;

	public FavoritesDaoCollectionImpl() {
		if (userFavorites == null) {
			userFavorites = new HashMap<>();
			userFavorites.put(1l, new Favorites());
		}
	}

	@Override
	public void addFavoritesItem(long userId, long movieItemId) {

		try {
			MovieItemDao movieItemDao = new MovieItemDaoCollectionImpl();
			MovieItem movieItem = movieItemDao.getMovieItem(movieItemId);

			if (userFavorites.containsKey(userId)) {
				Favorites favorites = userFavorites.get(userId);
				favorites.getMovieItemList().add(movieItem);

			} else {
				Favorites favorites = new Favorites();
				favorites.getMovieItemList().add(movieItem);
				userFavorites.put(userId, favorites);
			}
		} catch (ParseException e) {

			e.printStackTrace();
		}

	}

	@Override
	public List<MovieItem> getAllFavoritesItems(long userId) throws FavoritesEmptyException {

		List<MovieItem> movieItemList = userFavorites.get(userId).getMovieItemList();
		Favorites favorites = userFavorites.get(userId);
		int tot = 0;
		if (favorites == null ||favorites.getMovieItemList()==null|| movieItemList.isEmpty()) {
			throw new FavoritesEmptyException();
		} else {
			for (MovieItem movieItem : movieItemList) {
				tot += movieItem.getGross();

			}

		}
		favorites.setTotal(tot);
		return movieItemList;

	}

	@Override
	public void removeFavoritesItem(long userId, long movieItemId) {
		List<MovieItem> movieItemList = userFavorites.get(userId).getMovieItemList();
		int item = 0;
		for (; item < movieItemList.size(); item++) {
			if (movieItemList.get(item).getId() == movieItemId) {
				movieItemList.remove(item);
				break;
			}
		}
	}
}
