package Tasks;

public abstract class Task {
    protected boolean done;
    protected String name;

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

    public abstract String toMemory();

    public static Task fromMemory(String input) { //incase others forget
        String parts[] = input.split("\\|");
        return new ToDo(parts[2], parts[1].equals("1"));
    }
}
