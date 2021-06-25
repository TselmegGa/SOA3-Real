package domain.sprint.state;

import domain.Sprint;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class RunningState extends SprintState {
    private static final Logger logger = LogManager.getLogger(RunningState.class);
    private Sprint sprint;
    public RunningState(Sprint sprint) {
        this.sprint = sprint;
    }

    @Override
    public void annulled() {
        logger.info("The sprint cannot be annulled while running");
    }



    @Override
    public void finished() {
        sprint.setState(sprint.finishedState);
        logger.info("The sprint has been finished");
    }

}
