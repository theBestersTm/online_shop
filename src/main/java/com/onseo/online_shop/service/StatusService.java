package com.onseo.online_shop.service;

import com.onseo.online_shop.data.entity.Status;

public interface StatusService extends BaseMethod<Status> {
    Status findByStatus(String status);
}
