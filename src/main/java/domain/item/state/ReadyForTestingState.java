package domain.item.state;

import domain.Item;

public class ReadyForTestingState implements IPhaseState {

    private Item item;
    public ReadyForTestingState(Item item) {
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
        System.out.println("Currently in Ready for testing phase");
        return false;
    }

    @Override
    public boolean testing() {
        item.setState(item.testingState);
        System.out.println("The item has started testing");
        return true;
    }

    @Override
    public boolean done() {
        System.out.println("The item must be tested first");
        return false;
    }
}
