package com.example.bespring2.service.impl;

import com.example.bespring2.model.Watch;
import com.example.bespring2.repository.IWatchRepository;
import com.example.bespring2.service.IWatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WatchService implements IWatchService {
    @Autowired
    private IWatchRepository watchRepository;

    @Override
    public Page<Watch> getListWatch(Pageable pageable) {
        return watchRepository.getListWatch(pageable);
    }

    @Override
    public Watch getWatch(Long idInput) {
        return watchRepository.getWatch(idInput);
    }
}
