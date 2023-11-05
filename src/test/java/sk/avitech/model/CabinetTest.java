package sk.avitech.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CabinetTest {
    private Cabinet cabinet;

    @BeforeEach
    public void setup() {
        var wallet1 = new Wallet(
                new Person("Peto"),
                new ArrayList<>(){{
                    add(new Coin(2));
                    add(new Bill(5));
                }}
        );
        var wallet2 = new Wallet(
                new Person("Martin"),
                new ArrayList<>(){{
                    add(new Coin(1));
                    add(new Bill(500));
                }}
        );
        this.cabinet = new Cabinet(List.of(wallet1, wallet2));
    }

    @Test
    public void findsWalletForOwner() {
        var wallet = cabinet.getWalletOfOwner("Martin");

        assertNotNull(wallet);

        assertEquals("Martin", wallet.getOwner().getName());

        assertEquals(1, wallet.getMoney().get(0).getValue());
        assertEquals(500, wallet.getMoney().get(1).getValue());
    }

    @Test
    public void returnsNullForNonExistingOwner() {
        var wallet = cabinet.getWalletOfOwner("ADAM");

        assertNull(wallet);
    }
}
