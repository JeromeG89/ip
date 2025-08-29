package Tasks;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

public class Event extends Task {
    private LocalDateTime from;
    private LocalDateTime to;

    public Event(String name, String from, String to) {
        this(name, from, to, false);
        System.out.println("asnack");
    }

    public Event(String name, String from, String to, boolean isDone) {
        super(name, isDone);
        this.from = super.parseDate(from);
        this.to = super.parseDate(to);
    }

    @Override
    public String toString() {
        return "[E]" + super.toString()
                + String.format("(from: %s to: %s)", from.format(outputFormatter), to.format(outputFormatter));
    }

    public static Task fromMemory(String input) {
        String parts[] = input.split("\\|");
        return new Event(parts[2], parts[3], parts[4], parts[1].equals("1"));
    }

    @Override
    public String toMemory() {
        return String.format("E|%d|%s|%s|%s", super.isDone() ? 1 : 0, super.getName(), this.from, this.to);
    }

    public LocalDateTime getFrom() {
        return this.from;
    }

    public LocalDateTime getTo() {
        return this.to;
    }
}
