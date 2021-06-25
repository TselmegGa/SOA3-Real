import domain.*;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SprintTest {
    @Test
    void sprintTest(){
        Project project = new Project();
        Instant start = Instant.now();
        Instant end = Instant.now();
        Item item = new Item(4, project, "Shopping page");
        Item item2 = new Item(5, project, "Shopping page");
        end = end.plusMillis(10000);
        ArrayList<Item> items = new ArrayList<>();
        items.add(item);
        ZoneId centralEuropianTime = ZoneId.of("CET");
        ZonedDateTime startTime = ZonedDateTime.ofInstant(start, centralEuropianTime);
        ZonedDateTime endTime = ZonedDateTime.ofInstant(end, centralEuropianTime);
        Sprint sprint = new Sprint(startTime, endTime, items,project);
        Rapport rapport = new Rapport("Very good sprint");
        rapport.setHeader("MyCompany");
        rapport.setFooter("About");
        sprint.setSummery("Sprint went well");
        sprint.setRapport(rapport);
        sprint.addItem(item2);
        sprint.removeItem(item2);

        String result = sprint.getRapport().getRapport();

        assertEquals("Sprint went well", sprint.getSummery());
        assertEquals(rapport.getRapport(), result);
        assertEquals(sprint.getItems().get(0), item);
    }
    @Test
    void sprintRunningTest() {
        Instant start = Instant.now();
        Instant end = Instant.now();
        Project project = new Project();
        Item item = new Item(4,project, "Shopping page");
        end = end.plusMillis(1000);
        ArrayList<Item> items = new ArrayList<>();
        items.add(item);
        ZoneId centralEuropianTime = ZoneId.of("CET");
        ZonedDateTime startTime = ZonedDateTime.ofInstant(start, centralEuropianTime);
        ZonedDateTime endTime = ZonedDateTime.ofInstant(end, centralEuropianTime);
        Sprint sprint = new Sprint(startTime, endTime, items, project);
        sprint.run();
            try
            {
                System.out.println("The sprint is still running");
                assertTrue(sprint.timeRunning());
                Thread.sleep(2000);


            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
        assertFalse(sprint.timeRunning());
    }
}
