import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BingBot {
    public static void main(String[] args) {
        String line = "____________________________________________________________";
        String name = "BingBot";
        String greet = String.format(line
                + "\n Hello! I'm %s\n What can I do for you?\n" + line
                + "\n Bye. Hope to see you again soon!\n" + line, name);
        System.out.println(greet);
        List<Task> stored = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            String[] parts = input.split(" ");
            if (input.equals("bye")) {
                System.out.println(line);
                System.out.println("Bye. Hope to never see you again >:[");
                System.out.println(line);
                break;
            } else if (input.equals("list")) {
                System.out.println(line);
                for (int i = 0; i < stored.size(); i++) { // wanted to use forEach but im dumb
                    System.out.println((i + 1) + ". " + stored.get(i));
                }
                System.out.println(line);
            } else if (parts[0].equals("unmark")  && parts.length >= 2 && Integer.parseInt(parts[1]) <= stored.size()) {
                int markIndex = Integer.parseInt(parts[1]) - 1;
                stored.get(markIndex).unmark();
                System.out.println("Ok i unmarked liao");
                System.out.println(stored.get(markIndex));
            } else if (parts[0].equals("mark") && parts.length >= 2 && Integer.parseInt(parts[1]) <= stored.size()) {
                int markIndex = Integer.parseInt(parts[1]) - 1;
                stored.get(markIndex).mark();
                System.out.println("Ok i marked liao");
                System.out.println(stored.get(markIndex));
            } else {
                Task inputTask = new Task(input);
                stored.add(inputTask);
                System.out.println(line);
                System.out.println("added: " + input);
                System.out.println(line);
            }

        }
        scanner.close();
    }
}
