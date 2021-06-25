package domain.sprint.state;

import domain.Sprint;

public class AnnulledState extends SprintState {
    private Sprint sprint;
    public AnnulledState(Sprint sprint) {
        this.sprint = sprint;
    }

    @Override
    public void closed() {
        sprint.setState(sprint.closedState);
        System.out.println("The sprint has been closed");
    }
}
