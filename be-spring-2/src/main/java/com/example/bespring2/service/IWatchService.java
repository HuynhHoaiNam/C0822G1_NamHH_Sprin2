package com.example.bespring2.service;

import com.example.bespring2.model.Watch;

import java.util.List;

public interface IWatchService{
    List<Watch> getListWatch();

    Watch getWatch(Long idInput);
}
