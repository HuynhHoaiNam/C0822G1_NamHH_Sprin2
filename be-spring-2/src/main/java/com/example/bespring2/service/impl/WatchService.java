package com.example.bespring2.service.impl;

import com.example.bespring2.model.Watch;
import com.example.bespring2.repository.IWatchRepository;
import com.example.bespring2.service.IWatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WatchService implements IWatchService {
    @Autowired
    private IWatchRepository watchRepository;

    @Override
    public List<Watch> getListWatch() {
        return watchRepository.getListWatch();
    }

    @Override
    public Watch getWatch(Long idInput) {
        return watchRepository.getWatch(idInput);
    }
}
