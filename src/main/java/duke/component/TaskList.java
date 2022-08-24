package duke.component;

import duke.exception.DukeException;
import duke.task.Task;

import java.util.ArrayList;

public class TaskList {

    protected ArrayList<Task> tasks;
    public static final String DONE = "Nice! I've marked this task as done:\n";
    public static final String UNDONE =  "OK, I've marked this task as not done yet:\n";
    public static final String ADD = "Got it. I've added this task:\n";
    public static final String DELETE = "Noted. I've removed this task:\n";
    public static final String NUMBER_START = "Now you have ";
    public static final String NUMBER_END = " tasks in the list.";


    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder allTasks = new StringBuilder();
        for (int i = 1; i <= this.tasks.size(); i++) {
            allTasks.append(i + ". " + this.tasks.get(i - 1));
            if (i < this.tasks.size()) {
                allTasks.append("\n");
            }
        }
        return allTasks.toString();
    }

    public String toStorage() {
        StringBuilder storage = new StringBuilder();

        for (Task task : this.tasks) {
            storage.append(task.toStorage() + System.lineSeparator());
        }

        return storage.toString();
    }

    public String addTask(Task task) {
        this.tasks.add(task);
        return ADD + task.toString() + "\n" + NUMBER_START + this.tasks.size() + NUMBER_END;
    }

    public String deleteTask(int index) throws DukeException {
        if (index < 0 || index >= this.tasks.size()) {
            throw new DukeException("There is no such task number!");
        }
        Task task = this.tasks.remove(index);
        return DELETE + task.toString() + "\n" + NUMBER_START + this.tasks.size() + NUMBER_END;
    }

    public String markTask(int index) throws DukeException {
        if (index < 0 || index >= this.tasks.size()) {
            throw new DukeException("There is no such task number!");
        }
        return DONE + this.tasks.get(index).markAsDone();
    }

    public String unmarkTask(int index) throws DukeException {
        if (index < 0 || index >= this.tasks.size()) {
            throw new DukeException("There is no such task number!");
        }
        return UNDONE + this.tasks.get(index).markAsUndone();
    }
}