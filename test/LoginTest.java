package loginapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    @Test
    public void testValidUsername() {
        Login user = new Login("k_yl1", "Password@1", "+27683712918");
        assertTrue(user.checkUserName());
    }

    @Test
    public void testInvalidUsername() {
        Login user = new Login("kyle", "Password@1", "+27683712918");
        assertFalse(user.checkUserName());
    }

    @Test
    public void testValidPassword() {
        Login user = new Login("k_yl1", "Password@1", "+27683712918");
        assertTrue(user.checkPasswordComplexity());
    }

    @Test
    public void testInvalidPassword() {
        Login user = new Login("k_yl1", "password", "+27683712918");
        assertFalse(user.checkPasswordComplexity());
    }

    @Test
    public void testValidPhone() {
        Login user = new Login("k_yl1", "Password@1", "+27683712918");
        assertTrue(user.checkCellPhoneNumber());
    }

    @Test
    public void testInvalidPhone() {
        Login user = new Login("k_yl1", "Password@1", "0683712918");
        assertFalse(user.checkCellPhoneNumber());
    }

    @Test
    public void testLoginSuccess() {
        Login user = new Login("k_yl1", "Password@1", "+27683712918");
        assertTrue(user.loginUser("k_yl1", "Password@1"));
    }

    @Test
    public void testLoginFail() {
        Login user = new Login("k_yl1", "Password@1", "+27683712918");
        assertFalse(user.loginUser("wrong", "wrong"));
    }
}