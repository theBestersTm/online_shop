package com.onseo.online_shop.service;

import com.onseo.online_shop.data.entity.Status;
import com.onseo.online_shop.data.repository.StatusRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@AllArgsConstructor
public class StatusServiceImpl implements StatusService {

    private final StatusRepository statusRepository;

    @Override
    public Status save(Status obj) {
        return statusRepository.save(obj);
    }

    @Override
    public Status getById(Long id) {
        return statusRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("can't find Status obj with id : " + id));
    }

    @Override
    public List<Status> getAll() {
        return statusRepository.findAll();
    }

    @Override
    public Status findByStatus(String status) {
        return statusRepository.findByName(status).orElseThrow(() -> new EntityNotFoundException("can't find Status obj with status : " + status));
    }

    @PostConstruct
    public void init() {
        for (Status.Enum value : Status.Enum.values()) {
            statusRepository.findByName(value.getName())
                    .orElse(statusRepository.save(new Status(value.getName())));
        }
    }
}
