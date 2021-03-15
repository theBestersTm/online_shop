package com.onseo.online_shop.data.repository;

import com.onseo.online_shop.data.entity.Goods;
import com.onseo.online_shop.data.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsRepository extends JpaRepository<Goods, Long> {
    List<Goods> findAllByStatusIn(List<Status> stgoods);
}
