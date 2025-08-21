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
    private static String line = "____________________________________________________________";
    private static String name = "BingBot";

    public static void main(String[] args) {
        String greet = String.format(line
                + "\n Hello! I'm %s\n What can I do for you?\n" + line, name);
        System.out.println(greet);
        List<Task> stored = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            // System.out.println(line);
            boolean result = BingBot.handleMessage(input, stored);
            if (result) {
                break;
            }
        }
        scanner.close();
    }

    /* Return True when end session, False otherwise */
    public static boolean handleMessage(String input, List<Task> stored) {
        // System.out.println(line);
        String[] parts = input.split(" ");
        String command = parts[0];
        if (command.equals("mark") || command.equals("unmark")) {
            try {
                Integer.parseInt(parts[1]);
            } catch (NumberFormatException e) {
                System.out.println("dont play PUNK");
                System.out.println(line);
                return false;
            }
        }
        if (input.equals("bye")) {
            System.out.println("Bye. Hope to never see you again >:[");
            System.out.println(line);
            return true;
        } else if (input.equals("list")) {
            for (int i = 0; i < stored.size(); i++) { // wanted to use forEach but im dumb
                System.out.println((i + 1) + ". " + stored.get(i));
            }
            System.out.println(line);
        } else if (command.equals("unmark") && parts.length >= 2 && Integer.parseInt(parts[1]) <= stored.size()) {
            int markIndex = Integer.parseInt(parts[1]) - 1;
            stored.get(markIndex).unmark();
            System.out.println("Ok i unmarked liao");
            System.out.println(stored.get(markIndex));
            System.out.println(line);
        } else if (command.equals("mark") && parts.length >= 2 && Integer.parseInt(parts[1]) <= stored.size()) {
            int markIndex = Integer.parseInt(parts[1]) - 1;
            stored.get(markIndex).mark();
            System.out.println("Ok i marked liao");
            System.out.println(stored.get(markIndex));
            System.out.println(line);
        } else if (command.equals("delete") && parts.length >= 2) {
            int markIndex = Integer.parseInt(parts[1]) - 1;
            Task toDeleteTask = stored.get(markIndex);
            stored.remove(markIndex);
            System.out.println("Ok i added this: ");
            System.out.println(toDeleteTask);
            System.out.println(String.format("Now u got %d tasks in the list :[", stored.size()));
            System.out.println(line);
        } else {
            Task inputTask = BingBot.createTask(input, parts);
            if (inputTask == null) {
                System.out.println("dont play PUNK");
                System.out.println(line);
                return false;
            }
            stored.add(inputTask);
            System.out.println("Ok i added this: ");
            System.out.println(inputTask);
            System.out.println(String.format("Now u got %d tasks in the list :[", stored.size()));
            System.out.println(line);
        }
        return false;
    }

    public static Task createTask(String input, String[] parts) {
        String taskType = parts[0];
        int first = input.indexOf(" ");
        int last = input.indexOf("/");
        switch (taskType) {
            case "todo":
                return new ToDo(input.substring(first, input.length()));
            case "deadline":
                if (input.split("/by ").length < 2) {
                    return null;
                }
                return new Deadline(input.substring(first, last), input.split("/by ")[1]);
            case "event":
                if (input.split("/").length < 3) {
                    return null;
                }
                return new Event(input.substring(first, last),
                        input.split("/from |/to ")[1],
                        input.split("/from |/to ")[2]);
            default:
                return null;
        }
    }
}
