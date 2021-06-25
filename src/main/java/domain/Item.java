package domain;


import domain.item.state.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Item {

    private DoingState doingState;
    private ReadyForTestingState readyForTestingState;
    private DoneState doneState;
    private TodoState todoState;
    private TestingState testingState;
    private IPhaseState state;
    private List<Activity> activities;
    private User user;
    private int value;
    private String title;
    private String description;
    private Project project;
    private static final Logger logger = LogManager.getLogger(Item.class);

    public Item(List<Activity> activities, int value, String title, String description, Project project) {
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
    public Item(List<Activity> activities, int value, Project project, String title) {
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

    public List<Activity> getActivities() {
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
    public DoingState getDoingState() {
        return doingState;
    }
    public ReadyForTestingState getReadyForTestingState() {
        return readyForTestingState;
    }
    public DoneState getDoneState() {
        return doneState;
    }
    public TodoState getTodoState() {
        return todoState;
    }
    public TestingState getTestingState() {
        return testingState;
    }

    public boolean setUser(User user){
        if(!hasActivities()){
            this.user = user;
            return true;
        }else{
            logger.info("Failed to add user");
            return false;
        }

    }
    public void setValue(int value) {
        this.value = value;
    }
    public void setState(IPhaseState state) {
        this.state = state;
    }
    public boolean setActivities(List<Activity> activities) {
        if(!hasUser()){
            this.activities = activities;
            return true;
        }else{
            logger.info("Failed to add activities");
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
            logger.info("Already has activities");
            return true;
        }
    }
    public boolean hasUser(){
        if(getUser() == null){
            return false;
        }
        logger.info("Already has a user");
        return true;
    }
    public boolean checkTodo(){
        return state == todoState;
    }
}
