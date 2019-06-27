/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.gyeekclub.workshop.movies;

/**
 *
 * @author wagnerz
 */
public class NewReleaseMovie extends Movie {
    private final boolean loyaltyPoint=true;
    
    public NewReleaseMovie(String title) {
        super(title);
    }

    @Override
    public double getPriceByRentalDays(int rentalDays) {
        return rentalDays*3.0;
    }

    public boolean getLoyaltyPoints() {
        return loyaltyPoint;
    }
    
    
    
}
