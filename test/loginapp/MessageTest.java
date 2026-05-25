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