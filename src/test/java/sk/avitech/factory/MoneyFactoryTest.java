package sk.avitech.factory;

import org.junit.jupiter.api.Test;
import sk.avitech.model.Bill;
import sk.avitech.model.Coin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MoneyFactoryTest {
    @Test
    public void createsListOfBills() {
        String[] money = {"10", "5"};

        var moneyList = MoneyFactory.parse(money);

        assertEquals(2, moneyList.size());

        var firstMoneyListElement = moneyList.get(0);
        var secondMoneyListElement = moneyList.get(1);

        assertEquals(Bill.class, firstMoneyListElement.getClass());
        assertEquals(Bill.class, secondMoneyListElement.getClass());

        assertEquals(10, firstMoneyListElement.getValue());
        assertEquals(5, secondMoneyListElement.getValue());
    }

    @Test
    public void createsListOfCoins() {
        String[] money = {"1m", "2m"};

        var moneyList = MoneyFactory.parse(money);

        assertEquals(2, moneyList.size());

        var firstMoneyListElement = moneyList.get(0);
        var secondMoneyListElement = moneyList.get(1);

        assertEquals(Coin.class, firstMoneyListElement.getClass());
        assertEquals(Coin.class, secondMoneyListElement.getClass());

        assertEquals(1, firstMoneyListElement.getValue());
        assertEquals(2, secondMoneyListElement.getValue());
    }

    @Test
    public void createsMixedList() {
        String[] money = {"1m", "100", "2m"};

        var moneyList = MoneyFactory.parse(money);

        assertEquals(3, moneyList.size());

        var firstMoneyListElement = moneyList.get(0);
        var secondMoneyListElement = moneyList.get(1);
        var thirdMoneyListElement = moneyList.get(2);

        assertEquals(Coin.class, firstMoneyListElement.getClass());
        assertEquals(Bill.class, secondMoneyListElement.getClass());
        assertEquals(Coin.class, thirdMoneyListElement.getClass());

        assertEquals(1, firstMoneyListElement.getValue());
        assertEquals(100, secondMoneyListElement.getValue());
        assertEquals(2, thirdMoneyListElement.getValue());
    }

    @Test
    public void throwsOnNonNumericValue() {
        String[] money = {"jm"};

        assertThrows(NumberFormatException.class, () -> MoneyFactory.parse(money));
    }
}
