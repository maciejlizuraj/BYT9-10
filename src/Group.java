import java.util.*;

public class Group {

    private String name;
    private Date date;
    private Set<User> members;
    private static Set<Group> groups;
    private static Set<Group> archivedGroups;

    /**
     * Default constructor for a group
     * @param name Name of a group
     * @param user User who initiated the group
     */
    public Group(String name, User user) {
        this.name = name;
        this.date = Calendar.getInstance().getTime();
        members = new HashSet<>();
        members.add(user);
        groups.add(this);
    }

    /**
     * Allows deleting groups who were created after a given date
     * @param expiryDate If a group's date is later than this, the group will be deleted
     */
    public static void deleteInactiveGroups(Date expiryDate){
        for (Group group: groups){
            if (group.getDate().after(expiryDate)){
                groups.remove(group);
                archivedGroups.add(group);
            }
        }
    }

    /**
     * Allows adding a user to a group
     * @param user User to be added
     * @throws UserAlreadyInGroup Thrown if user is already in this group
     */
    public void addToGroup(User user) throws UserAlreadyInGroup {
        if (members.contains(user)){
            throw new UserAlreadyInGroup();
        }
        members.add(user);
    }

    /**
     * Allows removing a user from a group
     * @param user User to be deleted
     * @throws UserNotInGroup Thrown if user is not present in this group
     */
    public void removeFromGroup(User user) throws UserNotInGroup{
        if (!members.contains(user)){
            throw new UserNotInGroup();
        }
        members.remove(user);
    }

    public Date getDate() {
        return date;
    }

    public static Set<Group> getGroups() {
        return groups;
    }

    public static Set<Group> getArchivedGroups() {
        return archivedGroups;
    }
}
