package com.onseo.online_shop.data.dto;

import com.onseo.online_shop.data.entity.Goods;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GoodsDto implements Serializable {
    private String name;
    private String type;
    private int guarantyMonth;
    private String imageUrl;
    private LocalDateTime create;
    private String status;

    public static GoodsDto from(Goods goods) {
        return GoodsDto.builder()
                .name(goods.getName())
                .type(goods.getType())
                .guarantyMonth(goods.getGuarantyMonth())
                .status(goods.getStatus().getName())
                .imageUrl(goods.getImageUrl())
                .create(goods.getCreationDate())
                .build();
    }
}
