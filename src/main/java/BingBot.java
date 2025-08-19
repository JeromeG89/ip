import java.util.Scanner;

public class BingBot {
    public static void main(String[] args) {
        String line = "____________________________________________________________";
        String name = "BingBot";
        String greet = String.format(line
                + "\n Hello! I'm %s\n What can I do for you?\n" + line
                + "\n Bye. Hope to see you again soon!\n" + line, name);
        System.out.println(greet);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("bye")) {
                System.out.println(line);
                System.out.println("Bye. Hope to never see you again >:[");
                System.out.println(line);
                break;
            }
            System.err.println(line);
            System.out.println(input);
            System.out.println(line);
        }
        scanner.close();
    }
}
