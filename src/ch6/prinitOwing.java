package ch6;

/*
* Extract Method
*
* If method is too long or requires comment to understand the purpose of method, split codes by creating separate method.
* */

public class prinitOwing {

    void printBanner(){
        //Printing Banner code goes here...
    }

    void printOwing(double amount) {
        printBanner();

        //print details
        System.out.println("name : " + name);
        System.out.println("amount" + amount);
    }

/*    void printOwing (double amount){
        printBanner();
        printDetails(amount);

    }

    void printDetails (double amount){
        //print details
        System.out.println("name : " + _name);
        System.out.println("amount" + amount);
    }*/
}