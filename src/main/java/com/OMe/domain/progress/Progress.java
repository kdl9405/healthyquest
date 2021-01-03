package com.OMe.domain.progress;


import com.OMe.domain.equipment.Equipment;
import com.OMe.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Progress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(targetEntity = Equipment.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "equipment_id")
    private Equipment equipment;

    @Column
    private Integer now_stage;

    @Builder
    public Progress(User user, Equipment equipment, Integer now_stage){
        this.user = user;
        this.equipment = equipment;
        this.now_stage = now_stage;
    }

    public Progress update(Integer now_stage){
        this.now_stage = now_stage;

        return this;
    }

}
