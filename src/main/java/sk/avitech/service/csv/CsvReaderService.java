package sk.avitech.service.csv;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvReaderService {
    public static List<String[]> readCsvFile(Path path, Character separator) throws IOException {
        try (Reader reader = Files.newBufferedReader(path)) {
            CSVParser parser = new CSVParserBuilder()
                    .withSeparator(separator)
                    .build();
            try (
                    CSVReader csvReader = new CSVReaderBuilder(reader)
                        .withSkipLines(0)
                        .withCSVParser(parser)
                        .build()
            ) {
                return csvReader.readAll();
            }
        }
    }

    public static List<String[]> readCsvFile(Path path) throws IOException {
        return readCsvFile(path, ';');
    }
}
