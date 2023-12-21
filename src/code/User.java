package code;

import java.util.*;

public class User extends VerifiedPerson {

    static HashMap<String, User> users = new HashMap<>();

    Set<Allergen> allergens;
    Set<User> friends;

    /**
     * Default constructor for a user
     * @param email Email of the user
     * @param password Password of the user
     */
    public User(String email, String password) {
        super(email, password);
        allergens = new HashSet<>();
        friends = new HashSet<>();
    }

    /**
     * Allows registering a user
     * @param email Email of the user
     * @param password Password of the user
     * @throws EmailAlreadyUsedException Thrown if Email is already in use for a user
     */
    static public void register(String email, String password) throws EmailAlreadyUsedException {
        if (users.containsKey(email)) {
            throw new EmailAlreadyUsedException();
        }
        User user = new User(email, password);
        users.put(email, user);
    }

    /**
     * Allows adding a friend to user's friend set. Both users end up in their friend sets
     * @param friendEmail Email of a user who is supposed to be added as a friend
     * @throws UserDoesNotExist Thrown if a user with that email does not exist
     */
    public void addFriend(String friendEmail) throws UserDoesNotExist {
        if (!users.containsKey(friendEmail)) {
            throw new UserDoesNotExist();
        }
        User user = users.get(friendEmail);
        friends.add(user);
        user.addFriend(this);
    }

    /**
     * Private method for adding a friend
     * @param user code.User to be added
     */
    private void addFriend(User user) {
        this.friends.add(user);
    }

    /**
     * Allows removing a friend. Both users are removed from each other's sets
     * @param friendEmail Email of a user to be deleted from friend set.
     * @throws UserDoesNotExist Thrown if user does not exist
     * @throws UserIsNotAFriend Thrown if user is not a friend of a user from which they are supposed to be deleted
     */
    public void removeFriend(String friendEmail) throws UserDoesNotExist, UserIsNotAFriend {
        if (!users.containsKey(friendEmail)) {
            throw new UserDoesNotExist();
        }
        User user = users.get(friendEmail);
        if (!friends.contains(user)) {
            throw new UserIsNotAFriend();
        }
        user.removeFriend(this);
    }

    /**
     * Private method for removing a friend
     * @param user code.User to be deleted
     */
    public void removeFriend(User user) {
        this.friends.remove(user);
    }

    public static HashMap<String, User> getUsers() {
        return users;
    }

    public Set<Allergen> getAllergens() {
        return allergens;
    }

    public Set<User> getFriends() {
        return friends;
    }
}
