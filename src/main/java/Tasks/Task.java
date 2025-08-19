package Tasks;

public abstract class Task {
    boolean done;
    String name;

    public Task(String name) {
        this.name = name;
        this.done = false;
    }

    public String toString() {
        return done
                ? "[X] " + this.name
                : "[] " + this.name;
    }

    public void mark() {
        this.done = true;
    }

    public void unmark() {
        this.done = false;
    }
}
