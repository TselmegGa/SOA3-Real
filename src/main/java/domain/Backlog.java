package domain;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Backlog {
    private static final Logger logger = LogManager.getLogger(Backlog.class);
    private List<Item> items;

    public Backlog() {
        this.items =  new ArrayList<>();
    }

    public List<Item> getItems() {
        return items;
    }

    public boolean addItem(Item item) {
        if(item.checkTodo()){
            this.items.add(item);
            return true;
        }
        else{
            logger.info("An item must be in todoState");
            return false;
        }

    }

}
