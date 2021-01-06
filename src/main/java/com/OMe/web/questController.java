package com.OMe.web;

import com.OMe.config.auth.LoginUser;
import com.OMe.config.auth.dto.SessionUser;
import com.OMe.service.equipment.EquipmentService;
import com.OMe.service.progress.ProgressService;
import com.OMe.service.quest.QuestService;
import com.OMe.service.user.UserService;
import com.OMe.web.dto.UserResponseDto;
import com.OMe.web.dto.quest.QuestResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class questController {

    private final QuestService questService;
    private final EquipmentService equipmentService;
    private final ProgressService  progressService;
    private  final UserService userService;

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

    @GetMapping("/progress/update/{point}")
    public String progressUpdate(@PathVariable Integer point, @LoginUser SessionUser user, Model model){

        userService.PointUpdate(user.getId(),point);

        model.addAttribute("user",user);

        List<UserResponseDto> users = userService.findByAllDese();
        for (int i = 1; i<=users.size(); i++){
            if(users.get(i).getId() == user.getId()){
                model.addAttribute("rank",i);
                break;
            }
        }

        return "ranking";
    }

}
