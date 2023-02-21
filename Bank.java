import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;

public class Bank {
    private String name, address;
    private double balance;
    private int age;
    private char accountType;
    private long phone;

    public Bank() {
        name = address = null;
        balance = phone = age = 0;
        accountType = '\0';
    }

    public Bank(String name, String address, double balance, int age, char accountType, long phone) {
        this.name = name;
        this.address = address;
        this.balance = balance;
        this.age = age;
        this.accountType = accountType;
        this.phone = phone;
    }

    private boolean isValidPhoneNumber(long phone) {
        int counter = 0;
        while (phone != 0) {
            counter++;
            phone /= 10;
        }
        if (counter == 10)
            return true;
        else
            return false;
    }

    private int setData() {
        Scanner sc = new Scanner(System.in);
        int flag = 1;

        System.out.print("Enter your name: ");
        name = sc.nextLine();

        System.out.print("Enter your phone number: ");
        do {
            phone = sc.nextLong();
            if (!this.isValidPhoneNumber(phone))
                System.out.println("Invalid phone number! Enter again.");
            else
                break;
        } while (true);

        System.out.print("Enter your address: ");
        sc.nextLine();
        address = sc.nextLine();

        System.out.print("Enter your age: ");
        do {
            age = sc.nextInt();
            if (age < 15)
                System.out.println("Age must be older than 15! Enter again.");
            else
                break;
        } while (true);

        System.out.print("Enter your account type: ");
        do {
            accountType = sc.next().trim().charAt(0);
            if ("SsTtLl".indexOf(accountType) == -1)
                System.out.println("Enter 'S' for Savings, 'L' for Salary or 'T' for Student only!");
            else if (("Ss".indexOf(accountType) == -1 && age < 18) || ("Ss".indexOf(accountType) != -1) && age > 17) {
                System.out.println("Student account type possible only for ages between 15 and 17! Enter age again?");
                if (Character.toUpperCase(sc.next().trim().charAt(0)) == 'Y') {
                    System.out.println("Enter age again:");
                    age = sc.nextInt();
                } else
                    System.out.println("Enter account type again:");
            } else
                break;
        } while (true);

        System.out.print("Enter your balance: ");
        do {
            balance = sc.nextDouble();
            if (balance < 0)
                System.out.println("Account balance cannot be negative! Enter again.");
            else if ((balance == 0) && !(accountType == 'T' || accountType == 't'))
                System.out.println("Account balance can be 0 only in Student account! Enter again.");
            else
                break;
        } while (true);

        sc.close();
        return flag;
    }

    private int getData() {
        int flag = 1;

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Phone Number: " + phone);
        System.out.println("User Address: " + address);
        System.out.println("Account Type: " + accountType);
        System.out.println("Account balance: " + balance);

        return flag;
    }

    private int createAccount() {
        System.out.println("Enter Your Details-");
        if (this.setData() == 1)
            return 1;
        else
            return 0;
    }

    private int update() {
        int flag = 1;
        return flag;
    }
    /*
     * private int deleteAccount() {
     * 
     * }
     */

    private void withdraw(double amount) {
        this.balance = this.balance - amount;
        System.out.println("Rs. " + amount + "/- withdrawen from the account.");
        System.out.println("Final balance: Rs." + this.balance + "/-");
    }

    private void deposit(double amount) {
        this.balance = this.balance + amount;
        System.out.println("Rs. " + amount + "/- deposited into the account.");
        System.out.println("Final balance: Rs." + this.balance + "/-");
    }

    private int printDetails() {
        System.out.println("User details- ");
        if (this.getData() != 1)
            return 0;
        return 1;
    }

    public static void main(String[] args) {
        Bank bank = new Bank();

        System.out.println("Choose an option from below to perform.");
        System.out.println("#1 - Create new bank account");
        System.out.println("#2 - Print account details");
        System.out.println("#3 - Withdraw amount from account");
        System.out.println("#4 - Deposit amount into account");
        System.out.println("#5 - Update details");
        System.out.println("#6 - Delete account");
        System.out.println("Enter your choice: ");

        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        switch (choice) {
            case 1: {
                if (bank.createAccount() == 1)
                    System.out.println("New Account created successfully.");
                else
                    System.out.println("Error in creating account! Try again later.");
                break;
            }
            case 2: {
                if (bank.printDetails() != 1)
                    System.out.println("Error in printing details! Try again later.");
                break;
            }
            case 3: {
                System.out.println("Enter the amount to be withdrawen:");
                double amount;
                do {
                    amount = sc.nextDouble();
                    if (amount == 0)
                        System.out.println("Withdraw amount cannot be 0! Enter withdraw amount again.");
                    else if (amount < 0)
                        System.out.println("Withdraw amount cannot be negative! Enter withdraw amount again.");
                    else if (amount == bank.balance && bank.accountType != 'S' && bank.accountType != 's')
                        System.out.println("Balance cannot be zero for this account! Enter withdraw amount again.");
                    else {
                        bank.withdraw(amount);
                        break;
                    }
                } while (true);
                break;
            }
            case 4: {
                System.out.println("Enter the amount to be deposited:");
                double amount;
                do {
                    amount = sc.nextDouble();
                    if (amount == 0)
                        System.out.println("Deposit amount cannot be 0! Enter deposit amount again.");
                    else if (amount < 0)
                        System.out.println("Deposit amount cannot be negative! Enter deposit amount again.");
                    else {
                        bank.deposit(amount);
                        break;
                    }
                } while (true);
                break;
            }
            case 5: {
                if (bank.update() != 1)
                    System.out.println("Error updating user details! Please try again later.");
                break;
            }
        }
        sc.close();
    }
}