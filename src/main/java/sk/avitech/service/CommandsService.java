package sk.avitech.service;

public class CommandsService {
    public static void validateInputArguments(String[] args) {
        if (args.length != 1) {
            throw new IllegalArgumentException("Number of supplied argument is not supported");
        }
    }
}
