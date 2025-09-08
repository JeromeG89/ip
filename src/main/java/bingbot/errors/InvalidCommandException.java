package bingbot.errors;

/**
 * Indicates that the user has entered an invalid command.
 */
public class InvalidCommandException extends RuntimeException {
    public InvalidCommandException() {
        super("❌ Invalid command type, say 'help' for more");
    }
}
