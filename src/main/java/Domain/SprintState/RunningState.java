package Domain.SprintState;

import Domain.Sprint;

public class RunningState extends SprintState {
    private Sprint sprint;
    public RunningState(Sprint sprint) {
        this.sprint = sprint;
    }

    @Override
    public void annulled() {
        System.out.println("The sprint cannot be annulled while running");
    }



    @Override
    public void finished() {
        sprint.setState(sprint.finishedState);
        System.out.println("The sprint has been finished");
    }

}
