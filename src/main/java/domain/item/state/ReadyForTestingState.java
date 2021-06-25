package domain.item.state;

import domain.Item;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ReadyForTestingState implements IPhaseState {
    private static final Logger logger = LogManager.getLogger(ReadyForTestingState.class);
    private Item item;
    public ReadyForTestingState(Item item) {
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
        logger.info("Currently in Ready for testing phase");
        return false;
    }

    @Override
    public boolean testing() {
        item.setState(item.getTestingState());
        logger.info("The item has started testing");
        return true;
    }

    @Override
    public boolean done() {
        logger.info("The item must be tested first");
        return false;
    }
}
