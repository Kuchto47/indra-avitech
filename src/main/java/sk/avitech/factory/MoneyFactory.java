package sk.avitech.factory;

import sk.avitech.model.Bill;
import sk.avitech.model.Coin;
import sk.avitech.model.Money;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MoneyFactory {
    public static List<Money> parse(String[] money) {
        return Arrays.stream(money).map(MoneyFactory::parse).collect(Collectors.toList());
    }

    public static Money parse(String money) {
        return money.endsWith("m")
            ? new Coin(Integer.parseInt(money.substring(0, money.length() - 1)))
            : new Bill(Integer.parseInt(money));
    }
}
