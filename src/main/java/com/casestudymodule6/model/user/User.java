package com.casestudymodule6.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String avatar;
    String email;
    String phone;
    @Enumerated(EnumType.STRING)
    Gender gender;
    @OneToOne
    @JsonIgnore
    private Account account;
    public enum Gender{
        MALE,FEMALE
    }
}
