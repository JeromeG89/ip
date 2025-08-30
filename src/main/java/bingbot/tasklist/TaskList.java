package bingbot.tasklist;

import java.util.ArrayList;

import bingbot.Tasks.Task;
import bingbot.ui.Ui;

/**
 * Represents a list of tasks with helper methods for marking, unmarking, and
 * deleting tasks.
 */
public class TaskList extends ArrayList<Task> {

    public TaskList() {
        super();
    }

    /**
     * Converts the TaskList into a string representation.
     *
     * Returns a numbered list of tasks followed by a line separator.
     *
     * @return the string representation of the TaskList.
     */

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < super.size(); i++) {
            sb.append(i + 1).append(". ").append(super.get(i)).append("\n");
        }
        sb.append(Ui.LINE).append("\n");
        return sb.toString();
    }

    /**
     * Marks the task at the given index as done.
     *
     * Returns the marked task.
     *
     * @param idx the index of the task to mark.
     * @return the marked Task.
     */
    public Task mark(int idx) {
        return super.get(idx).mark();
    }

    /**
     * Unmarks the task at the given index.
     *
     * Returns the unmarked task.
     *
     * @param idx the index of the task to unmark.
     * @return the unmarked Task.
     */
    public Task unmark(int idx) {
        return super.get(idx).unmark();

    }

    /**
     * Deletes the task at the given index from the TaskList.
     *
     * Returns the deleted task.
     *
     * @param idx the index of the task to delete.
     * @return the deleted Task.
     */
    public Task delete(int idx) {
        return super.remove(idx);
    }
}
