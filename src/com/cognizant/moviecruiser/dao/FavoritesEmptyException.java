package com.cognizant.moviecruiser.dao;

public class FavoritesEmptyException extends Exception {

	public FavoritesEmptyException() {
		super("Favorites is empty");
		// TODO Auto-generated constructor stub
	}

	public FavoritesEmptyException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
}