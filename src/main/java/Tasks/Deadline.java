package Tasks;

public class Deadline extends Task {
    String to;

    public Deadline(String name, String to) {
        super(name);
        this.to = to;
    }

    public Deadline(String name, String to, boolean done) {
        super(name);
        super.done = done;
        this.to = to;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + String.format("(by: %s)", to);
    }

    public static Task fromMemory(String input) {
        String parts[] = input.split("\\|");
        return new Deadline(parts[2], parts[3], parts[1].equals("1"));
    }

    @Override
    public String toMemory() {
        return String.format("D|%d|%s|%s", this.done ? 1 : 0, this.name, this.to);
    }
}
