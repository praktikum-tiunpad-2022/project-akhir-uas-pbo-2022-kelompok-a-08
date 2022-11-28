package projectuas.pbo;

public class Player extends User {
    private String username;

    Player() {
        this.username="";
    }

    Player(String name) {
        this.username=name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
