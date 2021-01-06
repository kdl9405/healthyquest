package com.OMe.service.progress;


import com.OMe.domain.progress.Progress;
import com.OMe.domain.progress.ProgressRepository;
import com.OMe.web.dto.progress.ProgressResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProgressService {

    private final ProgressRepository progressRepository;

    public ProgressResponseDto findByUserIdAndEquipmentId(Long uid, Long eid){
        Progress entity =  progressRepository.findByUserIdAndEquipmentId(uid,eid).orElseThrow(() -> new IllegalArgumentException("해당 진행도가 없습니다. "));
        return new ProgressResponseDto(entity);
    }
}
