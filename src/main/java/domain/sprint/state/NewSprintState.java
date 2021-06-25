package domain.sprint.state;

import domain.Sprint;
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
        sprint.setState(sprint.annulledState);
        logger.info("The sprint has been annulled");
    }

    @Override
    public void running() {
        sprint.setState(sprint.runningState);
        logger.info("The sprint has been started");
    }
}
