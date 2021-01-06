package com.OMe.web.dto.progress;

import com.OMe.domain.equipment.Equipment;
import com.OMe.domain.progress.Progress;
import com.OMe.domain.user.User;

public class ProgressResponseDto {

    private Long id;
    private Integer now_stage;
    private Equipment equipment;
    private User user;

    public ProgressResponseDto(Progress entity){
        this.id = entity.getId();
        this.now_stage = entity.getNow_stage();
        this.equipment = entity.getEquipment();
        this.user = entity.getUser();
    }
}
