package code;

import java.util.HashMap;
import java.util.Map;

public class VerifiedPerson {

    private String email;
    private String password;
    static Map<String, VerifiedPerson> verifiedPeople = new HashMap<>();

    public VerifiedPerson(String email, String password) {
        this.email = email;
        this.password = password;
    }


    /**
     * Allows checking if password is correct
     * @param password Password to be checked
     * @return Whether the password is correct
     */
    public boolean isValid(String password){
        return this.password.equals(password);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static Map<String, VerifiedPerson> getVerifiedPeople() {
        return verifiedPeople;
    }
}
