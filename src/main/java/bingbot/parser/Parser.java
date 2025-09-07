package bingbot.parser;

import java.time.format.DateTimeParseException;

import bingbot.tasklist.TaskList;
import bingbot.tasks.Deadline;
import bingbot.tasks.Event;
import bingbot.tasks.Task;
import bingbot.tasks.ToDo;
import bingbot.ui.Ui;

/**
 * Interprets user input and converting it into
 * commands or tasks.
 */
public class Parser {
    private final Ui ui;
    private final TaskList taskList;

    /**
     * Creates a Parser that will process user input into commands.
     *
     * @param taskList the list of tasks to operate on.
     * @param ui       the user interface to interact with.
     */
    public Parser(TaskList taskList, Ui ui) {
        this.taskList = taskList;
        this.ui = ui;
    }

    /**
     * Handles a user input message and executes the corresponding action.
     *
     * Returns true if the input ends the session (i.e., "bye"), false otherwise.
     *
     * @param input the raw user input string.
     * @return true if the session should end, false otherwise.
     */
    public boolean handleMessage(String input) {
        String[] parts = input.split(" ");
        String command = parts[0];
        if (command.equals("mark") || command.equals("unmark")) {
            try {
                Integer.parseInt(parts[1]);
            } catch (NumberFormatException e) {
                ui.playPunk();
                return false;
            }
        }
        if (input.equals("bye")) {
            ui.bye();
            return true;
        } else if (input.equals("list")) {
            System.out.println(taskList.toString());
        } else if (command.equals("unmark") && parts.length >= 2 && Integer.parseInt(parts[1]) <= taskList.size()) {
            int markIndex = Integer.parseInt(parts[1]) - 1;
            Task unmarked = taskList.unmark(markIndex);
            ui.unmark(unmarked);
        } else if (command.equals("mark") && parts.length >= 2 && Integer.parseInt(parts[1]) <= taskList.size()) {
            int markIndex = Integer.parseInt(parts[1]) - 1;
            Task marked = taskList.mark(markIndex);
            ui.mark(marked);
        } else if (command.equals("delete") && parts.length >= 2) {
            int markIndex = Integer.parseInt(parts[1]) - 1;
            Task deletedTask = taskList.remove(markIndex);
            ui.delete(deletedTask, taskList.size());
        } else if (command.equals("find") && parts.length >= 2) {
            String taskName = parts[1];
            TaskList tasks = this.findTask(taskName);
            ui.findTask(tasks);
        } else {
            Task inputTask = this.createTask(input, parts);
            if (inputTask == null) {
                ui.playPunk();
                return false;
            }
            taskList.add(inputTask);
            ui.add(inputTask, taskList.size());
        }
        return false;
    }

    /**
     * Creates a Task object from the given user input.
     *
     * Returns a Task (ToDo, Deadline, Event) if parsing is successful; null
     * otherwise.
     *
     * @param input the raw input string from the user.
     * @param parts the input split into words.
     * @return a Task object or null if input is invalid.
     */
    public Task createTask(String input, String[] parts) {
        String taskType = parts[0];
        int first = input.indexOf(" ");
        int last = input.indexOf("/");
        try {
            switch (taskType) {
            case "todo":
                return new ToDo(input.substring(first + 1, input.length()));
            case "deadline":
                if (input.split("/by ").length < 2) { // can throw exception here instead nexttime
                    return null;
                }
                return new Deadline(input.substring(first + 1, last), input.split(" /by ")[1]);
            case "event":
                if (input.split("/from |/to ").length < 3) { // can throw exception here instead nexttime
                    return null;
                }
                return new Event(input.substring(first + 1, last),
                        input.split(" /from | /to ")[1],
                        input.split(" /from | /to ")[2], false);
            default:
                return null;
            }
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    public TaskList findTask(String taskName) {
        return this.taskList.findTask(taskName);
    }

}
