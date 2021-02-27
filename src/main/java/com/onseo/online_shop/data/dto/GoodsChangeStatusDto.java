package com.onseo.online_shop.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsChangeStatusDto implements Serializable {
    private Long goodId;
    private String oldStatus;
    private String newStatus;
}
