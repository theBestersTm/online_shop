package com.onseo.online_shop.controller;

import com.onseo.online_shop.data.entity.Status;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/status")
@AllArgsConstructor
public class StatusController {
    @GetMapping
    public ResponseEntity<List<Status.Enum>> getAll() {
        return ResponseEntity.ok(Arrays.asList(Status.Enum.values()));
    }
}
