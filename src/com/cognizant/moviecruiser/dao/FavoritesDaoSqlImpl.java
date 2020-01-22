package com.cognizant.moviecruiser.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.MovieItem;


public class FavoritesDaoSqlImpl implements FavoritesDao {

	public List<MovieItem> getAllFavoritesItems(long userId) throws FavoritesEmptyException {

		Connection con = ConnectionHandler.getConnection();
		List<MovieItem> movieItemList = new ArrayList<MovieItem>();

		PreparedStatement ps;

		ResultSet resultSet;

		boolean activeFlag, hasTeaserFlag;

		MovieItem movieItem = null;

		try {

			Favorites favorites = new Favorites();

			StringBuffer sqlBuffer = new StringBuffer();

			sqlBuffer

					.append("SELECT mov_id,mov_title ,mov_active,mov_date_of_launch,mov_gence,mov_has_teaser FROM movie_item ")

					.append("INNER JOIN favorites ON movie_item.mov_id = favorites.ft_pr_id WHERE favorites.ft_us_id = ?");

			ps = con.prepareStatement(sqlBuffer

					.toString());

			ps.setLong(1, userId);

			resultSet = ps.executeQuery();

			while (resultSet.next()) {

				long movieItemId = resultSet.getLong(1);

				String title = resultSet.getString(2);

				long gross = resultSet.getLong(3);

				String active = resultSet.getString(4);

				Date date_of_launch = resultSet.getDate(5);

				String gence = resultSet.getString(6);

				String hasTeaser = resultSet.getString(7);

				if (active != null && active.equals("Yes"))

					activeFlag = true;

				else

					activeFlag = false;

				if (hasTeaser != null && hasTeaser.equals("Yes"))

					hasTeaserFlag = true;

				else

					hasTeaserFlag = false;

				movieItem = new MovieItem(movieItemId, title, gross,

						activeFlag, date_of_launch, gence,

						hasTeaserFlag);

				movieItemList.add(movieItem);

			}

			favorites.setMovieItemList(movieItemList);

		} catch (SQLException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		} finally {

			try {

				con.close();

			} catch (SQLException e) {

				// TODO Auto-generated catch block

				e.printStackTrace();

			}

		}

		if (movieItemList.size() == 0) {

			throw new FavoritesEmptyException("Favorites is Empty");

		}

		return movieItemList;

	}

	@Override
	public void removeFavoritesItem(long userId, long movieItemId) {

		Connection con = ConnectionHandler.getConnection();

		try {

			String sql = "delete from favorites where ft_us_id=? and  ft_pr_id=? limit 1";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setLong(1, userId);

			ps.setLong(2, movieItemId);

			ps.executeUpdate();

		} catch (SQLException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		} finally {

			try {

				con.close();

			} catch (SQLException e) {

				// TODO Auto-generated catch block

				e.printStackTrace();

			}

		}

	}

	@Override
	public void addFavoritesItem(long userId, long movieItemId) {
		Connection con = ConnectionHandler.getConnection();

		try {
			String sql = "insert into favorites values(default,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, userId);

			ps.setLong(2, movieItemId);
			ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			try {

				con.close();

			} catch (Exception e) {

				e.printStackTrace();

			}

		}

		
	}

}

