package domain.sprint.state;

import domain.Sprint;
import domain.behavior.NormalReviewBehavior;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class NewSprintState extends SprintState {
    private static final Logger logger = LogManager.getLogger(NewSprintState.class);
    private Sprint sprint;
    public NewSprintState(Sprint sprint) {
        this.sprint = sprint;
    }

    @Override
    public void annulled() {
        sprint.setState(sprint.getAnnulledState());
        logger.info("The sprint has been annulled");
        sprint.onFinish(new NormalReviewBehavior());
    }

    @Override
    public void running() {
        sprint.setState(sprint.getReleasedState());
        logger.info("The sprint has been started");
    }
}
