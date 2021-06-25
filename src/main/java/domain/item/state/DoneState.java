package domain.item.state;

import domain.Item;

public class DoneState implements IPhaseState {
    private Item item;
    public DoneState(Item item) {
        this.item = item;
    }
    @Override
    public boolean todo() {
        System.out.println("Cannot be set to To do phase");
        return false;
    }

    @Override
    public boolean doing() {
        System.out.println("Cannot be set to Doing phase");
        return false;
    }

    @Override
    public boolean readyForTesting() {
        item.setState(item.readyForTestingState);
        System.out.println("The tests have failed to meet de Definition of Done");
        return true;
    }

    @Override
    public boolean testing() {
        System.out.println("Cannot be set to Testing phase");
        return false;
    }

    @Override
    public boolean done() {
        System.out.println("Currently in Done phase");
        return false;
    }
}
