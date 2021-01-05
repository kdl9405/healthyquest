package com.OMe.service.quest;

import com.OMe.domain.equipment.Equipment;
import com.OMe.domain.quest.Quest;
import com.OMe.domain.quest.QuestRepository;
import com.OMe.web.dto.equipment.EquipmentResponseDto;
import com.OMe.web.dto.quest.QuestListResponseDto;
import com.OMe.web.dto.quest.QuestResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QuestService {

    private final QuestRepository questRepository;

    @Transactional
    public List<QuestListResponseDto> findByEquipment(Long id){
        return questRepository.findByEquipmentId(id).stream().map(QuestListResponseDto::new).collect(Collectors.toList());
    }

    public QuestResponseDto findById(Long id){
        Quest entity = questRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 퀘스트가 없습니다. id = "+ id));
        return new QuestResponseDto(entity);
    }


}
