

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class Tester {
    /**
     * @Javeria Jalil
     * Developed a Java app that mocks a bank account, allowing the user to enter name, balance, 
     * deposit, and withdrawal information, leveraging concepts such as loops, arrays, and sorting algorithms.
     */
    public static void main(String[] args) {
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMinimumFractionDigits(2);
        formatter.setMaximumFractionDigits(2);
        String name;
        ArrayList<BankAccount> bankAccounts = new ArrayList<>();
        ListIterator<BankAccount> iterator = bankAccounts.listIterator();

        do {
            Scanner kbReader = new Scanner(System.in);
            System.out.print("Please enter the name to whom the account belongs. (\"Exit\" to abort) ");
            name = kbReader.nextLine();
            if (!name.equalsIgnoreCase("EXIT")) {
                System.out.print("Please enter the amount of the deposit. ");
                double amount = kbReader.nextDouble();
                System.out.println(" ");
                BankAccount theAccount = new BankAccount(name, amount);
                iterator.add(theAccount);
            }
        } while (!name.equalsIgnoreCase("EXIT"));

        BankAccount maxAccount = null;
        double maxBalance = Double.NEGATIVE_INFINITY;

        while (iterator.hasPrevious()) {
            BankAccount currentAccount = iterator.previous();
            double currentBalance = currentAccount.balance;
            if (Math.abs(currentBalance) > Math.abs(maxBalance)) {
                maxAccount = currentAccount;
                maxBalance = currentBalance;
            }
        }

        System.out.println(" ");
        if (maxAccount != null) {
            System.out.println("The account with the largest balance belongs to " + maxAccount.name + ".");
            System.out.println("The amount is $" + formatter.format(maxBalance) + ".");
        } else {
            System.out.println("No accounts found.");
        }
    }
}
