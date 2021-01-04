package com.OMe.web;


import com.OMe.config.auth.LoginUser;
import com.OMe.config.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class indexController {

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user)
    {

        if (user != null){
            model.addAttribute("userName" , user.getName());
        }

        return "index";
    }

    @GetMapping("/map")
    public String map(Model model, @LoginUser SessionUser user) {

        if (user != null){
            model.addAttribute("userName", user.getName());
        }

        return "map3";
    }

}
