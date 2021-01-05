package com.OMe.web;

import com.OMe.config.auth.LoginUser;
import com.OMe.config.auth.dto.SessionUser;
import com.OMe.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class userController {

    private final UserService userService;

    @PutMapping("/user/avatar/{cid}")
    public Long update(@LoginUser SessionUser user, @PathVariable Long cid) {

        return userService.AvatarUpdate(user.getId(), cid);
    }
}
