package domain.item.state;

import domain.Item;
import domain.notification.observer.BasicNotificationSubject;
import domain.notification.observer.Message;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class DoingState extends BasicNotificationSubject implements IPhaseState  {
    private static final Logger logger = LogManager.getLogger(DoingState.class);
    private Item item;
    public DoingState(Item item) {
        this.item = item;

    }
    @Override
    public boolean todo() {
        item.setState(item.getTodoState());
        print("The item has been moved to To do phase");
        return true;
    }

    @Override
    public boolean doing() {
        print("Currently in Doing phase");
        return false;
    }

    @Override
    public boolean readyForTesting() {
        item.setState(item.getReadyForTestingState());
        registerNotificationObserver(item.getTesters());
        notifyNotificationObserver(new Message(item.getTitle() + " is now ready for testing!", item.getDescription() +  " - Is not ready for testing."));
        print("The item has been moved to Ready for testing phase");
        return true;
        //Send notification
    }

    @Override
    public boolean testing() {
        print("This is the testing phase");
        return false;
    }

    @Override
    public boolean done() {
        print("Must be in ready for testing phase first");
        return false;
    }

    @Override
    public void print(String text) {
        logger.info(text);
    }
}
