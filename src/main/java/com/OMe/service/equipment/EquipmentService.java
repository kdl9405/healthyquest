package com.OMe.service.equipment;


import com.OMe.domain.equipment.Equipment;
import com.OMe.domain.equipment.EquipmentRepository;
import com.OMe.web.dto.equipment.EquipmentListResponseDto;
import com.OMe.web.dto.equipment.EquipmentResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class EquipmentService {

    private final EquipmentRepository equipmentRepository;

    @Transactional(readOnly = true)
    public List<EquipmentListResponseDto> findAll(){
        return equipmentRepository.findAll().stream().map(EquipmentListResponseDto::new).collect(Collectors.toList());
    }

    public EquipmentResponseDto findById(Long id){

        Equipment entity = equipmentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 기구가 없습니다. id = "+ id));

        return new EquipmentResponseDto(entity);
    }

}
