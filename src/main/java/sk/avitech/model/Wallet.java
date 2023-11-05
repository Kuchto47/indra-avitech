package sk.avitech.model;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Wallet {
    private Person owner;
    private List<Money> money;

    public Wallet(Person owner, List<Money> money) {
        this.owner = owner;
        this.money = money;
    }

    public Person getOwner() {
        return this.owner;
    }

    public List<Money> getMoney() {
        return this.money;
    }

    public int smallestValue() {
        return Collections.min(this.money, Comparator.comparing(Money::getValue)).getValue();
    }

    public int highestValue() {
        return Collections.max(this.money, Comparator.comparing(Money::getValue)).getValue();
    }
}
