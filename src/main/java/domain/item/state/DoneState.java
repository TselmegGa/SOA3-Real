package domain.item.state;


import domain.Item;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class DoneState implements IPhaseState {
    private static final Logger logger = LogManager.getLogger(DoneState.class);
    private Item item;
    public DoneState(Item item) {
        this.item = item;
    }
    @Override
    public boolean todo() {
        logger.info("Cannot be set to To do phase");
        return false;
    }

    @Override
    public boolean doing() {
        logger.info("Cannot be set to Doing phase");
        return false;
    }

    @Override
    public boolean readyForTesting() {
        item.setState(item.getReadyForTestingState());
        logger.info("The tests have failed to meet de Definition of Done");
        return true;
    }

    @Override
    public boolean testing() {
        logger.info("Cannot be set to Testing phase");
        return false;
    }

    @Override
    public boolean done() {
        logger.info("Currently in Done phase");
        return false;
    }
}
