public class Logger {
    // Static variable to hold the single instance of the Logger class
    private static Logger instance = null;

    // Private constructor to prevent instantiation from other classes
    private Logger() {
    }

    // Public method to provide access to the instance
    public static Logger getInstance() {
        if (instance == null) {
            // Create the instance if it doesn't exist
            instance = new Logger();
        }
        return instance;
    }

    // Method to log a message
    public void log(String message) {
        // In a real-world application, this might write to a file, database, etc.
        System.out.println("Log message: " + message);
    }

    // Method to log an error
    public void logError(String error) {
        // In a real-world application, this might write to a file, database, etc.
        System.err.println("Error message: " + error);
    }
}

// Usage example:
class Main {
    public static void main(String[] args) {
        // Attempt to create multiple instances of Logger
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Both variables should point to the same instance
        assert logger1 == logger2;

        // Log a message using the first instance
        logger1.log("This is a log message.");

        // Log an error using the second instance
        logger2.logError("This is an error message.");
    }
}
