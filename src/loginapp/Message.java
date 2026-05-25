package loginapp;

public class Message {

    private String messageID;
    private int numMessagesSent;
    private String recipient;
    private String message;
    private String messageHash;

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
}