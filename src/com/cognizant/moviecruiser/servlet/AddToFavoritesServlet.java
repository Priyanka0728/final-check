package com.cognizant.moviecruiser.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecruiser.dao.FavoritesDao;
import com.cognizant.moviecruiser.dao.FavoritesDaoCollectionImpl;
import com.cognizant.moviecruiser.dao.MovieItemDao;
import com.cognizant.moviecruiser.dao.MovieItemDaoCollectionImpl;
import com.cognizant.moviecruiser.model.MovieItem;

/**
 * Servlet implementation class AddToFavoritesServlet
 */
@WebServlet({ "/AddToFavoritesServlet", "/AddToFavorites" })
public class AddToFavoritesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public AddToFavoritesServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			long userId = 1L;
			long movieItemId = Long.parseLong(request.getParameter("movieItemId"));
			FavoritesDao favoritesDao = new FavoritesDaoCollectionImpl();
			favoritesDao.addFavoritesItem(1, movieItemId);
			MovieItemDao movieItemDao = new MovieItemDaoCollectionImpl();
			List<MovieItem> movieItemListCustomer = movieItemDao.getMovieItemListCustomer();
			request.setAttribute("movieItemList", movieItemListCustomer);
			request.setAttribute("addFavoritesStatus", "Movie Added Successfully");
			RequestDispatcher rd = request.getRequestDispatcher("movie-list-customer.jsp");
			rd.forward(request, response);
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
