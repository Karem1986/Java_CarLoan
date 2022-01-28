import java.util.Scanner;
public class CarLoan {
    public static void main(String[] args) {
        int carLoan = 10000;
        int loanLength = 3; //a loan length of 3 years
        int interestRate = 5; //interest rate of 5% on the loan
        int downPayment = 2000; //down payment by a user for this car purchase
        Scanner myObj = new Scanner(System.in);
        String userName = new String();
        System.out.println("Enter username: " + userName);

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

    }
}