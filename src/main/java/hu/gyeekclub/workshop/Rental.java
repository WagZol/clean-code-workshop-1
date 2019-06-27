package hu.gyeekclub.workshop;

import hu.gyeekclub.workshop.movies.Movie;

public class Rental {

	private Movie movie;
	private int daysRented;
        

	public Rental(Movie movie, int daysRented) {
		this.movie = movie;
                checkNegativeDays(daysRented);
		this.daysRented = daysRented;
	}

	public int getDaysRented() {
		return daysRented;
	}

	public Movie getMovie() {
		return movie;
	}
        
        public double getPriceByMovieTypeAndDay(){
            return movie.getPriceByRentalDays(daysRented);   
        }
        
        public int getLoyaltyPointsByMovieTypeAndDay(){
            return (movie.getLoyaltyPoints() && daysRented>1?2:1);
        }
        
        private void checkNegativeDays(int daysRented){
            if (daysRented<=0){
                throw new IllegalArgumentException();
            }
        }
}
