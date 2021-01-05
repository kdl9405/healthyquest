package com.OMe.web.dto.quest;

import com.OMe.domain.equipment.Equipment;
import com.OMe.domain.quest.Quest;

public class QuestResponseDto {

    private Long id;
    private String content;
    private Integer stage;
    private Integer point;
    private Equipment equipment;

    public QuestResponseDto(Quest entity){
        this.id = entity.getId();
        this.content = entity.getContent();
        this.stage = entity.getStage();
        this.point = entity.getPoint();
        this.equipment = entity.getEquipment();
    }
}
