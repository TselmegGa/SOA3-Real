package domain.forum.composit;

import domain.Project;

import java.util.ArrayList;
import java.util.List;

public class Forum {
    private Project project;
    private List<Topic> topics = new ArrayList<>();

    public Forum(Project project) {
        this.project = project;
        setupListeners();
    }

    public Forum(Project project, List<Topic> topics) {
        this.topics = topics;
        this.project = project;
        setupListeners();
    }

    private void setupListeners(){
        this.topics.forEach(t -> t.registerNotificationObserver(this.project.getDevelopers()));
    }


    public List<Topic> getTopics() {
        return topics;
    }

    public void addTopic(Topic topic){
        topic.registerNotificationObserver(this.project.getDevelopers());
        this.topics.add(topic);
    }
}
