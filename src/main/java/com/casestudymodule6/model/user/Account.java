package com.casestudymodule6.model.user;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @ManyToOne
    @NotNull
    @JoinColumn(name="role_id",referencedColumnName = "id")
    private Role role;
    @Size(min=6,max = 32)
    @NotNull
    private String username;
    @Size(min=6,max = 32)
    @NotNull
    private String password;
}
