package domain.sprint.state;

import domain.behavior.DeploymentReviewBehavior;
import domain.behavior.NormalReviewBehavior;
import domain.notification.observer.BasicNotificationSubject;
import domain.notification.observer.Message;
import domain.Sprint;

public class FinishedState extends SprintState  {
    private BasicNotificationSubject notificationSubject = new BasicNotificationSubject();
    private Sprint sprint;
    public FinishedState(Sprint sprint) {
        this.sprint = sprint;
    }

    @Override
    public void annulled() {
        sprint.setState(sprint.annulledState);
        System.out.println("The sprint has been annulled and there will be no meeting with the product owner");
        sprint.onFinish(new NormalReviewBehavior());
    }
    @Override
    public void released() {
        sprint.setState(sprint.releasedState);
        notificationSubject.registerNotificationObserver(sprint.getProject().getProductOwners());
        notificationSubject.registerNotificationObserver(sprint.getProject().getScrumMasters());
        notificationSubject.notifyNotificationObserver(new Message("", ""));
        System.out.println("The sprint has been released and there will be meeting with the product owner");
        sprint.onFinish(new DeploymentReviewBehavior());
    }

}
