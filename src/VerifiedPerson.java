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

}
