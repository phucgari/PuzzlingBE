package com.casestudymodule6.repository;

import com.casestudymodule6.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User,Long>
{
    @Query("select user from User user join user.account account where account.username = :username")
    Optional<User> findUserByUsername(@Param("username") String username);
}
