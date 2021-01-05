package com.OMe.domain.avatar;


import com.OMe.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Getter
@NoArgsConstructor
@Entity
public class Avatar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String picture;


    @OneToMany(mappedBy = "avatar",cascade = CascadeType.ALL)
    private Set<User> users;

    @Builder
    public Avatar(String name, String picture){
        this.name = name;
        this.picture = picture;
    }

}
