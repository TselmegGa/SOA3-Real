package domain.templates;

import domain.notification.observer.BasicNotificationSubject;
import domain.notification.observer.Message;
import domain.Project;

public abstract class PipelineTemplate extends BasicNotificationSubject {
    private Project project;
    private String name;
    private String link;
    //Template pattern
    public void run(){
        build();
        test();
        publish();
    }

    public PipelineTemplate(Project project, String link, String name) {
        this.project = project;
        this.link = link;
        this.name = name;
    }

    public abstract void build();
    public void test(){
        System.out.println("Testing given tests");
        System.out.println("------------------------");
    }
    public void publish(){
        System.out.println("Publishing to " + link);
        System.out.println("------------------------");
    }

    public void failed(String error){
        //notify scrummaster
        registerNotificationObserver(this.project.getScrumMasters());
        notifyNotificationObserver(new Message(project.getName() + " build failed", "Error: " + error));

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
