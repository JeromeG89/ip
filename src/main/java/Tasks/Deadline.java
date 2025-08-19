package Tasks;

public class Deadline extends Task {
    String to;

    public Deadline(String name, String to) {
        super(name);
        this.to = to;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + String.format("(by: %s)", to);
    }
}
