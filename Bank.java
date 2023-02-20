import java.util.Scanner;

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

    private boolean setData() {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;

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
        age = sc.nextInt();

        System.out.print("Enter your account type: ");
        accountType = sc.next().charAt(0);

        System.out.print("Enter your balance: ");
        balance = sc.nextDouble();

        sc.close();
        return flag;
    }

    private void getData() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Phone Number: " + phone);
        System.out.println("User Address: " + address);
        System.out.println("Account Type: " + accountType);
        System.out.println("Account balance: " + balance);
    }

    private boolean createAccount() {
        System.out.println("Enter User Details:");
        if (this.setData())
            return false;
        else
            return true;
    }

    public static void main(String[] args) {
        Bank bank = new Bank();
        if (bank.createAccount())
            System.out.println("New Account created successfully.");
        else
            System.out.println("Error in creating account! Try again later.");
        bank.getData();
    }
}