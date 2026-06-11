package loginapp;

import java.util.Scanner;
import java.util.ArrayList;

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
    int totalMessages = 0;
    ArrayList<Message> sentMessages = new ArrayList<>();

    while (choice != 4) {

        System.out.println("\nPlease choose an option:");
        System.out.println("1. Send Messages");
        System.out.println("2. Show recently sent messages");
        System.out.println("3. Stored Messages");
        System.out.println("4. Quit");

        choice = input.nextInt();
        input.nextLine();

        if (choice == 1) {
            
        System.out.print("Enter recipient number: ");
String recipient = input.nextLine();

System.out.print("Enter your message: ");
String messageText = input.nextLine();

String messageID = String.valueOf((int)
        (Math.random() * 1000000000));

while (messageID.length() < 10) {
    messageID = "0" + messageID;
}

Message msg = new Message(messageID,
        totalMessages + 1,
        recipient,
        messageText);

System.out.println(msg.checkMessageLength());

if (msg.checkRecipientCell()
        && msg.checkMessageID()
        && messageText.length() <= 250) {

    System.out.println("Cell phone number successfully captured.");

    System.out.println("Message Hash: "
            + msg.createMessageHash());

    System.out.println("\nChoose an option:");
    System.out.println("1. Send Message");
    System.out.println("2. Discard Message");
    System.out.println("3. Store Message");

    int sendChoice = input.nextInt();
    input.nextLine();

    System.out.println(msg.sentMessage(sendChoice));

    if (sendChoice == 1) {

    totalMessages++;
    sentMessages.add(msg);

    System.out.println(msg.printMessages());

    System.out.println("Total messages sent: "
            + totalMessages);

} else if (sendChoice == 3) {

    System.out.println(msg.storeMessage());
    
    }

} else {

    System.out.println(
            "Cell phone number is incorrectly formatted "
            + "or message ID invalid.");

}

 } else if (choice == 2) {

    System.out.println("Coming Soon.");

} else if (choice == 3) {

    System.out.println("\nStored Messages Menu");
    System.out.println("1. Display stored messages");
    System.out.println("2. Display longest message");
    System.out.println("3. Search by message ID");
    System.out.println("4. Search by recipient");
    System.out.println("5. Delete by message hash");
    System.out.println("6. Display report");

    int storedChoice = input.nextInt();
    input.nextLine();

    if (storedChoice == 1) {
        System.out.println(Message.displayStoredMessages());

    } else if (storedChoice == 2) {
        System.out.println(Message.displayLongestMessage());

    } else if (storedChoice == 3) {
        System.out.print("Enter message ID: ");
        String searchID = input.nextLine();
        System.out.println(Message.searchByMessageID(searchID));

    } else if (storedChoice == 4) {
        System.out.print("Enter recipient: ");
        String searchRecipient = input.nextLine();
        System.out.println(Message.searchByRecipient(searchRecipient));

    } else if (storedChoice == 5) {
        System.out.print("Enter message hash: ");
        String searchHash = input.nextLine();
        System.out.println(Message.deleteByHash(searchHash));

    } else if (storedChoice == 6) {
        System.out.println(Message.displayReport());

    } else {
        System.out.println("Invalid stored message option.");
    }

} else if (choice == 4) {

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


        
        
   
            
