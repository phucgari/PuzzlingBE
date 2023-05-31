package com.casestudymodule6.controller;

import com.casestudymodule6.model.dto.ChangePasswordDTO;
import com.casestudymodule6.model.user.Account;
import com.casestudymodule6.model.user.User;
import com.casestudymodule6.service.account.IAccountService;
import com.casestudymodule6.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("puzzling/users")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private IUserService userService;

    @Autowired
    private IAccountService accountService;

    @GetMapping("/")
    public ResponseEntity<Iterable<User>> getAllUsers() {
        List<User> users = (List<User>) userService.findAll();
        if (users.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        Optional<User> userOptional = userService.findById(id);
        if (userOptional.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        user.setId(userOptional.get().getId());
        return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id) {
        Optional<User> userOptional = userService.findById(id);
        if (userOptional.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        userService.remove(id);
        return new ResponseEntity<>(userOptional.get(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> viewUserDetail(@PathVariable("id") Long id) {
        Optional<User> userOptional = userService.findById(id);
        return userOptional.map(user -> new ResponseEntity<>(user, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/changePassword/{accountId}")
    public ResponseEntity<Void> changePassword(@PathVariable("accountId") Long accountId, @RequestBody ChangePasswordDTO changePasswordDTO)
    {
        Optional<Account> account = accountService.findById(accountId);
        if (account.get().getPassword().equals(changePasswordDTO.getOldPassword()))
        {
            if (changePasswordDTO.getConfirmPassword().equals(changePasswordDTO.getNewPassword()))
            {
                account.get().setPassword(changePasswordDTO.getNewPassword());
                accountService.save(account.get());
                return new ResponseEntity<>(HttpStatus.OK);
            }
            else
            {
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);

    }

    @GetMapping("/check/{account}")
    public ResponseEntity<String> checkUserName(@RequestParam String password, @PathVariable Account account) {
        if(Objects.equals(account.getPassword(), password)) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
