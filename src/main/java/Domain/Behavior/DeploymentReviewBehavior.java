package Domain.Behavior;

public class DeploymentReviewBehavior implements FinishedBehavior {
    @Override
    public void planReview() {
        System.out.println("The review of this sprint will be between the scrum master, members and the project owner");
    }
}
