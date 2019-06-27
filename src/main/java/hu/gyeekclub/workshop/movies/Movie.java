package hu.gyeekclub.workshop.movies;

public abstract class Movie {



    private String title;


    public Movie(String title) {
        checkMovieTitle(title);
        this.title = title;
    }

    

    public String getTitle() {
        return title;
    }


    private void checkMovieTitle(String movieTitle) {
        if (movieTitle == null) {
            throw new IllegalArgumentException();
        }
    }
    
    public abstract double getPriceByRentalDays(int rentalDays);
    
    public abstract boolean getLoyaltyPoints();
}
