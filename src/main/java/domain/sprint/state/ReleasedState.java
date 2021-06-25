package domain.sprint.state;

import domain.Sprint;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ReleasedState extends SprintState {
    private static final Logger logger = LogManager.getLogger(ReleasedState.class);
    private Sprint sprint;
    public ReleasedState(Sprint sprint) {
        this.sprint = sprint;
    }

    @Override
    public void closed() {
        sprint.setState(sprint.getClosedState());
        logger.info("The sprint has been closed");
    }

}
