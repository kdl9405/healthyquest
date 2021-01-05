package com.OMe.web;

import com.OMe.config.auth.LoginUser;
import com.OMe.config.auth.dto.SessionUser;
import com.OMe.service.quest.QuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class questController {

    private final QuestService questService;

    @GetMapping("/equip/quest/{id}")
    public String showQuest(@PathVariable Long id, Model model, @LoginUser SessionUser user){

        model.addAttribute("user",user);
        model.addAttribute("quests", questService.findByEquipment(id));

        return "quest";
    }
}
