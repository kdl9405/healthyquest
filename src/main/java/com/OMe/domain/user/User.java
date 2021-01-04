package com.OMe.domain.user;


import com.OMe.domain.avatar.Avatar;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

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

    @Column
    private String picture;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "avatar_id")
    @ColumnDefault("null")
    private Avatar avatar;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Builder
    public User(String name, String email , String picture ,Role role, Avatar avatar){
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
        this.avatar = avatar;
    }

    public User update(String name, String picture){
        this.name = name;
        this.picture = picture;

        return this;
    }

    public User avatarUpdate(Avatar avatar){

        this.avatar = avatar;

        return this;
    }

    public String getRoleKey(){
        return this.role.getKey();
    }


}
