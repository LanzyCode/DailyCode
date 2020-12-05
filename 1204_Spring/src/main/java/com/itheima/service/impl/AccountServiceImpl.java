package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
@Component
public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountdao) {
        this.accountDao = accountDao;
    }

    public void save(Account account) {

    }

    public void update(Account account){

    }

    public void delete(Integer id) {

    }

    public Account findById(Integer id) {
        return null;
    }

    public List<Account> findAll() {
        return null;
    }
}
