package com.OMe.web.dto;

import com.OMe.domain.avatar.Avatar;
import com.OMe.domain.user.User;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UserResponseDto {

    private Long id;
    private String name;
    private String email;
    private Avatar avatar;

    @Builder
    public UserResponseDto(User entity){
        this.id = entity.getId();
        this.name = entity.getName();
        this.email = entity.getEmail();
        this.avatar = entity.getAvatar();

    }

}
