package Domain.ForumComposit;

import Domain.User;

public class Reaction {

    private final User user;
    private final String content;

    public Reaction(User user, String content) {
        this.user = user;
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Reaction{" +
                "user=" + user.getName() +
                ", content='" + content + '\'' +
                '}';
    }
}
