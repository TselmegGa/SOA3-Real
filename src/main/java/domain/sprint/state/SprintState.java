package domain.sprint.state;

public abstract class SprintState {

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
        System.out.println("The sprint cannot be set to this state");
    }
}
