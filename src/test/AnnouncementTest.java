package test;

import code.Announcement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AnnouncementTest {
    Announcement announcement;
    Date date;
    @BeforeEach
    void setUp() {
        announcement = new Announcement(
                "testTitle", date = new Date(), "testContent");
    }

    // check if getting title works
    @Test
    void getTitle() {
        assertEquals(announcement.getTitle(), "testTitle");
    }

    // check if getting date returns date properly
    @Test
    void getExpiryDate() {
        assertEquals(announcement.getExpiryDate(), date);
    }

    // check if getting content of the announcement works
    @Test
    void getContent() {
        assertEquals(announcement.getContent(), "testContent");
    }

    @Test
    void postAnnouncement() {
        // TODO
    }

    @Test
    void removeInactiveAnnouncements() {
        // TODO
    }

    @Test
    void readAnnouncements() {
        // TODO
    }

}