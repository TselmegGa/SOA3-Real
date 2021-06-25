package Domain.ForumComposit;

import Domain.Project;

import java.util.ArrayList;

public class Forum {
    private Project project;
    private ArrayList<Topic> topics = new ArrayList<>();

    public Forum(Project project) {
        this.project = project;
        setupListeners();
    }

    public Forum(Project project, ArrayList<Topic> topics) {
        this.topics = topics;
        this.project = project;
        setupListeners();
    }

    private void setupListeners(){
        this.topics.forEach(t -> t.registerNotificationObserver(this.project.getDevelopers()));
    }


    public ArrayList<Topic> getTopics() {
        return topics;
    }

    public void addTopic(Topic topic){
        topic.registerNotificationObserver(this.project.getDevelopers());
        this.topics.add(topic);
    }
}
