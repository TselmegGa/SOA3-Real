package Domain.State;

public interface IPhaseState {


    boolean todo();
    boolean doing();
    boolean readyForTesting();
    boolean testing();
    boolean done();
}
