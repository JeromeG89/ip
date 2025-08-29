package Tasks;

import java.time.LocalDateTime;

public class Deadline extends Task {
    private LocalDateTime to;

    public Deadline(String name, String to) {
        this(name, to, false);
    }

    public Deadline(String name, String to, boolean isDone) {
        super(name, isDone);
        this.to = super.parseDate(to);
    }

    @Override
    public String toString() {
        
        return "[D]" + super.toString() + String.format("(by: %s)", to.format(outputFormatter));
    }

    public static Task fromMemory(String input) {
        String parts[] = input.split("\\|");
        return new Deadline(parts[2], parts[3], parts[1].equals("1"));
    }

    @Override
    public String toMemory() {
        return String.format("D|%d|%s|%s", super.isDone() ? 1 : 0, super.getName(), this.to);
    }

    public LocalDateTime getDeadline() {
        return this.to;
    }
}
