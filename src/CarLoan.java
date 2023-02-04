import java.util.InputMismatchException;
import java.util.Scanner;
public class CarLoan {
    public static void main(String[] args) {
        int loanLength = 3; //loan length of 3 years
        int interestRate = 10; //interest rate on the loan

       /* Simple version to test:

        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter username");
        String userName = myObj.nextLine();
        System.out.println("username is : " + userName);
        if(loanLength <= 0 || interestRate <= 0) {
            System.out.println("Error! You must take out a valid car loan.");
        } else if (downPayment >= carLoan) {
            System.out.println("The car can be paid in full.");
        }
        //If input is of type int ask the user for a valid username input:
        else if (myObj.hasNextInt()) {
            String input = myObj.next();
            System.out.printf("\"%s\" is not a valid username.%n", input);
        }
        else {
            //After checking that the user inputs valid information for number  of years to repay the loan and that he selects an interest rate of at least 1%,
            //The program checks also how much down payment the user is doing so that unnecessary loan credits are avoided when the car can be paid in full.
            //Finally, the program calculates the remaining balance, converts the years into months to be able to calculate the monthly balance net, the interest rate gets calculated, then we can inform to the user how much he will need to pay monthly when borrowing a loan of 1000 euros at 5% interest rate:
            int remainingBalance = carLoan - downPayment;
            int months = loanLength * 12; //36 months
            int monthlyBalance = remainingBalance / months;
            int interest = monthlyBalance * interestRate / 100;
            int monthlyPayment = monthlyBalance + interest;
            System.out.println( "Your monthly car loan payment with interest will be: "  + monthlyPayment);
        }
        */
        //NEW updated version:
        //Added user input for car loan and min down payment
        //Checks if amount to borrow is up to the limit
        //Checks first if username is a String, if it is not, the program ends.
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter username");
        if(myObj.hasNext("[A-Za-z]*")) {//the username should be a name, not a number or anything else.
            String userName = myObj.nextLine();
            System.out.println("username is : " + userName);
            try {
                //Requested car loan
                Scanner reqCarLoan = new Scanner(System.in);
                System.out.println("Enter req car loan: ");
                int carL = reqCarLoan.nextInt();
                if (carL >= 40999) {
                    System.out.println("Sorry, we only give loans of up to 40998 euros");
                } else {
                    System.out.println("requested car loan: " + carL);
                     //Asks for the rest of requirements only after checking that the amount requested can be borrowed
                    Scanner minDownPayment = new Scanner(System.in);
                    System.out.println("down payment?: ");
                    int minDownP = minDownPayment.nextInt();
                    System.out.println("Down Payment is : " + minDownP);
                    //Checks valid input for car loan and down payment:
                    if (carL <= 0 || minDownP <= 0) {
                        System.out.println("Error! not valid input.");
                    }
                    else if (minDownP <= 38 ) {
                        System.out.println("You are NOT eligible to receive a car loan, min down payment is 39 euros");
                    } else if (minDownP >= 39) {  //Minimum down payment
                        System.out.println("You are eligible to receive a car loan of: " + carL);
                        //The program checks how much down payment the user is doing and
                        //Finally,it calculates the remaining balance, converts the years into months to be able to calculate the monthly balance net, the interest rate gets calculated,
                        // then we can inform to the user how much he will need to pay monthly when borrowing a loan of 1000 euros at xxx% interest rate:
                        int remainingBalance = carL - minDownP;
                        int months = loanLength * 12; //36 months
                        int monthlyBalance = remainingBalance / months;
                        int interest = monthlyBalance * interestRate / 100;
                        int monthlyPayment = monthlyBalance + interest;
                        System.out.println("Your monthly car loan payment with interest will be:  " + monthlyPayment + " Euros");
                    }
                }

            }
        catch (InputMismatchException e) {
            System.out.println("Not an number. Please start again with the right information");
        }
        } else {
            System.out.println("Please enter a valid username");
        }

    }
}