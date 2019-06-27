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
public class ChildrensMovie extends Movie {
    private final boolean loyaltyPoint=false;
    
    public ChildrensMovie(String title) {
        super(title);
    }

    @Override
    public double getPriceByRentalDays(int rentalDays) {
        return 1.5+(rentalDays>3?(rentalDays-3)*1.5:0);
    }

    @Override
    public boolean getLoyaltyPoints() {
        return loyaltyPoint;
    }

}
