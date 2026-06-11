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

// Part 3 Method

public static void addMessage(String messageID,
        String messageHash,
        String recipient,
        String message,
        String status) {

    messageIDs[totalCount] = messageID;
    messageHashes[totalCount] = messageHash;
    recipients[totalCount] = recipient;

    if (status.equalsIgnoreCase("Sent")) {

        sentMessages[sentCount] = message;
        sentCount++;

    } else if (status.equalsIgnoreCase("Stored")) {

        storedMessages[storedCount] = message;
        storedCount++;

    } else if (status.equalsIgnoreCase("Disregard")) {

        disregardedMessages[disregardedCount] = message;
        disregardedCount++;
    }

    totalCount++;
}

public static String displayStoredMessages() {

    String output = "";

    for (int i = 0; i < storedCount; i++) {

        output += "Recipient: " + recipients[i] + "\n";
        output += "Message: " + storedMessages[i] + "\n\n";
    }

    return output;
}

public static String displayLongestMessage() {

    String longest = "";

    for (int i = 0; i < storedCount; i++) {

        if (storedMessages[i] != null
                && storedMessages[i].length() > longest.length()) {

            longest = storedMessages[i];
        }
    }

    return longest;
    
}

public static String searchByMessageID(String searchID) {

    for (int i = 0; i < totalCount; i++) {

        if (messageIDs[i] != null && messageIDs[i].equals(searchID)) {

            return "Recipient: " + recipients[i]
                    + "\nMessage: " + getMessageByIndex(i);
        }
    }

    return "Message ID not found.";
}

public static String searchByRecipient(String searchRecipient) {

    String output = "";

    for (int i = 0; i < totalCount; i++) {

        if (recipients[i] != null
                && recipients[i].equals(searchRecipient)) {

            output += getMessageByIndex(i) + "\n";
        }
    }

    if (output.equals("")) {

        return "No messages found for this recipient.";
    }

    return output;
    
}

public static String deleteByHash(String searchHash) {

    for (int i = 0; i < totalCount; i++) {

        if (messageHashes[i] != null
                && messageHashes[i].equals(searchHash)) {

            String deletedMessage = getMessageByIndex(i);

            messageIDs[i] = null;
            messageHashes[i] = null;
            recipients[i] = null;

            return "Message: \"" + deletedMessage
                    + "\" successfully deleted.";
        }
    }

    return "Message hash not found.";
    
}

public static String displayReport() {

    String output = "";

    for (int i = 0; i < totalCount; i++) {

        if (messageIDs[i] != null) {

            output += "Message ID: " + messageIDs[i] + "\n";
            output += "Message Hash: " + messageHashes[i] + "\n";
            output += "Recipient: " + recipients[i] + "\n";
            output += "Message: " + getMessageByIndex(i) + "\n\n";
        }
    }

    return output;
    
}

private static String getMessageByIndex(int index) {

    if (index < sentCount && sentMessages[index] != null) {
        return sentMessages[index];
    }

    if (index < storedCount && storedMessages[index] != null) {
        return storedMessages[index];
    }

    if (index < disregardedCount && disregardedMessages[index] != null) {
        return disregardedMessages[index];
    }

    return "";
}

}