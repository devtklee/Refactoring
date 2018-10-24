package ch1;

public class Movie {

    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String _title;
    private int _priceCode;

    public Movie (String title, int priceCode){
        _title = title;
        _priceCode = priceCode;
    }


    public int getPriceCode(){
        return _priceCode;
    }

    public void setPriceCode (int arg){
        this._priceCode = arg;
    }

    public String getTitle(){
        return _title;
    }

    /**
     * Change name of variables/parameters to increase readability
     * each -> rental
     * thisAmount -> result
     *
     * Move getAmount() Method from ch1.Customer to ch1.Rental since method should be on the object whose data it uses.
     * + GetAmount() method should be move to Movie object since this method is using switch statement of Movie obj
     *
     * @param rental*/
    double getAmount(Rental rental) {
        double result = 0;
        switch (rental.getMovie().getPriceCode()) {
            case REGULAR:
                result += 2;
                if (rental.getDaysRented() > 2)
                    result += (rental.getDaysRented() - 2) * 1.5;
                break;
            case NEW_RELEASE:
                result += rental.getDaysRented() * 3;
                break;
            case CHILDRENS:
                result += 1.5;
                if (rental.getDaysRented() > 3)
                    result += (rental.getDaysRented() - 3) * 1.5;
                break;
        }
        return result;
    }
}
