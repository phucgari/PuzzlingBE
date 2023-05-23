package com.casestudymodule6.model.question;

import com.casestudymodule6.model.user.User;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data
public class Exam implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "exam_id")
    private Set<Question> questions;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private User user;
}
