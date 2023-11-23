package bridge.handler;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ExceptionRetryHandler {

    private final Consumer<String> messagePrinter;

    public ExceptionRetryHandler(Consumer<String> messagePrinter) {
        this.messagePrinter = messagePrinter;
    }

    public <T> T retryUntilValid(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                messagePrinter.accept(e.getMessage());
            }
        }
    }
}
