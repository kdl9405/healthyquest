package com.OMe.domain.user;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "character_id")
    private Character character;


    @Builder
    public User(String name, String email){
        this.name = name;
        this.email = email;
    }

    public User update(String name, Character character){
        this.name = name;
        this.character = character;

        return this;
    }


}
