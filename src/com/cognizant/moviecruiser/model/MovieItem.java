package com.cognizant.moviecruiser.model;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;



public class MovieItem {
	private Long id;
	private String title;
	private Long gross;
	private boolean active;
	private Date dateOfLaunch;
	private String gence;
	private boolean hasTeaser;

	public MovieItem(long id, String title, long gross, boolean active, Date dateOfLaunch, String gence,
			boolean hasTeaser) {
		super();
		this.id = id;
		this.title = title;
		this.gross = gross;
		this.active = active;
		this.dateOfLaunch = dateOfLaunch;
		this.gence = gence;
		this.hasTeaser = hasTeaser;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getGross() {
		return gross;
	}

	public void setGross(Long gross) {
		this.gross = gross;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getDateOfLaunch() {
		return dateOfLaunch;
	}

	public void setDateOfLaunch(Date dateOfLaunch) {
		this.dateOfLaunch = dateOfLaunch;
	}

	public String getGence() {
		return gence;
	}

	public void setGence(String gence) {
		this.gence = gence;
	}

	public boolean isHasTeaser() {
		return hasTeaser;
	}

	public void setHasTeaser(boolean hasTeaser) {
		this.hasTeaser = hasTeaser;
	}
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovieItem other = (MovieItem) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public String toString() {
		SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
		NumberFormat box = NumberFormat.getInstance();
		box.setGroupingUsed(true);

		return String.format("%-20s Rs.%7s %-5s %-10s %-15s %-5s Edit", title, box.format(gross), active ? "Yes" : "No",
				sd.format(dateOfLaunch), gence, hasTeaser ? "Yes" : "No");

	}
}
