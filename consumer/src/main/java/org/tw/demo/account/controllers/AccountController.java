package org.tw.demo.account.controllers;


import org.springframework.web.bind.annotation.*;
import org.tw.demo.account.commands.AccountCommand;
import org.tw.demo.account.domains.Account;
import org.tw.demo.account.services.AccountService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/account")
public class AccountController {


    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/create")
    public Map<String,String> createAccount(@RequestBody AccountCommand accountCommand){

        return  accountService.createAccount(accountCommand);

    }

    @GetMapping("/")
    public List<Account> getAllaccounts(){
        return accountService.getAllaccounts();
    }

    @GetMapping("/{id}")
    public Account getAccountDetails(@PathVariable String id){
       return accountService.getAccountDetails(id);
    }
}
