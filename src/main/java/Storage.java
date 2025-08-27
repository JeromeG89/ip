import java.io.FileWriter;
import java.io.IOException;

import Tasks.Task;

public class Storage {
    String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public boolean storeData(TaskList stored) {
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
}
