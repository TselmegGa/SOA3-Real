package domain.item.state;

import domain.Item;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class TestingState implements IPhaseState {
    private static final Logger logger = LogManager.getLogger(TestingState.class);
    private Item item;
    public TestingState(Item item) {
        this.item = item;
    }
    @Override
    public boolean todo() {
        item.setState(item.getTodoState());
        logger.info("The item has been moved to To do phase");
        return true;
    }

    @Override
    public boolean doing() {
        logger.info("Cannot be set to Doing phase");
        return false;
    }

    @Override
    public boolean readyForTesting() {
        logger.info("Cannot be set to Ready for testing phase");
        return false;
    }

    @Override
    public boolean testing() {
        logger.info("Currently in Testing phase");
        return false;
    }

    @Override
    public boolean done() {
        item.setState(item.getDoneState());
        logger.info("The item has been tested");
        return true;
    }
}
