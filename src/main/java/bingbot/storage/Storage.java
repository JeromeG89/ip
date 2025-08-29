package bingBot.storage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bingBot.Tasks.*;
import bingBot.tasklist.TaskList;

public class Storage {
    String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public boolean toMemory(TaskList stored) {
        try (FileWriter writer = new FileWriter(this.filePath)) {
            for (Task t : stored) {
                writer.write(t.toMemory() + "\n");
            }
            return true;
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
            return false;
        }
    }

    public TaskList getMemory() {
        File file = new File(this.filePath);

        try {
            TaskList stored = new TaskList();
            if (!file.exists()) {
                file.createNewFile();
                return stored;
            }

            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                stored.add(this.parseMemory(line));
            }

            scanner.close();
            return stored;
        } catch (IOException e) {
            System.out.println("Error handling file: " + e.getMessage());
            return null;
        }
    }

    public Task parseMemory(String input) {
        String[] parts = input.split("\\|");
        switch (parts[0]) {
            case "T":
                return ToDo.fromMemory(input);
            case "D":
                return Deadline.fromMemory(input);
            case "E":
                return Event.fromMemory(input);
            default:
                return null;
        }
    }
}
