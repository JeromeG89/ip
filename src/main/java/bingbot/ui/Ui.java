package bingbot.ui;

import bingbot.Tasks.Task;

/**
 * Represents the user interface for BingBot.
 * Handles printing messages, task updates, and formatting.
 */
public class Ui {
    public static final String LINE = "____________________________________________________________";
    private static final String NAME = "BingBot";

    public Ui() {
    }

    /**
     * Prints the greeting message when the bot starts.
     */
    public void greet() {
        String greet = String.format(LINE
                + "\n Hello! I'm %s\n What can I do for you?\n" + LINE, NAME);
        System.out.println(greet);
    }

    /**
     * Prints the confirmation message when a task is marked.
     *
     * @param t the task that was marked.
     */
    public void mark(Task t) {
        System.out.println("Ok i marked liao");
        System.out.println(t);
        System.out.println(LINE);
    }

    /**
     * Prints the confirmation message when a task is unmarked.
     *
     * @param t the task that was unmarked.
     */
    public void unmark(Task t) {
        System.out.println("Ok i unmarked liao");
        System.out.println(t);
        System.out.println(LINE);
    }

    /**
     * Prints the farewell message when ending the session.
     */
    public void bye() {
        System.out.println("Bye. Hope to never see you again >:[");
        System.out.println(LINE);
    }

    public void list(String listString) {
        System.out.println(listString);
    }

    /**
     * Prints the confirmation message when a task is deleted.
     *
     * @param deletedTask the task that was deleted.
     * @param sizeLeft    the number of tasks remaining in the list.
     */
    public void delete(Task deletedTask, int sizeLeft) {
        System.out.println("Ok i deleted this: ");
        System.out.println(deletedTask);
        System.out.println(String.format("Now u got %d tasks in the list :[", sizeLeft));
        System.out.println(LINE);
    }

    /**
     * Prints a message when an invalid command is input.
     */
    public void playPunk() {
        System.out.println("dont play PUNK");
        System.out.println(LINE);
    }

    /**
     * Prints the confirmation message when a task is added.
     *
     * @param t        the task that was added.
     * @param sizeLeft the number of tasks remaining in the list.
     */
    public void add(Task t, int sizeLeft) {
        System.out.println("Ok i added this: ");
        System.out.println(t);
        System.out.println(String.format("Now u got %d tasks in the list :[", sizeLeft));
        System.out.println(LINE);
    }

}
