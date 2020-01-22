package com.cognizant.moviecruiser.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.moviecruiser.model.MovieItem;

import java.sql.Connection;

import java.sql.PreparedStatement;



public class MovieItemDaoSqlImpl implements MovieItemDao {

	
	public List<MovieItem> getMovieItemListAdmine() {
		List<MovieItem> movieItemList = new ArrayList<>();

		Connection con = ConnectionHandler.getConnection();
		try {
			String sql = "select * from movie_item";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				MovieItem movie = new MovieItem();
				movie.setId(rs.getLong(1));
				movie.setTitle(rs.getString(2));
				movie.setGross(rs.getLong(3));
				movie.setActive(rs.getString(4).equalsIgnoreCase("Yes"));
				movie.setDateOfLaunch(rs.getDate(5));
				movie.setGence(rs.getString(6));
				movie.setHasTeaser(rs.getString(7).equalsIgnoreCase("Yes"));

				movieItemList.add(movie);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return movieItemList;

	}

	@Override
	public List<MovieItem> getMovieItemListCustomer() {
		List<MovieItem> customerList = new ArrayList<>();
		Connection con = ConnectionHandler.getConnection();
		try {
			String sql = "select * from movie_item WHERE mov_active=? AND mov_date_of_launch < ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "Yes");
			java.util.Date d = new java.util.Date();
			ps.setDate(2, new java.sql.Date(d.getTime()));
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				MovieItem movie = new MovieItem();
				movie.setId(rs.getLong(1));
				movie.setTitle(rs.getString(2));
				movie.setGross(rs.getLong(3));
				movie.setActive(rs.getString(4).equalsIgnoreCase("Yes"));
				movie.setDateOfLaunch(rs.getDate(5));
				movie.setGence(rs.getString(6));
				movie.setHasTeaser(rs.getString(7).equalsIgnoreCase("Yes"));

				customerList.add(movie);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return customerList;
	}

	@Override
	public void modifyMovieItem(MovieItem movieItem) {
		String sql = "UPDATE movie_item "
				+ "SET mov_title=? ,mov_gross=?,mov_active=?,mov_date_of_launch=?,mov_gence=?,mov_has_teaser=? "
				+ "WHERE mov_id=?";
		Connection con = ConnectionHandler.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, movieItem.getTitle());
			ps.setFloat(2, movieItem.getGross());
			ps.setString(3, movieItem.isActive() ? "Yes" : "No");
			ps.setDate(4, new java.sql.Date(movieItem.getDateOfLaunch().getTime()));
			ps.setString(5,movieItem.getGence());
			ps.setString(6, movieItem.isHasTeaser() ? "Yes" : "No");
			ps.setLong(7, movieItem.getId());
			int result = ps.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		
	}

	@Override
	public MovieItem getMovieItem(long movieItemId) {
		MovieItem movieitem = new MovieItem();
		Connection con = ConnectionHandler.getConnection();
		try {
			String sql = "SELECT *FROM movie_item WHERE mov_id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				MovieItem movie = new MovieItem();
				movie.setId(rs.getLong(1));
				movie.setTitle(rs.getString(2));
				movie.setGross(rs.getLong(3));
				movie.setActive(rs.getString(4).equalsIgnoreCase("Yes"));
				movie.setDateOfLaunch(rs.getDate(5));
				movie.setGence(rs.getString(6));
				movie.setHasTeaser(rs.getString(7).equalsIgnoreCase("Yes"));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return movieitem;
	}

}
