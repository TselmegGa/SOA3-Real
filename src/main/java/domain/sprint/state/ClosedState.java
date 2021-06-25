package domain.sprint.state;

import domain.Sprint;

public class ClosedState extends SprintState {
    private Sprint sprint;
    public ClosedState(Sprint sprint) {
        this.sprint = sprint;
    }

}
