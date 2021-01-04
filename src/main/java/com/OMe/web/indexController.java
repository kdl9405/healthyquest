package com.OMe.web;


import com.OMe.config.auth.LoginUser;
import com.OMe.config.auth.dto.SessionUser;
import com.OMe.service.user.UserService;
import com.OMe.web.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class indexController {

    private final UserService userService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user)
    {

        if (user != null){
            model.addAttribute("user" , user);
        }

        return "index";
    }

    @GetMapping("/character/create/{id}")
    public String characterCreate(@PathVariable Long id, Model model){

        UserResponseDto dto = userService.findById(id);

        model.addAttribute("user",dto);

        return "character";
    }

    @GetMapping("/map")
    public String map(Model model, @LoginUser SessionUser user) {

        if (user != null){
            model.addAttribute("user", user.getName());
        }

        return "map3";
    }

}
