package domain.forum;

import domain.Item;
import domain.notification.observer.BasicNotificationSubject;
import domain.notification.observer.Message;
import domain.User;

import java.util.ArrayList;
import java.util.List;

public class Topic extends BasicNotificationSubject {

    private User start;
    private String title;
    private String content;
    private Item item;

    private List<Reaction> reactions;

    public Topic(User start, Item item, String title, String content, List<Reaction> reactions) {
        this.start = start;
        this.item = item;
        this.title = title;
        this.content = content;
        this.reactions = reactions;
        this.registerNotificationObserver(this.start);
    }

    public Topic(User start, Item item,  String title, String content) {
        this.start = start;
        this.item = item;
        this.title = title;
        this.content = content;
        this.reactions = new ArrayList<>();

        this.registerNotificationObserver(this.start);
    }

    public User getStart() {
        return start;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Item getItem() {
        return item;
    }

    public List<Reaction> getReactions() {
        return reactions;
    }

    public void addReaction(Reaction reaction) {
        this.removeNotificationObserver(reaction.getUser());
        this.reactions.add(reaction);
        this.notifyNotificationObserver(new Message("Forum - " + title + " has an new reaction", reaction.getUser().getName() + " reacted with: "  + reaction.getContent()));
        this.registerNotificationObserver(reaction.getUser());
    }

    @Override
    public String toString() {
        return "Topic{" +
                "start=" + start +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", item=" + item +
                ", reactions=" + reactions +
                '}';
    }
}
