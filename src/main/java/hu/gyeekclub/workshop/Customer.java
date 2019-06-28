package hu.gyeekclub.workshop;

import bills.BillBuilder;
import hu.gyeekclub.workshop.movies.Movie;
import java.util.Enumeration;
import java.util.Vector;

public class Customer {

    private String name;
    private Vector<Rental> rentals = new Vector<>();

    private void checkName(String name) {
        if (name == null) {
            throw new IllegalArgumentException();
        }
    }

    public Customer(String name) {
        checkName(name);
        this.name = name;
    }

    public void addRental(Rental rental) {
        if (rental == null) {
            throw new IllegalArgumentException();
        }
        rentals.addElement(rental);
    }

    public String getName() {
        return name;
    }

    public String getOwnBill() {
        BillBuilder ownBill=new BillBuilder(name);
        rentals.stream().forEach(rental->{
            ownBill.addRentalItem(rental.getMovie().getTitle(),
                    rental.getPriceByMovieTypeAndDay(),
                    rental.getLoyaltyPointsByMovieTypeAndDay());
        });
        return ownBill.buildBill();
    }
}
