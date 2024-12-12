package application;

import entities.Account;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Bank account");

        System.out.print("Number: ");
        int number = sc.nextInt();
        System.out.print("Holder: ");
        sc.nextLine();
        String holder = sc.nextLine();
        System.out.print("Initial Balance: ");
        double balance = sc.nextDouble();
        System.out.print("Withdraw limit: ");
        double withdrawLimit = sc.nextDouble();

        Account account = new Account(number, holder, balance, withdrawLimit);

        System.out.print("Enter amount for withdraw: ");
        double amount = sc.nextDouble();

        String error = account.validateWithdraw(amount);
        if(error != null){
            System.out.println(error);
        }
        else{
            account.withdraw(amount);
            System.out.printf("New balance: %.2f%n ", account.getBalance());
        }
        sc.close();
    }
}