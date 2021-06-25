package domain;


import domain.behavior.*;
import domain.sprint.state.*;


import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class Sprint {



    private NewSprintState newSprintState;
    private AnnulledState annulledState;
    private ClosedState closedState;
    private FinishedState finishedState;
    private ReleasedState releasedState;
    private RunningState runningState;
    private FinishedBehavior behavior;
    private SprintState state;
    private List<Item> items;
    private Rapport rapport;
    private String summery;
    private ZonedDateTime startTime;
    private ZonedDateTime endTime;
    private Project project;

    public Sprint(ZonedDateTime startTime, ZonedDateTime endTime, List<Item> items, Project project){
        setTime(startTime,endTime);

        this.items = items;
        this.project = project;
        //New -> Running -> Finished -> Released/ Annulled -> Closed
        newSprintState = new NewSprintState(this);
        annulledState = new AnnulledState(this);
        finishedState = new FinishedState(this);
        closedState = new ClosedState();
        releasedState = new ReleasedState(this);
        runningState = new RunningState(this);
        state = newSprintState;
    }

    public Sprint(ZonedDateTime startTime, ZonedDateTime endTime, Project project){
        this(startTime, endTime, new ArrayList<>(),project);
    }
    public Sprint(ZonedDateTime startTime, ZonedDateTime endTime){
        this(startTime, endTime, new ArrayList<>(),null);
    }

    public void setTime(ZonedDateTime startTime, ZonedDateTime endTime){
        this.endTime = endTime;
        this.startTime = startTime;
    }

    public boolean closed(){
        return state == closedState;
    }
    public void run(){
        state.running();
    }
    public void finish(){
        state.finished();
    }
    public void release(){
        state.released();
    }
    public void annul(){
        state.annulled();
    }
    public void close(){
        state.closed();
    }


    public FinishedBehavior getBehavior(){
        return behavior;
    }
    public String getSummery() {
        return summery;
    }
    public List<Item> getItems(){
        return items;
    }
    public SprintState getState(){
        return this.state;
    }
    public Rapport getRapport() {
        return rapport;
    }
    public Project getProject() {
        return project;
    }
    public String getName(){
        return "Sprint van " + startTime.toString() + " t/m " + endTime.toString();
    }
    public NewSprintState getNewSprintState() {
        return newSprintState;
    }
    public AnnulledState getAnnulledState() {
        return annulledState;
    }
    public ClosedState getClosedState() {
        return closedState;
    }
    public FinishedState getFinishedState() {
        return finishedState;
    }
    public ReleasedState getReleasedState() {
        return releasedState;
    }
    public RunningState getRunningState() {
        return runningState;
    }

    public void addItem(Item item){
        items.add(item);
    }
    public void removeItem(Item item){
        items.remove(item);
    }
    public void setState(SprintState state){
        this.state = state;
    }
    public void setRapport(Rapport rapport) {
        this.rapport = rapport;
    }
    public void setSummery(String summery) {
        this.summery = summery;
    }
    public void setProject(Project project) {
        this.project = project;
    }

    public void onFinish(FinishedBehavior behavior){
        this.behavior  = behavior;
    }
    public boolean timeRunning(){
        return Instant.now().compareTo(endTime.toInstant()) < 0;
    }
}
