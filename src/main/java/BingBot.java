public class BingBot {
    public static void main(String[] args) {
        String line = "____________________________________________________________";
        String name = "BingBot";
        String body = String.format(line
                + "\n Hello! I'm %s\n What can I do for you?\n" + line
                + "\n Bye. Hope to see you again soon!\n" + line, name);
        System.out.println(body);
    }
}
