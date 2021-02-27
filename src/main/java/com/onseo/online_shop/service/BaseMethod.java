package com.onseo.online_shop.service;

import java.util.List;

public interface BaseMethod<T> {
    T save(T obj);
    T getById(Long id);
    List<T> getAll();
}
