package test;


import code.EmailAlreadyUsedException;
import code.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @BeforeEach
    public void setUp() {
        User.resetUsers();
    }

    //Test passed.
    @Test
    public void register() throws EmailAlreadyUsedException {
        User.register("second", "idk");
    }

    /*
    Testing if registering the same user twice throws appropriate exception.
    Test passed.
     */
    @Test()
    public void register1() throws EmailAlreadyUsedException {
        User.register("first", "idk");
        assertThrows(EmailAlreadyUsedException.class, () -> User.register("first", "idk"));
    }

    /*
    Testing if adding a friend updates both sets.
    Test passed.
    */
    @Test
    public void addFriend() throws EmailAlreadyUsedException, User.UserDoesNotExistException {
        User first = User.register("first", "idk");
        User second = User.register("second", "idk");

        first.addFriend("second");

        assertTrue(first.getFriends().contains(second));
        assertEquals(1, first.getFriends().size());
        assertTrue(second.getFriends().contains(first));
        assertEquals(1, second.getFriends().size());
    }

    /*
    Testing adding if adding a non-existent user throws appropriate exception.
    Test passed.
    */
    @Test
    public void addFriend1() throws EmailAlreadyUsedException {
        User first = User.register("first", "idk");

        assertThrows(User.UserDoesNotExistException.class, () -> first.addFriend("second"));

    }


    /*
    Testing if removing a friend after adding it leaves the set in original state.
    Test passed.
     */
    @Test
    public void removeFriend() throws EmailAlreadyUsedException, User.UserIsNotAFriendException, User.UserDoesNotExistException {
        User first = User.register("first", "idk");
        User second = User.register("second", "idk");

        first.addFriend("second");

        first.removeFriend("second");
        assertEquals(0, first.getFriends().size());
        assertFalse(first.getFriends().contains(second));
    }

    /*
    Testing if removing a user that is not a friend throws appropriate exception
    Test passed.
     */
    @Test
    public void removeFriend1() throws EmailAlreadyUsedException {
        User first = User.register("first", "idk");
        User second = User.register("second", "idk");
        assertThrows(User.UserIsNotAFriendException.class, () -> first.removeFriend("second"));
    }

    /*
    Testing if removing a non-existing user throws appropriate exception
    Test passed.
     */
    @Test
    public void removeFriend2() throws EmailAlreadyUsedException {
        User first = User.register("first", "idk");
        assertThrows(User.UserDoesNotExistException.class, () -> first.removeFriend("second"));
    }

}