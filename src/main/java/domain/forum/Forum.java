package domain.forum;

import domain.Project;
import domain.notification.observer.Message;

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
        topic.removeNotificationObserver(topic.getStart());
        topic.notifyNotificationObserver(new Message("Forum - "+ topic.getStart().getName() + " opened: " + topic.getTitle(), topic.getContent()));
        topic.registerNotificationObserver(topic.getStart());
        this.topics.add(topic);
    }
}
