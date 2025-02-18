package CodeSoft;

import java.util.HashMap;
// Task 3 - ATM interface 
// 1.Create a class to represent the ATM machine.
// 2. Design the user interface for the ATM, including options such as withdrawing, depositing, and checking the balance.
// 3. Implement methods for each option, such as withdraw(amount), deposit(amount), and checkBalance().
// 4. Create a class to represent the user's bank account, which stores the account balance.
// 5. Connect the ATM class with the user's bank account class to access and modify the account balance.
// 6. Validate user input to ensure it is within acceptable limits (e.g., sufficient balance for withdrawals).
// 7. Display appropriate messages to the user based on their chosen options and the success or failure of their transactions.
import java.util.Map;
import java.util.Scanner;

class Data {

    Map<String, String> userDet = new HashMap<>();
    Map<String, Integer> details = new HashMap<>();

    void exit() {
        System.exit(0);
    }
}

class BankAccount extends Data {

    void AddUser(String UserID, String Username) {
        if (details.containsKey(UserID)) {
            System.out.println("UserID already Exists! Try different UserID.");
        } else {
            userDet.put(UserID, Username);
            details.put(UserID, 0);
        }
    }

    void UserDetails(String id) {
        System.out.println("Customer ID : " + id + "\nCustomer Name : " + userDet.get(id) + "\nBalance :" + details.get(id));
    }

    boolean validate(String uid) {
        return userDet.containsKey(uid);
    }
}

class ATM extends BankAccount {

    int Balance(String userid) {
        int Amount = details.get(userid);
        System.out.print("\nBalance : " + Amount);
        return Amount;
    }

    int Withdraw(String userid, int WA) {
        int Amount = details.get(userid);
        if (Amount < WA) {
            System.out.println("Insufficient Account Balance!");
        } else {
            Amount -= WA;
            details.put(userid, Amount);
            Amount = details.get(userid);
        }
        System.out.print("\nBalance : " + Amount);
        return Amount;
    }

    int Deposit(String userid, int DA) {
        int Amount = details.get(userid);
        Amount += DA;
        details.put(userid, Amount);
        Amount = details.get(userid);
        System.out.print("\nBalance : " + Amount);
        return Amount;
    }
}

public class task3 {

    ATM acc = new ATM();
    Scanner sc = new Scanner(System.in);

    void newuser() {
        System.out.print("\nEnter new userID : ");
        String uid = sc.next();
        System.out.print("\nEnter your fullname : ");
        String uname = sc.next();
        acc.AddUser(uid, uname);
        existinguser(uid);
    }

    void existinguser(String uid) {
        if (!acc.validate(uid)) {
            newuser();
        }
        System.out.println("\nPress :\n1 - Account Details | 2 - Balance | 3 - Deposit | 4 - Withdraw | 5 - Exit");
        int num = sc.nextInt();
        switch (num) {
            case 1: {
                acc.UserDetails(uid);
                existinguser(uid);

            }
            case 2: {
                acc.Balance(uid);
                existinguser(uid);
            }
            case 3: {
                System.out.print("Insert Cash : ");
                int amount = sc.nextInt();
                acc.Deposit(uid, amount);
                existinguser(uid);
            }
            case 4: {
                System.out.print("Enter Amount to Withdraw : ");
                int amount = sc.nextInt();
                acc.Withdraw(uid, amount);
                existinguser(uid);
            }
            case 5: {
                Data d = new Data();
                d.exit();
            }
            default: {
                System.out.println("Invalid Option!\n");
                existinguser(uid);
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nPress 'n' for new User and 'e' for existing user : ");
        String inp = sc.next();

        task3 t = new task3();
        if (inp.equals("n")) {
            t.newuser();
        } else if (inp.equals("e")) {
            System.out.print("Enter your UserID : ");
            String uid = sc.next();
            t.existinguser(uid);
        } else {
            Data d = new Data();
            d.exit();
        }
    }
}
