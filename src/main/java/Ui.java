import Tasks.Task;

public class Ui {
    public static String line = "____________________________________________________________";
    private static String name = "BingBot";

    public Ui() {
    }

    public void greet() {
        String greet = String.format(line
                + "\n Hello! I'm %s\n What can I do for you?\n" + line, name);
        System.out.println(greet);
    }

    public void mark(Task t) {
        System.out.println("Ok i marked liao");
        System.out.println(t);
        System.out.println(line);
    }

    public void unmark(Task t) {
        System.out.println("Ok i unmarked liao");
        System.out.println(t);
        System.out.println(line);
    }

    public void bye() {
        System.out.println("Bye. Hope to never see you again >:[");
        System.out.println(line);
    }

    public void list(String listString) {
        System.out.println(listString);
    }

    public void delete(Task deletedTask, int sizeLeft) {
        System.out.println("Ok i deleted this: ");
        System.out.println(deletedTask);
        System.out.println(String.format("Now u got %d tasks in the list :[", sizeLeft));
        System.out.println(line);
    }

    public void playPunk() {
        System.out.println("dont play PUNK");
        System.out.println(line);
    }

    public void add(Task t, int sizeLeft) {
        System.out.println("Ok i added this: ");
        System.out.println(t);
        System.out.println(String.format("Now u got %d tasks in the list :[", sizeLeft));
        System.out.println(line);
    }

}
