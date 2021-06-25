package Domain.State;

import Domain.Item;
import Domain.NotificationObserver.BasicNotificationSubject;
import Domain.NotificationObserver.Message;

public class DoingState extends BasicNotificationSubject implements IPhaseState  {

    private Item item;
    public DoingState(Item item) {
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
        System.out.println("Currently in Doing phase");
        return false;
    }

    @Override
    public boolean readyForTesting() {
        item.setState(item.readyForTestingState);
        registerNotificationObserver(item.getTesters());
        notifyNotificationObserver(new Message(item.getTitle() + " is now ready for testing!", item.getDescription() +  " - Is not ready for testing."));
        System.out.println("The item has been moved to Ready for testing phase");
        return true;
        //Send notification
    }

    @Override
    public boolean testing() {
        System.out.println("Must be in ready for testing phase first");
        return false;
    }

    @Override
    public boolean done() {
        System.out.println("Must be in ready for testing phase first");
        return false;
    }
}
