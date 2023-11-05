package sk.avitech.model;

import java.util.ArrayList;
import java.util.List;

public class Cabinet {
    private List<Wallet> wallets;

    public Cabinet() {
        this(new ArrayList<>());
    }

    public Cabinet(List<Wallet> wallets) {
        this.wallets = wallets;
    }

    public List<Wallet> getWallets() {
        return this.wallets;
    }

    public Wallet getWalletOfOwner(String ownerName) {
        return this.wallets
            .stream()
            .filter(
                    wallet -> wallet.getOwner().getName().equalsIgnoreCase(ownerName)
            )
            .findFirst()
            .orElse(null);
    }
}
