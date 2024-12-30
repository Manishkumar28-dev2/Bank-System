import java.util.Scanner;

class Account {
    String Account_holder;
    long Account_number;
    long phone_number;
    String date_of_birth;
    String mail;
    String address;
    long amount;

    Account(String Account_holder, long Account_number, long phone_number, String date_of_birth, String mail, String address, long amount) {
        this.Account_holder = Account_holder;
        this.Account_number = Account_number;
        this.phone_number = phone_number;
        this.date_of_birth = date_of_birth;
        this.mail = mail;
        this.address = address;
        this.amount = amount;
    }

    long getBalance() {
        return amount;
    }

    void showDetails() {
        System.out.println("\nAccount Details:");
        System.out.println("1) Account Holder: " + this.Account_holder);
        System.out.println("2) Account Number: " + this.Account_number);
        System.out.println("3) Phone Number: " + this.phone_number);
        System.out.println("4) Date of Birth: " + this.date_of_birth);
        System.out.println("5) Email: " + this.mail);
        System.out.println("6) Address: " + this.address);
        System.out.println("7) Balance: " + this.amount);
    }

    void closeAccount() {
        Account_holder = "";
        Account_number = 0;
        phone_number = 0;
        date_of_birth = "";
        mail = "";
        address = "";
        amount = 0;
        System.out.println("The account has been successfully closed.");
    }
}

class SavingAccount extends Account {
    SavingAccount(String Account_holder, long Account_number, long phone_number, String date_of_birth, String mail, String address, long amount) {
        super(Account_holder, Account_number, phone_number, date_of_birth, mail, address, amount);
    }

    long deposit(long amo) {
        this.amount += amo;
        System.out.println("Deposit of " + amo + " successful. New Balance: " + this.amount);
        return this.amount;
    }

    long withdraw(long amo) {
        if (this.amount >= amo) {
            this.amount -= amo;
            System.out.println("Withdrawal of " + amo + " successful. New Balance: " + this.amount);
        } else {
            System.out.println("Insufficient balance. Withdrawal failed.");
        }
        return this.amount;
    }
}

public class Manish {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SavingAccount account = null;

        while (true) {
            System.out.println("\nWelcome to the Bank System");
            System.out.println("1) Create a Bank Account");
            System.out.println("2) Deposit Money");
            System.out.println("3) Withdraw Money");
            System.out.println("4) Show Account Details");
            System.out.println("5) Close Account");
            System.out.println("6) Exit");
            System.out.print("Please enter your choice: ");

            int option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter Name: ");
                    sc.nextLine(); // Consume newline
                    String name = sc.nextLine();
                    System.out.print("Enter Account Number: ");
                    long accNo = sc.nextLong();
                    System.out.print("Enter Phone Number: ");
                    long phone = sc.nextLong();
                    System.out.print("Enter Date of Birth (DD/MM/YYYY): ");
                    sc.nextLine(); // Consume newline
                    String dob = sc.nextLine();
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter Address: ");
                    String address = sc.nextLine();
                    System.out.print("Enter Initial Deposit Amount: ");
                    long amount = sc.nextLong();

                    account = new SavingAccount(name, accNo, phone, dob, email, address, amount);
                    System.out.println("Account created successfully.");
                    break;

                case 2:
                    if (account != null) {
                        System.out.print("Enter deposit amount: ");
                        long depositAmount = sc.nextLong();
                        account.deposit(depositAmount);
                    } else {
                        System.out.println("No account found. Please create an account first.");
                    }
                    break;

                case 3:
                    if (account != null) {
                        System.out.print("Enter withdrawal amount: ");
                        long withdrawAmount = sc.nextLong();
                        account.withdraw(withdrawAmount);
                    } else {
                        System.out.println("No account found. Please create an account first.");
                    }
                    break;

                case 4:
                    if (account != null) {
                        account.showDetails();
                    } else {
                        System.out.println("No account found. Please create an account first.");
                    }
                    break;

                case 5:
                    if (account != null) {
                        account.closeAccount();
                        account = null;
                    } else {
                        System.out.println("No account found.");
                    }
                    break;

                case 6:
                    System.out.println("Thank you for using the Bank System. Goodbye!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
