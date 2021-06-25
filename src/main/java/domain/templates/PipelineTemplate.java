package domain.templates;

import domain.notification.observer.BasicNotificationSubject;
import domain.notification.observer.Message;
import domain.Project;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public abstract class PipelineTemplate extends BasicNotificationSubject {
    protected static final Logger logger = LogManager.getLogger(PipelineTemplate.class);
    private Project project;
    private String name;
    private String link;
    //Template pattern
    public void run(){
        build();
        test();
        publish();
    }

    protected PipelineTemplate(Project project, String link, String name) {
        this.project = project;
        this.link = link;
        this.name = name;
    }

    public abstract void build();
    public void test(){
        logger.info("Testing given tests");
        logger.info("------------------------");
    }
    public void publish(){
        logger.info("Publishing to " + link);
        logger.info("------------------------");
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
