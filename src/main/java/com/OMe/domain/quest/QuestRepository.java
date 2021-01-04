package com.OMe.domain.quest;

import com.OMe.domain.equipment.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestRepository extends JpaRepository<Quest, Long> {

    List<Quest> findByEquipmentId(Long id);

}
