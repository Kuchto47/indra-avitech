package sk.avitech.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WalletTest {
    @Test
    public void calculatesSmallestAndHighestValues() {
        var wallet = new Wallet(
            new Person("Owner"),
            new ArrayList<>(){{
                add(new Coin(2));
                add(new Bill(5));
            }}
        );

        assertEquals(2, wallet.smallestValue());
        assertEquals(5, wallet.highestValue());
    }
}
