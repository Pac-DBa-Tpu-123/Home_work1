package main.hw2;

import java.util.Random;

public class Task3 {

    private Task3() {
    }

    public interface Connection extends AutoCloseable {
        void execute(String command);
    }

    public interface ConnectionManager {
        Connection getConnection();
    }

    public static class ConnectionException extends RuntimeException {
        public ConnectionException(String message) {
            super(message);
        }

        public ConnectionException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static class StableConnection implements Connection {
        @Override
        public void execute(String command) {
        }

        @Override
        public void close() {
        }
    }

    public static class FaultyConnection implements Connection {
        private static final Random RANDOM = new Random();

        @Override
        public void execute(String command) {
            if (RANDOM.nextBoolean()) {
                throw new ConnectionException("Проблемное соединение не смогло выполнить команду");
            }
        }

        @Override
        public void close() {
        }
    }

    public static class AlwaysFaultyConnection implements Connection {
        @Override
        public void execute(String command) {
            throw new ConnectionException("Всегда проблемное соединение не смогло выполнить команду");
        }

        @Override
        public void close() {
        }
    }

    public static class DefaultConnectionManager implements ConnectionManager {
        private static final Random RANDOM = new Random();

        @Override
        public Connection getConnection() {
            if (RANDOM.nextBoolean()) {
                return new StableConnection();
            } else {
                return new FaultyConnection();
            }
        }
    }

    public static class FaultyConnectionManager implements ConnectionManager {
        @Override
        public Connection getConnection() {
            return new AlwaysFaultyConnection();
        }
    }

    public static final class PopularCommandExecutor {
        private final ConnectionManager manager;
        private final int maxAttempts;

        public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
            this.manager = manager;
            this.maxAttempts = maxAttempts;
        }

        public void updatePackages() {
            tryExecute("apt update && apt upgrade -y");
        }

        void tryExecute(String command) {
            int attempts = 0;
            while (attempts < maxAttempts) {
                try (Connection connection = manager.getConnection()) {
                    connection.execute(command);
                    return;
                } catch (ConnectionException e) {
                    attempts++;
                    if (attempts >= maxAttempts) {
                        throw new ConnectionException("Не удалось выполнить команду после " + maxAttempts + " попыток",
                            e);
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
