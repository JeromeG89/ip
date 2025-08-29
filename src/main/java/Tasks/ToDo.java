package Tasks;

public class ToDo extends Task {
    public ToDo(String name) {
        this(name, false);
    }

    protected ToDo(String name, boolean isDone) {
        super(name, isDone);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    public static Task fromMemory(String input) {
        String parts[] = input.split("\\|");
        return new ToDo(parts[2], parts[1].equals("1"));
    }

    @Override
    public String toMemory() {
        return String.format("T|%d|%s", super.isDone() ? 1 : 0, super.getName());
    }
}
