package domain.sprint.state;

import domain.Sprint;

public class ReleasedState extends SprintState {
    private Sprint sprint;
    public ReleasedState(Sprint sprint) {
        this.sprint = sprint;
    }

    @Override
    public void closed() {
        sprint.setState(sprint.closedState);
        System.out.println("The sprint has been closed");
    }

}
