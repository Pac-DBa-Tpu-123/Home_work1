package main.hw2;

public class Task4 {

    private Task4() {
    }

    private static final int MIN_LENGTH = 3;

    public static CallingInfo callingInfo() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

        if (stackTrace.length < MIN_LENGTH) {
            throw new IllegalStateException("Недостаточно элементов в стеке вызова");
        }

        StackTraceElement caller = stackTrace[2];

        return new CallingInfo(caller.getClassName(), caller.getMethodName());
    }

    public record CallingInfo(String className, String methodName) {}
}
