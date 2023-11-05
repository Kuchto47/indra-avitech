package sk.avitech.service.csv;

import sk.avitech.factory.MoneyFactory;
import sk.avitech.model.Person;
import sk.avitech.model.Wallet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvParserService {
    public static List<Wallet> getWalletsFromCsvLines(List<String[]> lines) {
        try {
            List<Wallet> wallets = new ArrayList<>();
            lines.forEach(lineTokens -> {
                var ownerName = lineTokens[0];
                String[] money = Arrays.copyOfRange(lineTokens, 1, lineTokens.length);
                Wallet wallet = new Wallet(
                        new Person(ownerName),
                        MoneyFactory.parse(money)
                );
                wallets.add(wallet);
            });
            return wallets;
        } catch (NumberFormatException e) {
            System.err.println("Supplied CSV file is of unsupported format.");
            throw e;
        }
    }
}
