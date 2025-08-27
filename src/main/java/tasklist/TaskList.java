package tasklist;
import java.util.ArrayList;
import java.util.List;

import Tasks.Deadline;
import Tasks.Event;
import Tasks.Task;
import Tasks.ToDo;
import ui.Ui;

public class TaskList extends ArrayList<Task> {

    public TaskList() {
        super();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < super.size(); i++) {
            sb.append(i + 1).append(". ").append(super.get(i)).append("\n");
        }
        sb.append(Ui.line).append("\n");
        return sb.toString();
    }

    public Task mark(int idx) {
        return super.get(idx).mark();
    }
    
    public Task unmark(int idx) {
        return super.get(idx).unmark();
        
    }

    public Task delete(int idx) {
        return super.remove(idx);
    }
}
