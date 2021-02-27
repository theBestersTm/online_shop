package com.onseo.online_shop.service;

import com.onseo.online_shop.data.dto.GoodsChangeStatusDto;
import com.onseo.online_shop.data.dto.GoodsDto;
import com.onseo.online_shop.data.entity.Goods;
import com.onseo.online_shop.data.entity.Status;
import com.onseo.online_shop.data.repository.GoodsRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GoodsServiceImpl implements GoodsService {

    private final GoodsRepository goodsRepository;
    private final StatusService statusService;

    @Override
    public GoodsDto save(GoodsDto obj) {
        Goods goods = new Goods();

        goods.setName(obj.getName());
        goods.setGuarantyMonth(obj.getGuarantyMonth());
        goods.setType(obj.getType());
        goods.setImageUrl(obj.getImageUrl());
        goods.setCreationDate(LocalDateTime.now());
        goods.setStatus(statusService.findByStatus(Status.Enum.ABSENT.getName()));

        return GoodsDto.from(goodsRepository.save(goods));
    }

    @Override
    public GoodsDto getById(Long id) {
        return goodsRepository.findById(id).map(GoodsDto::from).orElse(new GoodsDto());
    }

    @Override
    public List<GoodsDto> getAll() {
        return goodsRepository.findAll().stream().map(GoodsDto::from).collect(Collectors.toList());
    }

    @Override
    public GoodsChangeStatusDto changeStatus(Long id, Status.Enum status) {
        Goods goods = goodsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("can't find Goods obj with id : " + id));

        GoodsChangeStatusDto goodsChangeStatusDto = new GoodsChangeStatusDto(goods.getId(), goods.getStatus().getName(), status.getName());

        goods.setStatus(statusService.findByStatus(status.getName()));

        goodsRepository.save(goods);

        return goodsChangeStatusDto;
    }

    @Override
    public List<GoodsDto> findAllByField(int page, int size, String field, String sort) {
        return goodsRepository.findAll(PageRequest.of(page, size, Sort.Direction.fromString(sort), field))
                .stream().map(GoodsDto::from).collect(Collectors.toList());
    }
}
