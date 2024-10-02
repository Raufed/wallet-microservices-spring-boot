package by.raufpayzov.wallet.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/wallet")
public class WalletController {
    @GetMapping
    public String yourWallet() {
        return "Wallet's here!";
    }
}
