package com.casestudymodule6.security;

import com.casestudymodule6.model.question.Exam;
import com.casestudymodule6.model.user.Account;
import com.casestudymodule6.model.user.User;
import com.casestudymodule6.service.account.IAccountService;
import com.casestudymodule6.service.exam.IExamService;
import com.casestudymodule6.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AuthorizationEvaluator {
    @Autowired
    private IExamService examService;
    @Autowired
    private IAccountService accountService;
    @Autowired
    private IUserService userService;
    public boolean canUpdateThisExam(Long examId){
        Optional<Exam> optionalExam=examService.findById(examId);
        Account acc =accountService.findByUser(optionalExam.get().getUser());
        Authentication a= SecurityContextHolder.getContext().getAuthentication();
        return acc.getUsername().equals(a.getName());
    }
    public boolean canUpdateThisUser(Long userId, User user){
        Authentication a= SecurityContextHolder.getContext().getAuthentication();
        Account accountFromUser=accountService.findByUser(user);
        User userFromUserId=userService.findById(userId).get();
        Account accountFromUserId=accountService.findByUser(userFromUserId);
        return a.getName().equals(accountFromUser.getUsername())&&
                accountFromUser.getUsername().equals(accountFromUserId.getUsername());
    }
    public boolean canChangePassword(Long accountId){
        Authentication a= SecurityContextHolder.getContext().getAuthentication();
        Account account=accountService.findById(accountId).get();
        return account.getUsername().equals(a.getName());
    }
}
