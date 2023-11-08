package sk.avitech.service;

import java.nio.file.InvalidPathException;
import java.nio.file.Path;

public class CommandsService {
    public static void validateInputArguments(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("Number of supplied arguments is not supported");
        }

        try {
            Path.of(args[1]);
        } catch (InvalidPathException e) {
            System.err.println("Second argument is not a valid file path");
            throw e;
        }
    }
}
