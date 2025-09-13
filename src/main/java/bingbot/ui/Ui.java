package bingbot.ui;

import bingbot.tasklist.TaskList;
import bingbot.tasks.Task;

/**
 * Represents the user interface for BingBot. Handles printing messages, task
 * updates, and formatting.
 */
public class Ui {
    public static final String LINE = "____________________________________________________________";
    private static final String NAME = "BingBot";

    public Ui() {
    }

    /**
     * Prints the greeting message when the bot starts.
     */
    public String greet() {
        String greet = String.format(LINE + "\n Hello! I'm %s\n What can I do for you?\n" + LINE, NAME);
        System.out.println(greet);
        return greet;
    }

    /**
     * Prints the confirmation message when a task is marked.
     *
     * @param t the task that was marked.
     */
    public String mark(Task t) {
        StringBuilder sb = new StringBuilder();
        sb.append("Ok i marked liao\n");
        sb.append(t.toString());
        System.out.println("Ok i marked liao");
        System.out.println(t);
        System.out.println(LINE);
        return sb.toString();
    }

    /**
     * Prints the confirmation message when a task is unmarked.
     *
     * @param t the task that was unmarked.
     */
    public String unmark(Task t) {
        StringBuilder sb = new StringBuilder();
        sb.append("Ok i unmarked liao\n");
        sb.append(t.toString());
        System.out.println("Ok i unmarked liao");
        System.out.println(t);
        System.out.println(LINE);
        return sb.toString();
    }

    /**
     * Prints the farewell message when ending the session.
     */
    public String bye() {
        StringBuilder sb = new StringBuilder();
        sb.append("Bye. Hope to never see you again >:[");
        System.out.println("Bye. Hope to never see you again >:[");
        System.out.println(LINE);
        return sb.toString();
    }

    /**
     * Prints for console.
     *
     * @param tl the task list.
     * @return the string representation of listString.
     */
    public String list(TaskList tl) {
        StringBuilder sb = new StringBuilder();
        sb.append(tl.toString());
        System.out.println(tl.toString());
        return sb.toString();
    }

    /**
     * Prints the confirmation message when a task is deleted.
     *
     * @param deletedTask the task that was deleted.
     * @param sizeLeft the number of tasks remaining in the list.
     */
    public String delete(Task deletedTask, int sizeLeft) {
        StringBuilder sb = new StringBuilder();
        sb.append("Ok i deleted this:\n");
        sb.append(deletedTask.toString());
        sb.append(String.format("Now u got %d tasks in the list :[", sizeLeft));
        System.out.println("Ok i deleted this: ");
        System.out.println(deletedTask);
        System.out.println(String.format("Now u got %d tasks in the list :[", sizeLeft));
        System.out.println(LINE);
        return sb.toString();
    }

    /**
     * Prints a message when an invalid command is input.
     */
    public String playPunk() {
        StringBuilder sb = new StringBuilder();
        sb.append("dont play PUNK");
        System.out.println("dont play PUNK");
        System.out.println(LINE);
        return sb.toString();
    }

    /**
     * Prints the confirmation message when a task is added.
     *
     * @param t the task that was added.
     * @param sizeLeft the number of tasks remaining in the list.
     */
    public String add(Task t, int sizeLeft) {
        StringBuilder sb = new StringBuilder();
        sb.append("Ok i added this:\n");
        sb.append(String.format(t.toString() + "\n"));
        sb.append(String.format("Now u got %d tasks in the list :[", sizeLeft));
        System.out.println("Ok i added this: ");
        System.out.println(t);
        System.out.println(String.format("Now u got %d tasks in the list :[", sizeLeft));
        System.out.println(LINE);
        return sb.toString();
    }

    /**
     * Prints the confirmation message when a find task is executed.
     *
     * @param taskList the tasks found.
     */
    public String findTask(TaskList taskList) {
        StringBuilder sb = new StringBuilder();
        sb.append("Found these tasks:\n");
        sb.append(taskList.toString());
        System.out.println("Found these tasks: ");
        System.out.println(taskList.toString());
        return sb.toString();
    }

    /**
     * Prints the confirmation message when a sort task is executed.
     *
     * @param taskList the tasks after sorted.
     */
    public String sort(TaskList taskList) {
        StringBuilder sb = new StringBuilder();
        sb.append("SORTED!!!!!!\n");
        sb.append(taskList.toString());
        return sb.toString();
    }
}
