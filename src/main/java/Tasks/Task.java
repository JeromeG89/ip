package Tasks;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public abstract class Task {
    private boolean done;
    private String name;
    protected DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MMM dd yyyy HH:mm");

    public Task(String name) {
        this.name = name;
        this.done = false;
    }

    public Task(String name, boolean done) {
        this(name);
        this.done = done;
    }

    public String toString() {
        return done
                ? "[X] " + this.name
                : "[] " + this.name;
    }

    public Task mark() {
        this.done = true;
        return this;
    }

    public Task unmark() {
        this.done = false;
        return this;
    }

    public abstract String toMemory();

    public static Task fromMemory(String input) { // incase others forget
        String parts[] = input.split("\\|");
        return new ToDo(parts[2], parts[1].equals("1"));
    }

    public LocalDateTime parseDate(String dateString) throws DateTimeParseException {
        try {
            return LocalDateTime.parse(dateString);
        } catch (DateTimeException e) {
            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
            LocalDateTime dateTime = LocalDateTime.parse(dateString, inputFormatter);
            return dateTime;
        }

    }

    public boolean getDone() {
        return this.done;
    }

    public String getName() {
        return this.name;
    }
}
