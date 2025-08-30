package bingbot;
import java.util.Scanner;

import bingbot.parser.Parser;
import bingbot.storage.Storage;
import bingbot.tasklist.TaskList;
import bingbot.ui.Ui;

enum commandTypes {
    bye,
    list,
    mark,
    unmark,
}

public class BingBot {
    public static final String FILE_PATH = "./data/bingTask.txt";
    public static Ui ui = new Ui();

    public static void main(String[] args) {
        TaskList taskList;

        Scanner scanner = new Scanner(System.in);
        Storage storage = new Storage(BingBot.FILE_PATH);
        ui.greet();
        taskList = storage.getMemory();
        Parser parser = new Parser(taskList);
        
        while (true) {
            String input = scanner.nextLine();
            boolean result = parser.handleMessage(input);
            storage.toMemory(taskList);
            if (result) {
                break;
            }
        }
        scanner.close();
    }

}
