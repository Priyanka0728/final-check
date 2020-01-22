package com.cognizant.moviecruiser.dao;


import java.text.ParseException;
import java.util.List;

import com.cognizant.moviecruiser.model.MovieItem;
import com.cognizant.moviecruiser.utl.DateUtil;




public class MovieItemDaoSqlImplTest {

	public static void main(String[] args) {
		try {
			System.out.println("*********Admin List*******");
			testGetMovieItemListAdmin();
			System.out.println("*********Customer List*******");
			testGetMovieItemListCustomer();
			testModifyMovieItem();
			System.out.println("*********Modified List*******");
			testGetMovieItemListAdmin();
		} catch (ParseException e) {
			System.out.println(e);
		}
	}

	public static void testGetMovieItemListAdmin() throws ParseException {
		MovieItemDao movieItemDao = new MovieItemDaoSqlImpl();
		List<MovieItem> movieItemList = movieItemDao.getMovieItemListAdmine();
		for (MovieItem x : movieItemList) {
			System.out.println(x);
		}
	}

	public static void testGetMovieItemListCustomer() throws ParseException {
		MovieItemDao movieItemDao = new MovieItemDaoSqlImpl();
		List<MovieItem> customerList = movieItemDao.getMovieItemListCustomer();
		for (MovieItem x : customerList) {
			System.out.println(x);
		}
	}

	private static void testModifyMovieItem() throws ParseException {

		MovieItem movie= new MovieItem(1, "Starwar",1044503899,true, DateUtil.convertToDate("20/12/2022"), "Super Fictions",true);
       MovieItemDao movieItemDao = new MovieItemDaoSqlImpl();
       movieItemDao.modifyMovieItem(movie);
}

		
	}


