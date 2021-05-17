package User;

public class User {

    private String name;
    private int attempts;
    private long duration;
    private long starttime;


    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public long getStarttime() {
        return starttime;
    }

    public void setStarttime(long starttime) {
        this.starttime = starttime;
    }


    public String getUsername() {
        return name;
    }

    public void setUsername(String username) {
        this.name = username;
    }



}
