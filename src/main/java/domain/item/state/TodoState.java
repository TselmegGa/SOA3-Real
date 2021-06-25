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
        logger.info("Currently in to do phase");
        return false;
    }

    @Override
    public boolean doing() {
        if(item.hasUser() || item.hasActivities()){
            item.setState(item.getDoingState());
            logger.info("The item has been moved to Doing phase");
            return true;
        }
        else{
            logger.info("Need user or activities");
            return false;
        }
    }

    @Override
    public boolean readyForTesting() {
        logger.info("Must be worked on first");
        return false;
    }

    @Override
    public boolean testing() {
        logger.info("Must be worked on first");
        return false;
    }

    @Override
    public boolean done() {
        logger.info("Must be worked on first");
        return false;
    }
}
