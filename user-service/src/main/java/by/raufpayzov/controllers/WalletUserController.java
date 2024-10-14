package by.raufpayzov.controllers;

import by.raufpayzov.entity.WalletUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/wallet")
public class WalletUserController {
    @GetMapping
    public List<WalletUser> walletUsers() {
        WalletUser user = new WalletUser(1L,"Rauf");
        WalletUser user2 = new WalletUser(2L,"Elmar");

        List< WalletUser> users = new ArrayList<>();

        users.add(user);
        users.add(user2);

        return users;
    }
    @GetMapping("/secured")
    public String secured () {
        return "Hello, Secured!";
    }
}
