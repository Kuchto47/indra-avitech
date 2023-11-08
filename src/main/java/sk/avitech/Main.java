package sk.avitech;

import com.opencsv.exceptions.CsvException;
import sk.avitech.model.Cabinet;
import sk.avitech.service.CommandsService;
import sk.avitech.service.csv.CsvParserService;
import sk.avitech.service.csv.CsvReaderService;

import java.io.IOException;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        CommandsService.validateInputArguments(args);

        var ownerName = args[0];
        var csvFilePath = args[1];

        try {
            var csvFile = CsvReaderService.readCsvFile(Path.of(csvFilePath));
            var cabinet = new Cabinet(CsvParserService.getWalletsFromCsvLines(csvFile));
            var wallet = cabinet.getWalletOfOwner(ownerName);
            if (wallet == null) {
                System.out.println("WARN: Wallet of supplied user couldn't be found in the wallets cabinet");
            } else {
                System.out.println("Smallest value in wallet: " + wallet.smallestValue() + "; Highest value in wallet: " + wallet.highestValue());
            }
        } catch (IOException e) {
            System.err.println("Couldn't read CSV file on expected path");
        } catch (CsvException e) {
            System.err.println("Couldn't read CSV file's content");
        }
    }
}