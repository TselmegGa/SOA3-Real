package domain.item.state;

import domain.Item;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class TodoState implements IPhaseState {
    private static final Logger logger = LogManager.getLogger(TodoState.class);
    private Item item;
    public TodoState(Item item) {
        this.item = item;
    }

    @Override
    public boolean todo() {
        print("Currently in to do phase");
        return false;
    }

    @Override
    public boolean doing() {
        if(item.hasUser() || item.hasActivities()){
            item.setState(item.getDoingState());
            print("The item has been moved to Doing phase");
            return true;
        }
        else{
            print("Need user or activities");
            return false;
        }
    }

    @Override
    public boolean readyForTesting() {
        print("Cannot be set to Ready for Testing phase");
        return false;
    }

    @Override
    public boolean testing() {
        print("Cannot be set to Testing phase");
        return false;
    }

    @Override
    public boolean done() {
        print("Cannot be set to Done phase");
        return false;
    }
    @Override
    public void print(String text) {
        logger.info(text);
    }
}
