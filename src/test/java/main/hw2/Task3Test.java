package main.hw2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class Task3Test {

    private Task3.ConnectionManager manager;
    private Task3.PopularCommandExecutor executor;

    @BeforeEach
    public void setUp() {
        manager = new Task3.DefaultConnectionManager();
        executor = new Task3.PopularCommandExecutor(manager, 3);
    }

    @Test
    public void testUpdatePackagesSuccess() {
        executor.updatePackages();
    }

    @Test
    public void testTryExecuteSuccess() {
        executor.tryExecute("some command");
    }

    @Test
    public void testTryExecuteFailure() {
        manager = new Task3.FaultyConnectionManager();
        executor = new Task3.PopularCommandExecutor(manager, 3);

        assertThatThrownBy(() -> executor.tryExecute("some command"))
            .isInstanceOf(Task3.ConnectionException.class)
            .hasMessageContaining("Не удалось выполнить команду после 3 попыток");
    }

    @Test
    public void testTryExecuteMixedSuccessAndFailure() {
        executor.tryExecute("some command");
    }
}
