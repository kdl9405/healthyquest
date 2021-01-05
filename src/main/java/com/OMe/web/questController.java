package com.OMe.web;

import com.OMe.config.auth.LoginUser;
import com.OMe.config.auth.dto.SessionUser;
import com.OMe.service.equipment.EquipmentService;
import com.OMe.service.quest.QuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RequiredArgsConstructor
@Controller
public class questController {

    private final QuestService questService;
    private final EquipmentService equipmentService;

    @GetMapping("/equip/quest/{id}")
    public String showQuest(@PathVariable Long id, Model model, @LoginUser SessionUser user){

        model.addAttribute("user",user);
        model.addAttribute("equipment", equipmentService.findById(id));
        model.addAttribute("quests", questService.findByEquipment(id));

        return "quest";
    }

    @GetMapping("/equip/quest/confirm/{eid}/{qid}")
    public String confirmQuest(@PathVariable Long eid, @PathVariable Long qid, @LoginUser SessionUser user, Model model){

        model.addAttribute("user",user);
        model.addAttribute("equipment", equipmentService.findById(eid));
        model.addAttribute("quest", questService.findById(qid));


        return "confirmquest";
    }

}
