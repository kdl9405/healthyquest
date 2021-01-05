package com.OMe.service.equipment;


import com.OMe.domain.equipment.EquipmentRepository;
import com.OMe.web.dto.equipment.EquipmentListResponseDto;
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

}
