package com.CodSoft;
import java.util.Scanner;

class Bankacc {
    private double balance;

    public Bankacc(double cur_Balance) {
        balance = cur_Balance;
    }

    public void withdraw(double amount) {
        if(amount > 0) {
            if(balance >= amount) {
                balance -= amount;
                System.out.println(amount + " has been withdrawn successfully");
                System.out.println("Current Balance is " + balance + " rs");
            } else {
                System.out.println("Insufficient Balance");
            }
        }
    }

    public void deposit(double amount) {
        if(amount > 0) {
            balance += amount;
            System.out.println(amount + " has been deposited to your account");
            System.out.println("Current Balance is " + balance + " rs");
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    public void checkBalance() {
        System.out.println("Account Balance is " + balance + " rs");
    }
}

class ATM {
    private Bankacc account;

    public ATM(Bankacc acc) {
        this.account = acc;
    }

    public static void menu() {
        System.out.println("/// ATM Menu ///");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void transaction(int op, Scanner sc) {
        switch(op) {
            case 1:
                System.out.print("Enter the amount to withdraw: ");
                double withdrawal_amount = sc.nextDouble();
                account.withdraw(withdrawal_amount);
                break;
            case 2:
                System.out.print("Enter the amount to deposit: ");
                double deposit_amount = sc.nextDouble();
                account.deposit(deposit_amount);
                break;
            case 3:
                account.checkBalance();
                break;
            case 4:
                System.out.println("Transaction exited...");
                sc.close();
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
    }
}

public class ATM_Interface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Initial Balance in Bank Account: ");
        double cur_Balance = sc.nextDouble();
        Bankacc acc = new Bankacc(cur_Balance);
        ATM atm = new ATM(acc);

        while(true) {
            ATM.menu();
            System.out.print("Enter your choice: ");
            int op = sc.nextInt();
            atm.transaction(op, sc);
        }
    }
}

/* ATM Interface 1.Create a class to represent the ATM machine.

2. Design the user interface for the ATM, including options such as withdrawing, depositing, and
checking the balance.

3. Implement methods for each option, such as withdraw(amount), deposit(amount), and
checkBalance().

4. Create a class to represent the user's bank account, which stores the account balance.

5. Connect the ATM class with the user's bank account class to access and modify the account
balance.

6. Validate user input to ensure it is within acceptable limits (e.g., sufficient balance for withdrawals).

7. Display appropriate messages to the user based on their chosen options and the success or failure
of their transactions.*/
