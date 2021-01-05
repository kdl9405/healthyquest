package com.OMe.web.dto;

import com.OMe.domain.avatar.Avatar;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserUpdateRequestDto {

    private String name;
    private String picture;
    private Avatar avatar;

    @Builder
    public UserUpdateRequestDto(String name, String picture, Avatar avatar){
        this.name = name;
        this.picture = picture;
        this.avatar = avatar;
    }
}
