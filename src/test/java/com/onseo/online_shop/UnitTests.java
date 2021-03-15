package com.onseo.online_shop;

import com.onseo.online_shop.data.dto.GoodsDto;
import com.onseo.online_shop.data.entity.Goods;
import com.onseo.online_shop.data.entity.Status;
import com.onseo.online_shop.data.repository.GoodsRepository;
import com.onseo.online_shop.service.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.Example;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class UnitTests {
    private GoodsService goodsService;
    private GoodsRepository goodsRepository;
    private StatusService statusService;
    private FileService fileService;


    @Before
    public void init() {
        goodsRepository = Mockito.mock(GoodsRepository.class);
        statusService = Mockito.mock(StatusService.class);
        goodsService = new GoodsServiceImpl(goodsRepository, statusService);
         fileService = new FileServiceImpl();


    }

    @Test
    public void addGoods() {
        GoodsDto goodsDto = new GoodsDto();
        Status status = new Status();
        Goods goods = new Goods();
        LocalDateTime date1 = LocalDateTime.of(2014, 9, 19, 14, 5);

        goodsDto.setName("NewGoods");
        goodsDto.setGuarantyMonth(12);

        status.setId((long) 3);
        status.setName("Available");


        goods.setType("product");
        goods.setGuarantyMonth(23);
        goods.setCreationDate(date1);
        goods.setId((long) 22);
        goods.setImageUrl("newImg");
        goods.setStatus(status);
        goods.setName("NewGoods");

        Mockito.when(goodsRepository.save(Mockito.any())).thenReturn(goods);
        goodsService.save(goodsDto);

        Mockito.verify(goodsRepository).save(Mockito.any());
        Mockito.verify(statusService).findByStatus(Mockito.any());

    }


    @Test
    public void DataVarific() {
        GoodsDto goodsDto = new GoodsDto();
        Status status = new Status();
        Goods goods = new Goods();
        LocalDateTime date1 = LocalDateTime.of(2014, 9, 19, 14, 5);

        goodsDto.setName("NewGoods");
        goodsDto.setGuarantyMonth(12);

        status.setId((long) 3);
        status.setName("Available");


        goods.setType("product");
        goods.setGuarantyMonth(23);
        goods.setCreationDate(date1);
        goods.setId((long) 22);
        goods.setImageUrl("newImg");
        goods.setStatus(status);
        goods.setName("NewGoods");

        Mockito.when(goodsRepository.save(Mockito.any())).thenReturn(goods);
        goodsService.save(goodsDto);

        Assert.assertEquals("NewGoods", goodsDto.getName());
        Assert.assertNotNull(goods.getStatus());


    }

    @Test
    public void addImage() throws IOException {
        GoodsDto goodsDto = new GoodsDto();
        Status status = new Status();
        Goods goods = new Goods();
        LocalDateTime date1 = LocalDateTime.of(2014, 9, 19, 14, 5);

        goodsDto.setName("NewGoods");
        goodsDto.setGuarantyMonth(12);

        status.setId((long) 3);
        status.setName("Available");


        goods.setType("product");
        goods.setGuarantyMonth(23);
        goods.setCreationDate(date1);
        goods.setId((long) 22);
        goods.setImageUrl("newImg");
        goods.setStatus(status);
        goods.setName("NewGoods");

        Mockito.when(goodsRepository.save(Mockito.any())).thenReturn(goods);

        goodsService.save(goodsDto);
        MultipartFile mock = Mockito.mock(MultipartFile.class);
        Mockito.when(mock.getBytes()).thenReturn((System.currentTimeMillis()+"df").getBytes());
        Mockito.when(mock.isEmpty()).thenReturn(false);
        fileService.saveFile(mock);
        Mockito.verify(mock).getBytes();



    }
}