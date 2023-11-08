package sk.avitech.service;

import org.junit.jupiter.api.Test;

import java.nio.file.InvalidPathException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CommandsServiceTest {
    @Test
    public void throwsOnZeroArgsSupplied() {
        assertThrows(IllegalArgumentException.class, () -> CommandsService.validateInputArguments(new String[]{}));
    }

    @Test
    public void throwsOnThreeArgsSupplied() {
        assertThrows(IllegalArgumentException.class, () -> CommandsService.validateInputArguments(new String[]{"One", "Two", "Three"}));
    }

    @Test
    public void throwsOnOneArgsSupplied() {
        assertThrows(IllegalArgumentException.class, () -> CommandsService.validateInputArguments(new String[]{"One"}));
    }

    @Test
    public void doesNotThrowOnTwoArgSupplied() {
        assertDoesNotThrow(() -> CommandsService.validateInputArguments(new String[]{"One", "./csvFile/csv.csv"}));
    }

    @Test
    public void throwsOnInvalidPathAsSecondArgument() {
        assertThrows(InvalidPathException.class, () -> CommandsService.validateInputArguments(new String[]{"One", "?"}));
    }
}
