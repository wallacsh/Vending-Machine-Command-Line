package com.techelevator;

import com.techelevator.view.Menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachineCLI {

    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
    private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
    private static final String MAIN_MENU_OPTION_EXIT = "Exit";
    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE,
            MAIN_MENU_OPTION_EXIT};

    private Menu menu;
    private List<VendingItem> vendingItemList = new ArrayList<>();
    BigDecimal customerBalance = new BigDecimal(0.00);


    LogUtility logUtility = new LogUtility("log.txt");

    //PrintWriter writer;
//    File logFile = new File("src\\main\\resources\\log.txt");
//
//
//    {
//        try {
//            writer = new PrintWriter(logFile);
//            System.out.println(logFile);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }




    public VendingMachineCLI(Menu menu) {
        this.menu = menu;
    }


    public void run() {


        //logUtility.write("STARTING MACHINE");

        //read in the file
        Scanner input = null;

        try {
            input = new Scanner(new File("vendingmachine.csv"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        while (input.hasNextLine()) {
            String line = input.nextLine();
            String[] lineArray = line.split("\\|");
            if (lineArray[3].equals("Chip")) {
                vendingItemList.add(new Chips(lineArray[0], lineArray[1],
                        Double.parseDouble(lineArray[2])));
            } else if (lineArray[3].equals("Drink")) {
                vendingItemList.add(new Drink(lineArray[0], lineArray[1],
                        Double.parseDouble(lineArray[2])));
            } else if (lineArray[3].equals("Candy")) {
                vendingItemList.add(new Candy(lineArray[0], lineArray[1],
                        Double.parseDouble(lineArray[2])));
            } else if (lineArray[3].equals("Gum")) {
                vendingItemList.add(new Gum(lineArray[0], lineArray[1],
                        Double.parseDouble(lineArray[2])));
            }
        }

        while (true) {
            String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

            if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
                //need to find a way to display quantity remaining also
                for (int i = 0; i < vendingItemList.size(); i++) {
                    if (vendingItemList.get(i).getQuantity() == 0) {
                        System.out.println(vendingItemList.get(i).getSlotLocation() + "--"
                                + vendingItemList.get(i).getProductName() + "--$" +
                                vendingItemList.get(i).getPrice().setScale(2, RoundingMode.HALF_UP) +
                                "--Sold out!");
                    } else {
                        System.out.println(vendingItemList.get(i).getSlotLocation() + "--"
                                + vendingItemList.get(i).getProductName() + "--$" +
                                vendingItemList.get(i).getPrice().setScale(2, RoundingMode.HALF_UP) +
                                "--Quantity left: " + vendingItemList.get(i).getQuantity());

                    }
                }

            } else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
                //method for calling purchase menu
                subMenu();
                //bringing up vending machine and available quantities

            } else {
                System.exit(0);
            }
        }
    }

    public void subMenu() {

        final String FEED_MONEY = "Feed Money";
        final String SELECT_PRODUCT = "Select Product";
        final String FINISH_TRANSACTION = "Finish Transaction";
        final String[] PURCHASE_MENU_OPTIONS = {FEED_MONEY, SELECT_PRODUCT, FINISH_TRANSACTION};
        String feedMoney = "FEED MONEY: ";
        String giveChange = "GIVE CHANGE: ";


        boolean shouldLoop = true;
        int feedMoneyLog = 0;
        while (shouldLoop) {

            String choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

            //here is where we will make switch -- if/else statements for vending choice
            if (choice.equals(FEED_MONEY)) {
                Scanner userInput = new Scanner(System.in);
                System.out.print("Please enter money into the machine [1] [2] [5] [10] >>> ");
                String moneyFeed = userInput.nextLine();
                if (moneyFeed.equals("1")) {
                    customerBalance = customerBalance.add(new BigDecimal(1.00));
                    logUtility.write(feedMoney, new BigDecimal(1.00), customerBalance);
                   // writer.println(nowTime + " " + "Feed Money: $1.00" + " $" + customerBalance);
                    System.out.println("Current Money Provided: $" + customerBalance);
                } else if (moneyFeed.equals("2")) {
                    customerBalance = customerBalance.add(new BigDecimal(2.00));
                    logUtility.write(feedMoney, new BigDecimal(2.00), customerBalance);
                 //   writer.println(nowTime + " " + "Feed Money: $2.00" + " $" + customerBalance);
                    System.out.println("Current Money Provided: $" + customerBalance);
                } else if (moneyFeed.equals("5")) {
                    customerBalance = customerBalance.add(new BigDecimal(5.00));
                    logUtility.write(feedMoney, new BigDecimal(5.00), customerBalance);
                 //   writer.println(nowTime + " " + "Feed Money: $5.00" + " $" + customerBalance);
                    System.out.println("Current Money Provided: $" + customerBalance);
                } else if (moneyFeed.equals("10")) {
                    customerBalance = customerBalance.add(new BigDecimal(10.00));
                    logUtility.write(feedMoney, new BigDecimal(10.00), customerBalance);
                 //   writer.println(nowTime + " " + "Feed Money: $10.00" + " $" + customerBalance);
                    System.out.println("Current Money Provided: $" + customerBalance);
                } else {
                    System.out.println("Invalid input. Please try again.");
                }
                //logUtility.write("Money added");

            } else if (choice.equals(SELECT_PRODUCT)) {
                //Brings up the list of products in vending machine
                for (int i = 0; i < vendingItemList.size(); i++) {
                    System.out.println(vendingItemList.get(i).getSlotLocation() + "--"
                            + vendingItemList.get(i).getProductName() + "--$" + vendingItemList.get(i).getPrice().setScale(2, RoundingMode.HALF_UP) +
                            "--Quantity Left: " + vendingItemList.get(i).getQuantity());
                }
                Scanner userInput = new Scanner(System.in);
                System.out.print("Please enter the item code you want >>> ");
                String itemCode = userInput.nextLine();
                Boolean itemExists = false;
                Boolean enoughMoney = false;


                for (int i = 0; i < vendingItemList.size(); i++) {

                    if (itemCode.equals(vendingItemList.get(i).getSlotLocation())) {
                        itemExists = true;


                        if (vendingItemList.get(i).getQuantity() == 0) {
                            System.out.println("Sold out!");
                            break;
                        }
                        if (customerBalance.compareTo(vendingItemList.get(i).getPrice()) < 0) {
                            System.out.println("You do not have enough money.");
                            break;
                        }
                        vendingItemList.get(i).decQuantity();
                        System.out.println(vendingItemList.get(i).getProductName() + " $" + vendingItemList.get(i).getPrice().setScale(2, RoundingMode.HALF_UP)
                                + " Quantity left: " + vendingItemList.get(i).getQuantity());
                        System.out.println(vendingItemList.get(i).getSound());
                        logUtility.write(vendingItemList.get(i).getProductName() +  " "  + vendingItemList.get(i).getSlotLocation(),
                               customerBalance, customerBalance.subtract(vendingItemList.get(i).getPrice()).setScale(2, RoundingMode.HALF_UP));
                     //   writer.println(nowTime + " " + vendingItemList.get(i).getProductName() + " " + vendingItemList.get(i).getSlotLocation() + " $"
                       //         + customerBalance + " $" + customerBalance.subtract(vendingItemList.get(i).getPrice()).setScale(2, RoundingMode.HALF_UP));
                        customerBalance = customerBalance.subtract(vendingItemList.get(i).getPrice()).setScale(2, RoundingMode.HALF_UP);
                        System.out.println("$" + customerBalance + " Money Remaining");

                       // 01/01/2016 12:00:20 PM Crunchie B4 $10.00 $8.50

                    }
                }

                if (!itemExists) {
                    System.out.println("Item not found, please try again.");
                }




            } else if (choice.equals(FINISH_TRANSACTION)) {
                //System.out.println(customerBalance);
                shouldLoop = false;
                BigDecimal customerChange = customerBalance.multiply(new BigDecimal(100));
                int customerChangeInt = customerChange.intValue();
                int quarters = customerChangeInt / 25;
                int quarterValue = quarters * 25;
                int numberOfDimes = 0;
                int numberOfNickels = 0;
                customerChangeInt = customerChangeInt - quarterValue;
                //System.out.println("# of quarters: " + quarters);
                int qRemainder = customerChangeInt % 10;
                //System.out.println(qRemainder);

                // check qRemainder to see if qRemainder%10 is 0
                if (customerChangeInt > 0) {
                    numberOfDimes = customerChangeInt / 10;
                    int valueOfDimes = numberOfDimes * 10;
                    customerChangeInt = customerChangeInt - valueOfDimes;
                    //System.out.println("# of dimes: " + numberOfDimes);
                    if (customerChangeInt > 0) {
                        numberOfNickels = customerChangeInt / 5;
                        int valueOfNickles = numberOfNickels * 5;
                        customerChangeInt = customerChangeInt - valueOfNickles;
                        //System.out.println("# of nickles: " + numberOfNickels);

                    }
                }
                System.out.println("Your change is: " + quarters + " quarter(s), " + numberOfDimes + " dime(s), " + "and " + numberOfNickels + " nickels.");
               // writer.println(nowTime + " " + "GIVE CHANGE: $" + customerBalance + " $0.00");
                logUtility.write(giveChange, customerBalance, BigDecimal.ZERO);
                customerBalance = BigDecimal.ZERO;



//                700 % 25 = 0;
//                700 / 25;
//                int q = quotentQuarters;
//                int r = 700 % 25;
//                if r = 0;
//                 r > 0;
//                 int dimes
//                 int nickles
//                  r % 10 = 0; if > 0, got to next step
//                        r / 5 = dimes;
//                  if % 5 = 0
//                710 % 25 r 10;



            } else {
                //change this to loop back to purchase menu
                shouldLoop = false;
            }
        }
    }


    public static void main(String[] args) {
        Menu menu = new Menu(System.in, System.out);
        VendingMachineCLI cli = new VendingMachineCLI(menu);
        cli.run();
    }
}
