package ch1;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {

    private String _name;
    private Vector _rentals = new Vector();

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }

    /**
     * Since thisAmount is now redundant and result of each.getAmount is not changed afterward
     * , replace with Temp With Query
     * */
    public String statement() {
        //double totalAmount = 0;
       // int frequentRenterPoints = 0;
        Enumeration rentals = _rentals.elements();
        String result = "ch1.Rental Record for " + getName() + "\n";
        while (rentals.hasMoreElements()) {
            //double thisAmount = 0;
            Rental each = (Rental) rentals.nextElement();

            //determine amounts for each line
            //thisAmount = each.getAmount();

            /** This activities looks like it is more relate to ch1.Rental Object.
             * 1. Extract Method
             * 2. Move Method
             * */
            //frequentRenterPoints = each.getFrequentRenterPoints();

            //show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" +
                    String.valueOf(each._movie.getAmount(each)) + "\n";  //Replace Temp with Query
            //totalAmount += each.getAmount();    //Replace Temp with Query
        }
        //add footer lines
        result += "Amount owed is " + String.valueOf(getTotalCharge()) +"\n";
        result += "You earned " + String.valueOf(getFrequentRenterPoints()) + " frequent renter points";
        return result;
    }

    public String htmlStatement() {
        Enumeration rentals = _rentals.elements();
        String result = "<H1>Rentals for <EM>" + getName() + "</EM></H1><P>\n";
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();

            //show figures for each rental
            result += each.getMovie().getTitle()+ ": " +
                    String.valueOf(each._movie.getAmount(each)) + "<BR>\n";
        }

        //add footer lines
        result += "<P>You owe <EM>" + String.valueOf(getTotalCharge()) + "</EM><P>\n";
        result += "On this rental you earned <EM>" +
                String.valueOf(getFrequentRenterPoints()) +
                "</EM> frequent renter points<P>";
        return result;
    }

    private int getFrequentRenterPoints() {
        int result =0;

        Enumeration rentals = _rentals.elements();

        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }

    /**
     * Refactoring method test
     * @param rental
     * @return
     */
    /*
    private double getAmount(ch1.Rental rental){
        return rental.getAmount();
    }*/

    /**
     *  Move Method to ch1.Rental since this method is more relate with ch1.Rental obj
     *     private int getFrequentRenterPoints(ch1.Rental each) {
     *         //int frequentRenterPoints = 0 ;
     *
     *         // add frequent renter points
     *         //frequentRenterPoints++;
     *
     *         // add bonus for a two day new release rental
     *         if ((each.getMovie().getPriceCode() == ch1.Movie.NEW_RELEASE) && each.getDaysRented() > 1)
     *             //frequentRenterPoints++;
     *             return 2;
     *         else
     *             return 1;
     *     }
     **/

    private double getTotalCharge(){
        double result =0;

        Enumeration rentals = _rentals.elements();

        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each._movie.getAmount(each);
        }
        return result;
    }

}
