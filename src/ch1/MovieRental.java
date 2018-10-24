package ch1;

public class MovieRental {

    public static void main (String[] args){

        /*Stock movies*/
        Movie mov1 = new Movie ("Notebook", 0);
        Movie mov2 = new Movie ("Avengers", 1);
        Movie mov3 = new Movie ("Play time", 2);

        /*Register nen*/
        Customer customer1 = new Customer("TK");

        /*Start ch1.Rental*/
        Rental rentActivity1 = new Rental (mov1, 3);
        Rental rentActivity2 = new Rental (mov2, 5);

        customer1.addRental(rentActivity1);
        customer1.addRental(rentActivity2);




    }
}
