package duke.command;

import duke.component.TaskList;
import duke.exception.DukeException;

/**
 * Represents a command to mark a task in the TaskList as done.
 */
public class MarkCommand extends Command {

    /**
     * Constructs a new MarkCommand.
     *
     * @param content Content of the user command.
     * @param tasks List of all tasks.
     */
    public MarkCommand(String content, TaskList tasks) {
        super(content, tasks);
    }

    /**
     * Marks the task in the TaskList as done.
     *
     * @return String representation of the message in response to the command.
     * @throws DukeException If the content of the user command does not include an integer.
     */
    @Override
    public String run() throws DukeException {
        String reply;
        try {
            reply = tasks.markTask(Integer.parseInt(content) - 1);
        } catch (NumberFormatException e) {
            throw new DukeException("Task number need to be an integer!");
        }
        return reply;
    }
}
