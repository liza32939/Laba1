package Task3;

// Власний клас виключень для викликаних методів
class FunctionNotFoundException extends Exception {
    public FunctionNotFoundException(String message) {
        super(message);
    }
}