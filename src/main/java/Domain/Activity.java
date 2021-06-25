package Domain;

public class Activity {
    private String description;
    private int value;
    private User user;

    public Activity(String description, int value, User user){
        this.description = description;
        this.value = value;
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
