package com.casestudymodule6.controller;

import com.casestudymodule6.model.user.Account;
import com.casestudymodule6.model.user.Role;
import com.casestudymodule6.model.user.User;
import com.casestudymodule6.service.account.AccountServiceImpl;
import com.casestudymodule6.service.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/puzzling")
public class LoginController {
    @Autowired
    AccountServiceImpl accountService;
    @Autowired
    UserServiceImpl userService;

    @PostMapping("/register")
    public ResponseEntity<Account> registerAccount(@RequestBody Account account) {
        Account registeredAccount = accountService.register(account);
        if (registeredAccount != null) {
            return new ResponseEntity<>(registeredAccount, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }


    @PostMapping("/login")
    public ResponseEntity<Account> loginAccount(@RequestBody Account account) {
        Account checkAccount = accountService.findByUsername(account.getUsername());
        if (checkAccount == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(checkAccount, HttpStatus.OK);
    }

    @GetMapping("/check")
    public ResponseEntity<String> checkUserName(@RequestParam String username) {
        Optional<Account> account = Optional.ofNullable(accountService.findByUsername(username));
        if (account.isEmpty()){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

}
