package com.OMe.domain.quest;

import com.OMe.domain.equipment.Equipment;
import com.OMe.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Quest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipment_id")
    private Equipment equipment;

    @Column
    private Integer stage;

    @Column
    private String content;

    @Column
    private Integer point;

    @Builder
    public Quest(Equipment equipment, Integer stage, String content, Integer point){
        this.equipment = equipment;
        this.stage = stage;
        this.content = content;
        this.point = point;
    }
}
