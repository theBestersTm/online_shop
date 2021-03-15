package com.onseo.online_shop.controller;

import com.onseo.online_shop.data.dto.GoodsChangeStatusDto;
import com.onseo.online_shop.data.dto.GoodsDto;
import com.onseo.online_shop.data.entity.Status;
import com.onseo.online_shop.service.GoodsService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping(value = "/goods")
@AllArgsConstructor
public class GoodsController {
    private final GoodsService goodsService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GoodsDto> save(@RequestBody GoodsDto goodsDto) {
        return ResponseEntity
                .ok(goodsService.save(goodsDto));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GoodsDto>> getAll(@RequestParam(required = false, defaultValue = "ASC") String sort,
                                                 @RequestParam(required = false, defaultValue = "id") String field,
                                                 @RequestParam(required = false, defaultValue = "0" ) int page,
                                                 @RequestParam(required = false, defaultValue = "10" ) int size) {
        return ResponseEntity.ok(goodsService.findAllByField(page, size, field, sort));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<GoodsDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(goodsService.getById(id));
    }

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <List<GoodsDto>> getByStatus(@RequestBody List <String> statusNames) {
        return ResponseEntity.ok(goodsService.getByStatuses(statusNames));
    }


    @PostMapping(value = "/{id}/{status}")
    public ResponseEntity<GoodsChangeStatusDto> changeStatus(@PathVariable Long id, @PathVariable Status.Enum status) {
        return ResponseEntity.ok(goodsService.changeStatus(id, status));
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> entityNotFoundException(EntityNotFoundException exc) {
        return ResponseEntity
                .badRequest()
                .body(exc.getMessage());
    }
}
