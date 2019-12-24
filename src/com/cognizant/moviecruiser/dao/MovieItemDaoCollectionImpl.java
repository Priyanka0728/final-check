package com.cognizant.moviecruiser.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.moviecruiser.model.MovieItem;
import com.cognizant.moviecruiser.utl.DateUtil;

public class MovieItemDaoCollectionImpl implements MovieItemDao {
	private static List<MovieItem> movieItemList;

	public MovieItemDaoCollectionImpl() throws ParseException {
		super();
		if (movieItemList == null) {
			movieItemList = new ArrayList<>();
			movieItemList.add(new MovieItem(1, "Avatar", 2787965087L, true, DateUtil.convertToDate("15/03/2017"),
					"Science Fiction", true));
			movieItemList.add(new MovieItem(2, "The Avengers", 1518812988L, true, DateUtil.convertToDate("23/12/2017"),
					"Superhero", false));
			movieItemList.add(new MovieItem(3, "Titanic", 2187463944L, true, DateUtil.convertToDate("21/12/2017"),
					"Romance", false));
			movieItemList.add(new MovieItem(4, "Jurassic World", 1671713208L, false,
					DateUtil.convertToDate("02/07/2017"), "Science Fiction", true));
			movieItemList.add(new MovieItem(5, "Avengers End Game ", 2750760348L, false,
					DateUtil.convertToDate("02/11/2022"), "Superhero", true));

		}

	}

	@Override
	public List<MovieItem> getMovieItemListAdmine() {

		return movieItemList;
	}

	@Override
	public List<MovieItem> getMovieItemListCustomer() {
		List<MovieItem> customerList = new ArrayList<>();
		Date today = new Date();
		for (MovieItem x : movieItemList) {
			if (x.isActive() && x.getDateOfLaunch().before(today)) {
				customerList.add(x);
			}
		}

		return customerList;
	}

	@Override

	public void modifyMovieItem(MovieItem movieItem) {
		MovieItem x = getMovieItem(movieItem.getId());
		x.setTitle(movieItem.getTitle());
		x.setGross(movieItem.getGross());
		x.setActive(movieItem.isActive());
		x.setDateOfLaunch(movieItem.getDateOfLaunch());
		x.setGence(movieItem.getGence());
		x.setHasTeaser(movieItem.isHasTeaser());

	}

	@Override
	public MovieItem getMovieItem(long movieItemId) {
		MovieItem movieItem = null;
		for (MovieItem x : movieItemList) {
			if (x.getId() == movieItemId) {
				movieItem = x;
				break;
			}

		}
		return movieItem;
	}

}
