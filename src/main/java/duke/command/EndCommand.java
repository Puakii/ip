package duke.command;

import duke.exception.DukeException;

/**
 * Represents a command to end the application.
 */
public class EndCommand extends Command {

    public static final String END = "Bye! Hope you had fun!";

    /**
     * Constructs a new EndCommand.
     */
    public EndCommand() {
        super();
    }

    /**
     * Returns the exit message.
     *
     * @return String representation of the message in response to the command.
     */
    @Override
    public String run() {
        return END;
    }
}