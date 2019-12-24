package com.cognizant.moviecruiser.dao;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;

import com.cognizant.moviecruiser.model.MovieItem;
import com.cognizant.moviecruiser.utl.DateUtil;

public class MovieItemDaoCollectionImplTest {
	public static void main(String[] args) {
		try {
			System.out.println("\n*****Admin Movie List******");
			testGetMovieItemListAdmin();
			System.out.println("\n*****Customer Movie List******");
			testGetMovieItemListCustomer();
			System.out.println("\n*****Modify Movie List******");
			testModifyMovieItem();
			testGetMovieItemListAdmin();
		} catch (ParseException e) {
			System.out.println(e);
		}
	}

	public static void testGetMovieItemListAdmin() throws ParseException {
		MovieItemDao movieItemDao = new MovieItemDaoCollectionImpl();
		List<MovieItem> movieItemList = movieItemDao.getMovieItemListAdmine();
		for (MovieItem x : movieItemList) {
			System.out.println(x);
		}	
	}

	public static void testGetMovieItemListCustomer() throws ParseException {
		MovieItemDao movieItemDao = new MovieItemDaoCollectionImpl();
		List<MovieItem> customerList = movieItemDao.getMovieItemListCustomer();
		NumberFormat box = NumberFormat.getInstance();
		box.setGroupingUsed(true);
		for (MovieItem x : customerList) {
			System.out.printf("%-20s $%-7s %-20s %-5s Add to Favorite \n", x.getTitle(),box.format(x.getGross()),
				x.getGence(),x.isHasTeaser() ? "yes" : "no");
		}
	}

	private static void testModifyMovieItem() throws ParseException {

		MovieItemDao movieItemDao = new MovieItemDaoCollectionImpl();
		MovieItem movie = new MovieItem(1, "Vismaya", 2956868792L, false, DateUtil.convertToDate("17/08/2019"),
				"Superhero", false);
		movieItemDao.modifyMovieItem(movie);

	}
}