package sk.avitech.service.csv;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CsvParserServiceTest {
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalErr = System.err;

    @Test
    public void parsingOfSupportedDataWorksCorrectly() {
        List<String[]> csvLines = new ArrayList<>(){{
            add(new String[]{"Martin", "5", "2m"});
            add(new String[]{"Klingac", "1m", "50", "20"});
        }};

        var wallets = CsvParserService.getWalletsFromCsvLines(csvLines);

        assertEquals(2, wallets.size());

        assertEquals("Martin", wallets.get(0).getOwner().getName());
        assertEquals(5, wallets.get(0).getMoney().get(0).getValue());
        assertEquals(2, wallets.get(0).getMoney().get(1).getValue());

        assertEquals("Klingac", wallets.get(1).getOwner().getName());
        assertEquals(1, wallets.get(1).getMoney().get(0).getValue());
        assertEquals(50, wallets.get(1).getMoney().get(1).getValue());
        assertEquals(20, wallets.get(1).getMoney().get(2).getValue());
    }

    @Test
    public void parsingOfUnsupportedDataThrows() {
        System.setErr(new PrintStream(errContent));

        List<String[]> csvLines = new ArrayList<>(){{
            add(new String[]{"Martin", "p", "2m"});
        }};

        assertThrows(NumberFormatException.class, () -> CsvParserService.getWalletsFromCsvLines(csvLines));
        assertEquals("Supplied CSV file is of unsupported format." + System.lineSeparator(), errContent.toString());

        System.setErr(originalErr);
    }

    @Test
    public void parsingOfEmptyDataThrows() {
        System.setErr(new PrintStream(errContent));

        List<String[]> csvLines = new ArrayList<>(){{
            add(new String[]{"Martin", "50", ""});
        }};

        assertThrows(NumberFormatException.class, () -> CsvParserService.getWalletsFromCsvLines(csvLines));
        assertEquals("Supplied CSV file is of unsupported format." + System.lineSeparator(), errContent.toString());

        System.setErr(originalErr);
    }
}
