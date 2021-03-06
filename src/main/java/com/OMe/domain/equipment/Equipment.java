package com.OMe.domain.equipment;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String qr_code;

    @Column
    private String description;

    @Builder
    public Equipment(String name, String qr_code, String description){
        this.name = name;
        this.qr_code = qr_code;
        this.description = description;
    }
}

