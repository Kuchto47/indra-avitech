package sk.avitech;

import sk.avitech.model.Cabinet;
import sk.avitech.service.CommandsService;
import sk.avitech.service.csv.CsvParserService;
import sk.avitech.service.csv.CsvReaderService;

import java.io.IOException;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        CommandsService.validateInputArguments(args);

        try {
            var csvFile = CsvReaderService.readCsvFile(Path.of("./csvFile/csv.csv"));
            var cabinet = new Cabinet(CsvParserService.getWalletsFromCsvLines(csvFile));
            var wallet = cabinet.getWalletOfOwner(args[0]);
            if (wallet == null) {
                System.out.println("WARN: Wallet of supplied user couldn't be found in the wallets cabinet");
            } else {
                System.out.println("Smallest value in wallet: " + wallet.smallestValue() + "; Highest value in wallet: " + wallet.highestValue());
            }
        } catch (IOException e) {
            System.err.println("Couldn't read CSV file on expected path");
        }
    }
}