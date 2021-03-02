import java.util.Scanner;
import java.lang.Math;

public class Canteen {
    private final Scanner scanner = new Scanner(System.in);
    double canteenBalance;
    double customerBalance;
    int chipsInventory;
    int cookiesInventory;
    int cost;

    Canteen(double canteenBalance, double customerBalance, int chipsInventory, int cookiesInventory) {
        this.canteenBalance = canteenBalance;
        this.customerBalance = customerBalance;
        this.chipsInventory = chipsInventory;
        this.cookiesInventory = cookiesInventory;
    }

    void setCanteenBalance(int cost) {
        canteenBalance = canteenBalance + cost;
    }

    void setCookieInventory() {
        cookiesInventory = cookiesInventory - 1;
    }

    void setChipInventory() {
        chipsInventory = chipsInventory - 1;
    }

    double getCustomerBalance() {
        return customerBalance;
    }

    void setCustomerBalance(int cost) {
        customerBalance = customerBalance - cost;
    }

    int getCookiesInventory() {
        return cookiesInventory;
    }

    int getChipsInventory() {
        return chipsInventory;
    }

    public void printCanteenCurrentUpdate() {
        System.out.println("Alright,\nYou got $" + Math.round(customerBalance) + " left, pal...");
        System.out.println("And we got " + getCookiesInventory() + " cookie(s) left and " + getChipsInventory() + " bag(s) of chips...\n");
    }

    boolean isStoreOpen() {
        if (cookiesInventory == 0 && chipsInventory == 0) {
            System.out.println("I'm SOLD OUT, buddy, you'll have to get your fix some place else...");
            System.out.println("Not a bad day, went home with $" + Math.round(canteenBalance) + " in my pocket\n");
            return false;
        } else {
            return true;
        }
    }

    void sellTreat() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Welcome back to The (rather surly) Canteen! We ONLY sell 'Cookies' and 'Chips'!");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        System.out.println("Wha'd'ya want, a 'cookie' or a bag of 'chips'? (Enter 'cookie' or 'chips'):");
        String userInput = scanner.nextLine();
        while (!userInput.equalsIgnoreCase("cookie") && !userInput.equalsIgnoreCase("chips")) {
            System.out.println("We don't sell " +userInput + " here, you want a 'cookie' or a bag of 'chips'?:");
            userInput = scanner.nextLine();
        }
        if (userInput.equalsIgnoreCase("cookie")) {
            cost = 1;
            if (getCookiesInventory() == 0) {
                System.out.println("Sorry we are all out of cookies...");
            } else if (getCustomerBalance() == 0) {
                System.out.println("And people in Hell want ice water... \n\nYOU'RE OUTTA MONEY... \nCome back when you find some!\n\n*KICKS CUSTOMER TO THE CURB*");
                System.exit(0);
            } else if (getCustomerBalance() < cost) {
                System.out.println("Sorry, bud, you ain't got enough money for a cookie! Try something else...");
            } else {
                setCookieInventory();
                setCustomerBalance(cost);
                setCanteenBalance(cost);
            }
        } else {
            cost = 2;
            if (getChipsInventory() == 0) {
                System.out.println("Sorry we're out of chips...");
            }else if (getCustomerBalance() == 0) {
                System.out.println("And people in Hell want ice water... \n\nYOU'RE OUTTA MONEY... \nCome back when you find some!\n\n*KICKS CUSTOMER TO THE CURB*");
                System.exit(0);
            } else if (getCustomerBalance() < cost) {
                System.out.println("Sorry, bud, you ain't got enough money for chips! Try something else...");
            } else {
                setChipInventory();
                setCustomerBalance(cost);
                setCanteenBalance(cost);
            }
        }
        printCanteenCurrentUpdate();
    }
}
