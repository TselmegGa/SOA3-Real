package domain.item.state;

public interface IPhaseState {


    boolean todo();
    boolean doing();
    boolean readyForTesting();
    boolean testing();
    boolean done();
    void print(String text);
}
