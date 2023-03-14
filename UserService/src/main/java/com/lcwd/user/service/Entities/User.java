package com.lcwd.user.service.Entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "micro_users")
public class User {

    @Id
    @Column(name = "id")
    private String userId;

    @Column(name = "name", length = 25)
    private String name;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "about")
    private String about;

    @Transient
    private List<Rating> ratings = new ArrayList<>();
}
