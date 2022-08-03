import java.util.InputMismatchException;
import java.util.Scanner;
public class CarLoan {
    public static void main(String[] args) {
        int carLoan = 0;
        int downPayment = 2000; //down payment by a user for this car purchase
        //Fixed bank rules for length and interest rate:
        int loanLength = 3; //loan length of 3 years
        int interestRate = 10; //interest rate of 5% on the loan

       /* Scanner myObj = new Scanner(System.in);
        System.out.println("Enter username");
        String userName = myObj.nextLine();
        System.out.println("username is : " + userName);
        if(loanLength <= 0 || interestRate <= 0) {
            System.out.println("Error! You must take out a valid car loan.");
        } else if (downPayment >= carLoan) {
            System.out.println("The car can be paid in full.");
        }
        //If input is of type Int ask the user for a valid username input:
        else if (myObj.hasNextInt()) {
            String input = myObj.next();
            System.out.printf("\"%s\" is not a valid username.%n", input);
        }
        else {
            //After checking that the user inputs valid information for number  of years to repay the loan and that he selects an interest rate of at least 1%,
            //then, the program checks also how much down payment the user is doing so that unnecessary loan credits are avoided when the car can be paid in full.
            //Finally, the program calculates the remaining balance, converts the years into months to be able to calculate the monthly balance net, the interest rate gets calculated, then we can inform to the user how much he will need to pay monthly when borrowing a loan of 1000 euros at 5% interest rate:
            int remainingBalance = carLoan - downPayment;
            int months = loanLength * 12; //36 months
            int monthlyBalance = remainingBalance / months;
            int interest = monthlyBalance * interestRate / 100;
            int monthlyPayment = monthlyBalance + interest;
            System.out.println( "Your monthly car loan payment with interest will be: "  + monthlyPayment);
        }
        */
        //NEW updated versie  van dit programme:
        //Added user input for car loan and min down payment and
        //Checks first if username is a String, if it is not, the program ends.
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter username");
        if(myObj.hasNext("[A-Za-z]*")) {
            String userName = myObj.nextLine();
            System.out.println("username is : " + userName);
            try {
                //Requested car loan
                Scanner reqCarLoan = new Scanner(System.in);
                System.out.println("Enter req car loan: ");
                int carL = reqCarLoan.nextInt();
                System.out.println("requested car loan: " + carL);
                //down payment:
                Scanner minDownPayment = new Scanner(System.in);
                System.out.println("down payment?: ");
                int minDownP = minDownPayment.nextInt();
                System.out.println("Down Payment is : " + minDownP);
                //Checks valid input for car loan and down payment:
                if (carL <= 0 || minDownP <= 0) {
                    System.out.println("Error! not valid input.");
                } else if (minDownP < 199) {
                    System.out.println("You are NOT eligible to receive a car loan ");
                } else if (minDownP >= 200) {  //Minimum down payment 200 euros
                    System.out.println("You are eligible to receive a car loan of: " + carL);
                    //After checking that the user inputs valid information,
                    //The program checks how much down payment the user is doing and
                    //Finally, the program calculates the remaining balance, converts the years into months to be able to calculate the monthly balance net, the interest rate gets calculated, then we can inform to the user how much he will need to pay monthly when borrowing a loan of 1000 euros at 5% interest rate:
                    int remainingBalance = carL - minDownP;
                    int months = loanLength * 12; //36 months
                    int monthlyBalance = remainingBalance / months;
                    int interest = monthlyBalance * interestRate / 100;
                    int monthlyPayment = monthlyBalance + interest;
                    System.out.println("Your monthly car loan payment with interest will be:  " + monthlyPayment + " Euros");
                }
            }
        catch (InputMismatchException e) {
            System.out.println("Not an number. Please start again with the right information");
        }
        } else {
            System.out.println("Please Enter a Valid Value");
        }

    }
}