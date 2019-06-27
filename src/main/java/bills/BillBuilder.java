/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bills;

/**
 *
 * @author wagnerz
 */
public class BillBuilder {

    private double totalPrice;
    private int totalLoyaltyPoints;
    private String headerOfTheBill;
    private String bodyOfTheBill;
    private String summaryOfTheBill;

    public BillBuilder(String name) {
        headerOfTheBill = "Rental Record for" + name + "\n";
        totalPrice = 0.0;
        totalLoyaltyPoints = 0;
        bodyOfTheBill="";
    }

    public BillBuilder addRentalItem(String movieTitle, double price, int loyaltyPoints) {
        bodyOfTheBill += "\t" + movieTitle + "\t" + String.valueOf(price) + "\n";
        totalPrice += price;
        totalLoyaltyPoints += loyaltyPoints;
        return this;
    }

    public String buildBill() {
        summaryOfTheBill="Amount owed is " + totalPrice + "\n";
        summaryOfTheBill += "You earned " + totalLoyaltyPoints + " frequent renter points";
        return headerOfTheBill+bodyOfTheBill+summaryOfTheBill;
    }
}
