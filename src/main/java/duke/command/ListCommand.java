package duke.command;

import duke.component.TaskList;
import duke.exception.DukeException;

/**
 * Represents a command to list all tasks in the TaskList.
 */
public class ListCommand extends Command {

    public static final String LIST = "Here are the tasks in your list:\n";

    /**
     * Constructs a new ListCommand.
     *
     * @param tasks List of all tasks.
     */
    public ListCommand(TaskList tasks) {
        super(tasks);
    }

    /**
     * Returns the String representation of the TaskList.
     *
     * @return String representation of the message in response to the command.
     */
    @Override
    public String run() {
        return LIST + this.tasks.toString();
    }

}