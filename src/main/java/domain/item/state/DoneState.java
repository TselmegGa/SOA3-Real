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
        print("Cannot be set to To do phase");
        return false;
    }

    @Override
    public boolean doing() {
        print("Cannot be set to Doing phase");
        return false;
    }

    @Override
    public boolean readyForTesting() {
        item.setState(item.getReadyForTestingState());
        print("The tests have failed to meet de Definition of Done");
        return true;
    }

    @Override
    public boolean testing() {
        print("Cannot be set to Testing phase");
        return false;
    }

    @Override
    public boolean done() {
        print("Currently in Done phase");
        return false;
    }
    @Override
    public void print(String text) {
        logger.info(text);
    }
}
