package loginapp;

public class Message {

    private String messageID;
    private int numMessagesSent;
    private String recipient;
    private String message;
    private String messageHash;
    
    // Part 3 Arrays

private static String[] sentMessages = new String[100];
private static String[] disregardedMessages = new String[100];
private static String[] storedMessages = new String[100];
private static String[] messageHashes = new String[100];
private static String[] messageIDs = new String[100];
private static String[] recipients = new String[100];

private static int sentCount = 0;
private static int disregardedCount = 0;
private static int storedCount = 0;
private static int totalCount = 0;

    public Message(String messageID, int numMessagesSent, String recipient, String message) {

        this.messageID = messageID;
        this.numMessagesSent = numMessagesSent;
        this.recipient = recipient;
        this.message = message;

    }
    
        public boolean checkMessageID() {
        return messageID.length() == 10;
        
    }
       
public boolean checkRecipientCell() {

    return recipient.startsWith("+27")
            && recipient.length() <= 12;

    }

public String createMessageHash() {

    String[] words = message.split(" ");

    String firstWord = words[0].toUpperCase();
    String lastWord = words[words.length - 1].toUpperCase();

    messageHash = messageID.substring(0, 2)
            + ":" + numMessagesSent
            + ":" + firstWord + lastWord;

    return messageHash;

    }

public String checkMessageLength() {

    if (message.length() <= 250) {
        return "Message ready to send.";
    } else {
        int extraCharacters = message.length() - 250;
        return "Message exceeds 250 characters by "
                + extraCharacters
                + ", please reduce the size.";
    }
}

public String sentMessage(int option) {

    if (option == 1) {
        return "Message successfully sent.";
    } else if (option == 2) {
        return "Press 0 to delete message.";
    } else if (option == 3) {
        return "Message successfully stored.";
    } else {
        return "Invalid option.";
    }
}

public String printMessages() {

    return "Message ID: " + messageID
            + "\nMessage Hash: " + messageHash
            + "\nRecipient: " + recipient
            + "\nMessage: " + message;
}

public int returnTotalMessages() {

    return numMessagesSent;

}

public String storeMessage() {

    return "{"
            + "\"messageID\":\"" + messageID + "\","
            + "\"messageHash\":\"" + messageHash + "\","
            + "\"recipient\":\"" + recipient + "\","
            + "\"message\":\"" + message + "\""
            + "}";
}
}