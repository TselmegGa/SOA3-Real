package domain;

import domain.State.*;
import domain.item.state.*;

import java.util.ArrayList;

public class Item {

    public DoingState doingState;
    public ReadyForTestingState readyForTestingState;
    public DoneState doneState;
    public TodoState todoState;
    public TestingState testingState;
    private IPhaseState state;
    private ArrayList<Activity> activities;
    private User user;
    private int value;
    private String title;
    private String description;
    private Project project;

    public Item(ArrayList<Activity> activities, int value, String title, String description, Project project) {
        this.project = project;
        this.title = title;
        this.description = description;
        this.activities = activities;
        this.doingState = new DoingState(this);
        this.readyForTestingState = new ReadyForTestingState(this);
        this.doneState = new DoneState(this);
        this.todoState = new TodoState(this);
        this.testingState = new TestingState(this);
        this.value = value;
        state = todoState;
    }
    public Item(ArrayList<Activity> activities, int value, Project project, String title) {
        this(activities,value,title,null,project);
    }
    public Item(int value, Project project, String title) {
        this(new ArrayList<>(),value,title,null,project);
    }

    public boolean start(){
        return state.doing();
    }
    public boolean ready(){
        return state.readyForTesting();
    }
    public boolean test(){
        return state.testing();
    }
    public boolean done(){
        return state.done();
    }
    public boolean todo(){
        return state.todo();
    }

    public ArrayList<Activity> getActivities() {
        return activities;
    }
    public User getUser() {
        return user;
    }
    public User[] getTesters(){
        return this.project.getTesters();
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public IPhaseState getState() {
        return state;
    }
    public int getValue() {
        return value;
    }

    public boolean setUser(User user){
        if(!hasActivities()){
            this.user = user;
            return true;
        }else{
            System.out.println("Failed to add user");
            return false;
        }

    }
    public void setValue(int value) {
        this.value = value;
    }
    public void setState(IPhaseState state) {
        this.state = state;
    }
    public boolean setActivities(ArrayList<Activity> activities) {
        if(!hasUser()){
            this.activities = activities;
            return true;
        }else{
            System.out.println("Failed to add activities");
            return false;
        }
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public boolean hasActivities(){
        if(activities.isEmpty()){
            return getUser() != null;
        }
        else{
            System.out.println("Already has activities");
            return true;
        }
    }
    public boolean hasUser(){
        if(getUser() == null){
            return false;
        }
        System.out.println("Already has a user");
        return true;
    }
    public boolean checkTodo(){
        return state == todoState;
    }
}
