package Domain.Behavior;

public class NormalReviewBehavior implements FinishedBehavior {
    @Override
    public void planReview() {
        System.out.println("The review of this sprint will be between the scrum master and the members");
    }
}
