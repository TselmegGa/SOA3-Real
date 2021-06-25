package domain.sprint.state;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public abstract class SprintState {
    private static final Logger logger = LogManager.getLogger(SprintState.class);

    public void annulled(){
        invalid();
    }
    public void closed(){
        invalid();
    }
    public void released(){
        invalid();
    }
    public void finished(){
        invalid();
    }
    public void running(){
        invalid();
    }
    private void invalid(){
        logger.info("The sprint cannot be set to this state");
    }
}
