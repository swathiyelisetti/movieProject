package com.movies.movieProject.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "movie_id")
	private int movieId;
	@Column(name = "movie_name", nullable = false)
	private String movieName;
	@Column(name = "year", nullable = false)
	private int year;
    
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "director_id")
	private Director director;

	@OneToMany(fetch=FetchType.EAGER,mappedBy = "movie")
	private List<Rating> ratings = new ArrayList<>();

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public Movie(int movieId, String movieName, int year, Director director, List<Rating> ratings) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.year = year;
		this.director = director;
		this.ratings = ratings;
	}

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", year=" + year + ", director=" + director
				+ ", ratings=" + ratings + "]";
	}
	
	
}
