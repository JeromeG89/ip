package bingBot;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bingBot.Tasks.Deadline;
import bingBot.Tasks.Event;
import bingBot.Tasks.Task;
import bingBot.Tasks.ToDo;
import bingBot.parser.Parser;
import bingBot.storage.Storage;
import bingBot.tasklist.TaskList;
import bingBot.ui.Ui;

enum commandTypes {
    bye,
    list,
    mark,
    unmark,
}

public class BingBot {
    private static String filePath = "./data/bingTask.txt";
    public static Ui ui = new Ui();

    public static void main(String[] args) {
        TaskList taskList;

        Scanner scanner = new Scanner(System.in);
        Storage storage = new Storage(BingBot.filePath);
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
