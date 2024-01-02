package test;

import code.Group;
import code.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class GroupTest {
    Group group;
    User user;
    @BeforeEach
    void setUp() {
        user = new User("email", "password");
        group = new Group("name1", user);
    }

    // check if set representing members of a group is initialized properly
    // and if owner of the group is automatically added to members
    @Test
    void getMembers() {
        Set<User> userSet = group.getMembers();
        assertNotNull(userSet);
        assertTrue(userSet.contains(user));
    }

    // check if getting date returns date properly
    @Test
    void getDate() {
        assertEquals(group.getDate().getClass(), Date.class);
    }

    // check if getting name works
    @Test
    void getName() {
        assertEquals(group.getName(), "name1");
    }

    @Test
    void deleteInactiveGroups() {
        // TODO
    }

    @Test
    void addToGroup() {
        // TODO
    }

    @Test
    void removeFromGroup() {
        // TODO
    }

    @Test
    void getGroups() {
        // TODO
    }

    @Test
    void getArchivedGroups() {
        // TODO
    }
}