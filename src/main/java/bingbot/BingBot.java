package bingbot;

import java.util.Scanner;

import bingbot.parser.Parser;
import bingbot.storage.Storage;
import bingbot.tasklist.TaskList;
import bingbot.ui.Ui;

/**
 * Class for the BingBot application. BingBot is a task management chatbot that
 * stores tasks, retrieves them from memory, and allows interaction via
 * commands.
 */
public class BingBot {
    /** File path where tasks are stored. */
    public static final String FILE_PATH = "./data/bingTask.txt";

    private static Ui ui = new Ui();
    private Storage storage = new Storage(BingBot.FILE_PATH);
    private TaskList taskList = storage.getMemory();
    private Parser parser = new Parser(taskList, ui);
    /**
     * Runs the BingBot program by initializing storage, UI, and parser.
     * Continuously reads user input until the exit command is given.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        TaskList taskList;

        try (Scanner scanner = new Scanner(System.in)) {
            Storage storage = new Storage(BingBot.FILE_PATH);
            ui.greet();
            taskList = storage.getMemory();
            Parser parser = new Parser(taskList, ui);

            while (true) {
                String input = scanner.nextLine();
                boolean result = parser.handleMessage(input);
                storage.toMemory(taskList);
                if (result) {
                    break;
                }
            }
        }
    }

    public static Ui getUi() {
        return ui;
    }

    /**
     * Generates a response for the user's chat message.
     */
    public String getResponse(String input) {
        String response = parser.handleMessage(input);
        return "BingBot heard: " + input;
    }

}
