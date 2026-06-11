package loginapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class MessageTest {

    public MessageTest() {

    }

    @Test
    public void testCheckMessageID() {

        Message msg = new Message(
                "1234567890",
                1,
                "+27718693002",
                "Hi Mike tonight"
        );

        assertTrue(msg.checkMessageID());

    }

    @Test
    public void testCheckRecipientCell() {

        Message msg = new Message(
                "1234567890",
                1,
                "+27718693002",
                "Hello there"
        );

        assertTrue(msg.checkRecipientCell());

    }

    @Test
    public void testCreateMessageHash() {

        Message msg = new Message(
                "0012345678",
                1,
                "+27718693002",
                "Hi Mike tonight"
        );

        String expected = "00:1:HITONIGHT";

        assertEquals(expected, msg.createMessageHash());

    }

    @Test
    public void testCheckMessageLength() {

        Message msg = new Message(
                "1234567890",
                1,
                "+27718693002",
                "Hello"
        );

        String expected = "Message ready to send.";

        assertEquals(expected, msg.checkMessageLength());

    }

}

@Test
public void testDisplayLongestMessage() {

    Message.addMessage(
            "1111111111",
            "11:1:TESTMESSAGE",
            "+27838884567",
            "Where are you? You are late! I have asked you to be on time.",
            "Stored");

    String expected =
            "Where are you? You are late! I have asked you to be on time.";

    assertEquals(expected, Message.displayLongestMessage());
    
}

@Test
public void testSearchByRecipient() {

    Message.addMessage(
            "2222222222",
            "22:1:TESTMESSAGE",
            "+27838884567",
            "Ok, I am leaving without you.",
            "Stored");

    String result =
            Message.searchByRecipient("+27838884567");

    assertTrue(result.contains("Ok, I am leaving without you."));
    
}

@Test
public void testDeleteByHash() {

    Message.addMessage(
            "3333333333",
            "33:1:TESTMESSAGE",
            "+27838884567",
            "Delete me",
            "Stored");

    String result =
            Message.deleteByHash("33:1:TESTMESSAGE");

    assertTrue(result.contains("successfully deleted"));
    
}