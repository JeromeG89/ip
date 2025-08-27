package Tasks;

public class ToDo extends Task {
    public ToDo(String name) {
        super(name);
    }

    protected ToDo(String name, boolean done) {
        super(name);
        super.done = done;
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
        return String.format("T|%d|%s", this.done ? 1 : 0, this.name);
    }
}
