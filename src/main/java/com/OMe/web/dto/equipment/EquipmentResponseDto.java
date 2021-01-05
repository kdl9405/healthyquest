package com.OMe.web.dto.equipment;

import com.OMe.domain.equipment.Equipment;

public class EquipmentResponseDto {

    private Long id;
    private String name;
    private String qr_code;
    private String description;

    public EquipmentResponseDto(Equipment entity){
        this.id = entity.getId();
        this.name = entity.getName();
        this.qr_code = entity.getQr_code();;
        this.description = entity.getDescription();
    }
}
