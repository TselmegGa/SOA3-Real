package Domain;

import Domain.SprintState.*;
import Domain.Behavior.*;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;

public class Sprint {



    public NewSprintState newSprintState;
    public AnnulledState annulledState;
    public ClosedState closedState;
    public FinishedState finishedState;
    public ReleasedState releasedState;
    public RunningState runningState;
    private FinishedBehavior behavior;
    private SprintState state;
    private ArrayList<Item> items;
    private Rapport rapport;
    private String summery;
    private ZonedDateTime startTime;
    private ZonedDateTime endTime;
    private Project project;

    public Sprint(ZonedDateTime startTime, ZonedDateTime endTime, ArrayList<Item> items, Project project){
        setTime(startTime,endTime);
        this.items = items;
        this.project = project;
        //New -> Running -> Finished -> Released/ Annulled -> Closed
        newSprintState = new NewSprintState(this);
        annulledState = new AnnulledState(this);
        finishedState = new FinishedState(this);
        closedState = new ClosedState(this);
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
    public ArrayList<Item> getItems(){
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
