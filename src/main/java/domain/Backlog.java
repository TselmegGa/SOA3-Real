package domain;

import java.util.ArrayList;
import java.util.List;

public class Backlog {
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
            System.out.println("An item must be in todoState");
            return false;
        }

    }

}
