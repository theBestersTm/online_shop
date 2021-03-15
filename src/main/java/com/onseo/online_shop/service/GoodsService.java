package com.onseo.online_shop.service;

import com.onseo.online_shop.data.dto.GoodsChangeStatusDto;
import com.onseo.online_shop.data.dto.GoodsDto;
import com.onseo.online_shop.data.entity.Status;

import java.util.List;

public interface GoodsService extends BaseMethod<GoodsDto> {
    GoodsChangeStatusDto changeStatus(Long id, Status.Enum status);

    List<GoodsDto> findAllByField(int page, int size, String field, String sort);
    List<GoodsDto> getByStatuses(List <String> statuses);
}
