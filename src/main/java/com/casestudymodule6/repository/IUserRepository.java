package com.casestudymodule6.repository;

import com.casestudymodule6.model.user.Account;
import com.casestudymodule6.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Long> {
    public User findUserByAccount(Account account);
}
