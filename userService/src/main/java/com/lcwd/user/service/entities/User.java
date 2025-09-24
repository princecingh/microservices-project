package com.lcwd.user.service.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "micro_users")
public class User {
    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "Name",length = 20)
    private String name;

    @Column(name = "Email",length = 30,unique = true)
    private String email;

    @Column(name = "About",length = 100)
    private String about;

    @Transient
    private List<Rating> ratings = new ArrayList<>();

}
