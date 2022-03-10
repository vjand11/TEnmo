package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.JdbcAccountDao;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
public class AccountController {

    private JdbcAccountDao dao;

    public AccountController(JdbcAccountDao dao) {
        this.dao = dao;
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(path = "balance/{username}", method = RequestMethod.GET)
    public BigDecimal balance (@PathVariable String username) {
        return dao.getAccountBalanceByUsername(username);
    }
}