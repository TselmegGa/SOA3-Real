package domain.behavior;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class NormalReviewBehavior implements FinishedBehavior {
    private static final Logger logger = LogManager.getLogger(NormalReviewBehavior.class);
    @Override
    public void planReview() {
        logger.info("The review of this sprint will be between the scrum master and the members");
    }
}
