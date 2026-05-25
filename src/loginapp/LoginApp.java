package loginapp;

import java.util.Scanner;

public class LoginApp {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // This class handles user registration and login validation
        System.out.println("=== REGISTRATION ===");

        System.out.print("Enter first name: ");
        String firstName = input.nextLine();

        System.out.print("Enter last name: ");
        String lastName = input.nextLine();

        System.out.print("Enter username: ");
        String username = input.nextLine();

        System.out.print("Enter password: ");
        String password = input.nextLine();

        System.out.print("Enter phone number (+27...): ");
        String phone = input.nextLine();

        Login user = new Login(username, password, phone);

        String result = user.registerUser();
        System.out.println(result);

        // Only allow login if registration was successful
        if (result.equals("User has been registered successfully.")) {
            System.out.println("\n=== LOGIN ===");

            System.out.print("Enter username: ");
            String loginUsername = input.nextLine();

            System.out.print("Enter password: ");
            String loginPassword = input.nextLine();

            boolean status = user.loginUser(loginUsername, loginPassword);
            System.out.println(user.returnLoginStatus(status, firstName, lastName));
        
            if (status == true) {

    System.out.println("\nWelcome to QuickChat.");

    int choice = 0;

    while (choice != 3) {

        System.out.println("\nPlease choose an option:");
        System.out.println("1. Send Messages");
        System.out.println("2. Show recently sent messages");
        System.out.println("3. Quit");

        choice = input.nextInt();
        input.nextLine();

        if (choice == 1) {
            System.out.println("Send Messages selected.");
        } else if (choice == 2) {
            System.out.println("Coming Soon.");
        } else if (choice == 3) {
            System.out.println("Goodbye.");
        } else {
            System.out.println("Invalid option. Please try again.");
        }
        }      
        }    
        }
        input.close();
       
            }
        }
        
        
   
            
