package Domain.State;

import Domain.Item;

public class TodoState implements IPhaseState {
    private Item item;
    public TodoState(Item item) {
        this.item = item;
    }

    @Override
    public boolean todo() {
        System.out.println("Currently in to do phase");
        return false;
    }

    @Override
    public boolean doing() {
        if(item.hasUser() || item.hasActivities()){
            item.setState(item.doingState);
            System.out.println("The item has been moved to Doing phase");
            return true;
        }
        else{
            System.out.println("Need user or activities");
            return false;
        }
    }

    @Override
    public boolean readyForTesting() {
        System.out.println("Must be worked on first");
        return false;
    }

    @Override
    public boolean testing() {
        System.out.println("Must be worked on first");
        return false;
    }

    @Override
    public boolean done() {
        System.out.println("Must be worked on first");
        return false;
    }
}
