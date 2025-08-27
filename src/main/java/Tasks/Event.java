package Tasks;

public class Event extends Task {
    String from;
    String to;

    public Event(String name, String from, String to) {
        super(name);
        this.from = from;
        this.to = to;
    }

    public Event(String name, String from, String to, boolean done) {
        super(name);
        super.done = done;
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + String.format("(from: %s to: %s)", from, to);
    }

    public static Task fromMemory(String input) {
        String parts[] = input.split("\\|");
        return new Event(parts[2], parts[3], parts[4], parts[1].equals("1"));
    }

    @Override
    public String toMemory() {
        return String.format("E|%d|%s|%s|%s", this.done ? 1 : 0, this.name, this.from, this.to);
    }
}
