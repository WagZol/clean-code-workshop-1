package hu.gyeekclub.workshop;

import hu.gyeekclub.workshop.movies.Movie;
import hu.gyeekclub.workshop.movies.MovieFactory;
import hu.gyeekclub.workshop.movies.MovieTypes;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RentalTests {

    @Test
    public void testChildrenRentalAmountCalculation() {
        Movie movie = MovieFactory.createFilm(MovieTypes.CHILDRENS, "Winnie the Pooh");
        Rental rental = new Rental(movie, 3);
        Customer customer = new Customer("Judy Jusper");
        customer.addRental(rental);
        String result = customer.getOwnBill();

        double expectedAmount = 1.5;
        String expected = "Amount owed is " + expectedAmount;
        assertTrue(result.contains(expected));
        
        int expectedFrequentRenterPoints = 1;
        String expectedFrequentRenterPointsText = "You earned " + expectedFrequentRenterPoints + " frequent renter points";
        assertTrue(result.contains(expectedFrequentRenterPointsText));
    }

    @Test
    public void testLongTermChildrenRentalAmountCalculation() {
        Movie movie = MovieFactory.createFilm(MovieTypes.CHILDRENS, "Winnie the Pooh");
        Rental rental = new Rental(movie, 6);
        Customer customer = new Customer("Judy Jusper");
        customer.addRental(rental);
        String result = customer.getOwnBill();

        double expectedAmount = 6.0;
        String expected = "Amount owed is " + expectedAmount;
        assertTrue(result.contains(expected));
        
        int expectedFrequentRenterPoints = 1;
        String expectedFrequentRenterPointsText = "You earned " + expectedFrequentRenterPoints + " frequent renter points";
        assertTrue(result.contains(expectedFrequentRenterPointsText));
    }

    @Test
    public void testOneDayNewReleaseRentalAmountCalculation() {
        Movie movie = MovieFactory.createFilm(MovieTypes.NEW_RELEASE, "John Wick: Chapter 3 - Parabellum");
        Rental rental = new Rental(movie, 1);
        Customer customer = new Customer("John Doe");
        customer.addRental(rental);

        String result = customer.getOwnBill();

        double expectedAmount = 3.0;
        String expectedAmountText = "Amount owed is " + expectedAmount;
        assertTrue(result.contains(expectedAmountText));

        int expectedFrequentRenterPoints = 1;
        String expectedFrequentRenterPointsText = "You earned " + expectedFrequentRenterPoints + " frequent renter points";
        assertTrue(result.contains(expectedFrequentRenterPointsText));
    }

    @Test
    public void testTwoDaysNewReleaseRentalAmountCalculation() {
        Movie movie = MovieFactory.createFilm(MovieTypes.NEW_RELEASE, "John Wick: Chapter 3 - Parabellum");
        Rental rental = new Rental(movie, 2);
        Customer customer = new Customer("John Doe");
        customer.addRental(rental);

        String result = customer.getOwnBill();

        double expectedAmount = 6.0;
        String expectedAmountText = "Amount owed is " + expectedAmount;
        assertTrue(result.contains(expectedAmountText));

        int expectedFrequentRenterPoints = 2;
        String expectedFrequentRenterPointsText = "You earned " + expectedFrequentRenterPoints + " frequent renter points";
        assertTrue(result.contains(expectedFrequentRenterPointsText));
    }

    @Test
    public void testMoreThanTwoDaysNewReleaseRentalAmountCalculation() {
        Movie movie = MovieFactory.createFilm(MovieTypes.NEW_RELEASE, "John Wick: Chapter 3 - Parabellum" );
        Rental rental = new Rental(movie, 6);
        Customer customer = new Customer("John Doe");
        customer.addRental(rental);

        String result = customer.getOwnBill();

        double expectedAmount = 18.0;
        String expectedAmountText = "Amount owed is " + expectedAmount;
        assertTrue(result.contains(expectedAmountText));

        int expectedFrequentRenterPoints = 2;
        String expectedFrequentRenterPointsText = "You earned " + expectedFrequentRenterPoints + " frequent renter points";
        assertTrue(result.contains(expectedFrequentRenterPointsText));
    }

    @Test
    void testRegularRentalAmountCalculation() {
        Customer customer = new Customer("John Doe");
        Movie movie = MovieFactory.createFilm(MovieTypes.REGULAR, "Venom" );
        Rental rental = new Rental(movie, 1);
        customer.addRental(rental);
        String result = customer.getOwnBill();

        double expectedAmount = 2.0;
        String expected = "Amount owed is " + expectedAmount;
        assertTrue(result.contains(expected));
        
        int expectedFrequentRenterPoints = 1;
        String expectedFrequentRenterPointsText = "You earned " + expectedFrequentRenterPoints + " frequent renter points";
        assertTrue(result.contains(expectedFrequentRenterPointsText));
      }

      @Test
      void testLongTermRegularRentalAmountCalculation() {
        Customer customer = new Customer("John Doe");
        Movie movie = MovieFactory.createFilm(MovieTypes.REGULAR, "Venom");
        Rental rental = new Rental(movie, 7);
        customer.addRental(rental);
        String result = customer.getOwnBill();

        double expectedAmount = 9.5;
        String expected = "Amount owed is " + expectedAmount;
        assertTrue(result.contains(expected));
        
        int expectedFrequentRenterPoints = 1;
        String expectedFrequentRenterPointsText = "You earned " + expectedFrequentRenterPoints + " frequent renter points";
        assertTrue(result.contains(expectedFrequentRenterPointsText));
      }
}
