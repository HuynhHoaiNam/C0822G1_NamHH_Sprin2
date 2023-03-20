package com.example.bespring2.service.impl;

import com.example.bespring2.repository.IWatchRepository;
import com.example.bespring2.service.IWatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WatchService implements IWatchService {
    @Autowired
    private IWatchRepository watchRepository;
}
