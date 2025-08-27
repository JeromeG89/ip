import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Tasks.Deadline;
import Tasks.Event;
import Tasks.Task;
import Tasks.ToDo;

enum commandTypes {
    bye,
    list,
    mark,
    unmark,
}

public class BingBot {

    private static String filePath = "./data/bingTask.txt";
    protected static Ui ui = new Ui();

    public static void main(String[] args) {
        TaskList taskList;
        Scanner scanner = new Scanner(System.in);
        Storage storage = new Storage(BingBot.filePath);
        
        ui.greet();
        
        taskList = storage.getMemory();
        while (true) {
            String input = scanner.nextLine();
            boolean result = BingBot.handleMessage(input, taskList);
            storage.toMemory(taskList);
            if (result) {
                break;
            }
        }
        scanner.close();
    }

    /* Return True when end session, False otherwise */
    public static boolean handleMessage(String input, TaskList taskList) {
        // System.out.println(line);
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
        } else {
            Task inputTask = BingBot.createTask(input, parts);
            if (inputTask == null) {
                ui.playPunk();
                return false;
            }
            taskList.add(inputTask);
            ui.add(inputTask, taskList.size());
        }
        return false;
    }

    public static Task createTask(String input, String[] parts) {
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
                    return new Deadline(input.substring(first, last), input.split("/by ")[1]);
                case "event":
                    if (input.split("/").length < 3) { // can throw exception here instead nexttime
                        return null;
                    }
                    return new Event(input.substring(first, last),
                            input.split("/from |/to ")[1],
                            input.split("/from |/to ")[2]);
                default:
                    return null;
            }
        } catch (DateTimeParseException e) {
            return null;
        }
    }

}
