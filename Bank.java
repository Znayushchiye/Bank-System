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

    public void setData() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name: ");
        name = sc.nextLine();
        System.out.println("Enter your phone number: ");
        phone = sc.nextLong();
        System.out.println("Enter your address: ");
        sc.nextLine();
        address = sc.nextLine();
        System.out.println("Enter your age: ");
        age = sc.nextInt();
        System.out.println("Enter your account type: ");
        accountType = sc.next().charAt(0);
        System.out.println("Enter your balance: ");
        balance = sc.nextDouble();
        sc.close();
    }

    public void getData() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Phone Number: " + phone);
        System.out.println("User Address: " + address);
        System.out.println("Account Type: " + accountType);
        System.out.println("Account balance: " + balance);
    }

    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.setData();
        bank.getData();
    }
}