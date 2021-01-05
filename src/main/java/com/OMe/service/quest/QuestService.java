package com.OMe.service.quest;

import com.OMe.domain.quest.QuestRepository;
import com.OMe.web.dto.quest.QuestListResponseDto;
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

}
