import Domain.*;
import Domain.Templates.DotNetPipeline;
import Domain.Templates.PipelineTemplate;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BacklogTest {
    @Test
    void backlogTest(){
        Project project = new Project();
        Backlog backlog = new Backlog();
        Item item = new Item(4, project,"Home page");
        boolean result = backlog.addItem(item);

        assertTrue(result);
        assertTrue(backlog.getItems().get(backlog.getItems().size()-1) == item);
    }
    @Test
    void addingFaultyItemToBacklogShouldFail(){
        Project project = new Project();
        Backlog backlog = new Backlog();
        User bob = new User();
        Item item = new Item(4, project,"Home page");
        item.setUser(bob);
        item.start();

        boolean result = backlog.addItem(item);

        assertFalse(result);
        assertTrue(backlog.getItems().isEmpty());
    }
}
