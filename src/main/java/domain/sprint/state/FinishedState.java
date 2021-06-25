package domain.sprint.state;

import domain.behavior.DeploymentReviewBehavior;
import domain.behavior.NormalReviewBehavior;
import domain.notification.observer.BasicNotificationSubject;
import domain.notification.observer.Message;
import domain.Sprint;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class FinishedState extends SprintState  {
    private static final Logger logger = LogManager.getLogger(FinishedState.class);
    private BasicNotificationSubject notificationSubject = new BasicNotificationSubject();
    private Sprint sprint;
    public FinishedState(Sprint sprint) {
        this.sprint = sprint;
    }

    @Override
    public void annulled() {
        sprint.setState(sprint.getAnnulledState());
        logger.info("The sprint has been annulled and there will be no meeting with the product owner");
        sprint.onFinish(new NormalReviewBehavior());
    }
    @Override
    public void released() {
        sprint.setState(sprint.getReleasedState());
        notificationSubject.registerNotificationObserver(sprint.getProject().getProductOwners());
        notificationSubject.registerNotificationObserver(sprint.getProject().getScrumMasters());
        notificationSubject.notifyNotificationObserver(new Message("", ""));
        logger.info("The sprint has been released and there will be meeting with the product owner");
        sprint.onFinish(new DeploymentReviewBehavior());
    }

}
