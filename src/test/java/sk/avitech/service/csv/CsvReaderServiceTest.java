package sk.avitech.service.csv;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CsvReaderServiceTest {
    @Test
    public void test() throws IOException {
        var csvFile = CsvReaderService.readCsvFile(Path.of("./src/test/resources/testCsv.csv"));

        assertEquals(3, csvFile.size());

        var firstLine = csvFile.get(0);
        assertEquals(3, firstLine.length);
        assertEquals("Adam", firstLine[0]);
        assertEquals("2m", firstLine[1]);
        assertEquals("20", firstLine[2]);

        var secondLine = csvFile.get(1);
        assertEquals(3, secondLine.length);
        assertEquals("Martin", secondLine[0]);
        assertEquals("", secondLine[1]);
        assertEquals("", secondLine[2]);

        var thirdLine = csvFile.get(2);
        assertEquals(3, thirdLine.length);
        assertEquals("Jakub", thirdLine[0]);
        assertEquals("500", thirdLine[1]);
        assertEquals("1m", thirdLine[2]);
    }
}
