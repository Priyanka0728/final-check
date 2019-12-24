package com.cognizant.moviecruiser.model;

import java.util.ArrayList;
import java.util.List;

public class Favorites {
	private List<MovieItem> movieItemList;
	private double total;

	public Favorites() {
		super();
		movieItemList = new ArrayList<>();
		total = 0;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double toatal) {
		this.total = toatal;
	}

	public List<MovieItem> getMovieItemList() {
		return movieItemList;
	}

	public void setMovieItemList(List<MovieItem> movieItemList) {
		this.movieItemList = movieItemList;
	}

}
