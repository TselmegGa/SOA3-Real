package domain.sprint.state;

import domain.Sprint;

public class NewSprintState extends SprintState {
    private Sprint sprint;
    public NewSprintState(Sprint sprint) {
        this.sprint = sprint;
    }

    @Override
    public void annulled() {
        sprint.setState(sprint.annulledState);
        System.out.println("The sprint has been annulled");
    }

    @Override
    public void running() {
        sprint.setState(sprint.runningState);
        System.out.println("The sprint has been started");
    }
}
