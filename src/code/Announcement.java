package code;

import java.util.*;

public class Announcement {
    String title;
    Date expiryDate;
    String content;
    static Map<Restaurant, Set<Announcement>> announcements = new HashMap<>();

    public Announcement(String title, Date expiryDate, String content) {
        this.title = title;
        this.expiryDate = expiryDate;
        this.content = content;
    }

    static Set<Announcement> readAnnouncements(Restaurant restaurant){
        return announcements.get(restaurant);
    }

    static void postAnnouncement(String title, Date expiryDate, String content, Restaurant restaurant){
        Announcement announcement = new Announcement(title, expiryDate, content);
        Set<Announcement> announcementSet = announcements.computeIfAbsent(restaurant, k -> new HashSet<>());
        announcementSet.add(announcement);
        announcements.put(restaurant, announcementSet);
    }

    /**
     * Checks all announcements and removes those past expiry date
     * @return boolean value whether any announcements have been removed
     */
    static boolean removeInactiveAnnouncements(){
        return true;
    }

    public String getTitle() {
        return title;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public String getContent() {
        return content;
    }

    public static Map<Restaurant, Set<Announcement>> getAnnouncements() {
        return announcements;
    }
}
