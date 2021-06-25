package domain.item.state;

import domain.Item;

public class TestingState implements IPhaseState {

    private Item item;
    public TestingState(Item item) {
        this.item = item;
    }
    @Override
    public boolean todo() {
        item.setState(item.todoState);
        System.out.println("The item has been moved to To do phase");
        return true;
    }

    @Override
    public boolean doing() {
        System.out.println("Cannot be set to Doing phase");
        return false;
    }

    @Override
    public boolean readyForTesting() {
        System.out.println("Cannot be set to Ready for testing phase");
        return false;
    }

    @Override
    public boolean testing() {
        System.out.println("Currently in Testing phase");
        return false;
    }

    @Override
    public boolean done() {
        item.setState(item.doneState);
        System.out.println("The item has been tested");
        return true;
    }
}
