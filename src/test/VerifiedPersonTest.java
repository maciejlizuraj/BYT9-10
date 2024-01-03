package test;

import code.VerifiedPerson;
import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class VerifiedPersonTest {

    @Test
    void constructorTest(){
        VerifiedPerson vp = new VerifiedPerson("test@example.com", "password");
        assertEquals("test@example.com", vp.getEmail());
        assertEquals("password", vp.getPassword());
    }

    @Test
    void isValid() {
        VerifiedPerson vp = new VerifiedPerson("test@example.com", "password");
        assertTrue(vp.isValid("password"));
        assertFalse(vp.isValid("invalid"));
    }

    @Test
    void getEmail() {
        VerifiedPerson vp = new VerifiedPerson("test@example.com", "password");
        assertEquals("test@example.com", vp.getEmail());
    }

    @Test
    void setEmail() {
        VerifiedPerson vp = new VerifiedPerson("initial@example.com", "password");
        vp.setEmail("updated@example.com");
        assertEquals("updated@example.com", vp.getEmail());
    }

    @Test
    void getPassword() {
        VerifiedPerson vp = new VerifiedPerson("test@example.com", "password");
        assertEquals("password", vp.getPassword());
    }

    @Test
    void setPassword() {
        VerifiedPerson vp = new VerifiedPerson("test@example.com", "initialPassword");
        vp.setPassword("updatedPassword");
        assertEquals("updatedPassword", vp.getPassword());
    }

}