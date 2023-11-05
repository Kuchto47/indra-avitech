package sk.avitech.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CommandsServiceTest {
    @Test
    public void throwsOnZeroArgsSupplied() {
        assertThrows(IllegalArgumentException.class, () -> CommandsService.validateInputArguments(new String[]{}));
    }

    @Test
    public void throwsOnTwoArgsSupplied() {
        assertThrows(IllegalArgumentException.class, () -> CommandsService.validateInputArguments(new String[]{"One", "Two"}));
    }

    @Test
    public void doesNotThrowOnOneArgSupplied() {
        assertDoesNotThrow(() -> CommandsService.validateInputArguments(new String[]{"One"}));
    }
}
