package com.onseo.online_shop.data.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "status")
@Entity
@Data
@NoArgsConstructor
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Status(String name) {
        this.name = name;
    }

    @Getter
    public enum Enum {
        AVAILABLE ("Available"),
        ABSENT ("Absent"),
        FINISHING ("Finishing");

        private String name;

        Enum(String name) {
            this.name = name;
        }
    }
}
