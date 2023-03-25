package com.example.bespring2.service;

import com.example.bespring2.model.Watch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IWatchService{
    Page<Watch> getListWatch(Pageable pageable);

    Watch getWatch(Long idInput);
}
