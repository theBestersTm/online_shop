package com.onseo.online_shop.data.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Table(name = "goods")
@Entity
@Data
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private String type;
    private String imageUrl;
    @Column(name = "creation_date")
    private LocalDateTime creationDate;
    @Column(name = "guaranty_month")
    private int guarantyMonth;

    @ManyToOne
    @JoinColumn(name = "status")
    private Status status;
}


