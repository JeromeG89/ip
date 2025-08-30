package bingbot.Tasks;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public abstract class Task {
    private boolean isDone;
    private String name;
    protected DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MMM dd yyyy HH:mm");

    public Task(String name) {
        this.name = name;
        this.isDone = false;
    }

    public Task(String name, boolean isDone) {
        this(name);
        this.isDone = isDone;
    }

    public String toString() {
        return isDone
                ? "[X] " + this.name
                : "[] " + this.name;
    }

    public Task mark() {
        this.isDone = true;
        return this;
    }

    public Task unmark() {
        this.isDone = false;
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

    public boolean isDone() {
        return this.isDone;
    }

    public String getName() {
        return this.name;
    }
}
