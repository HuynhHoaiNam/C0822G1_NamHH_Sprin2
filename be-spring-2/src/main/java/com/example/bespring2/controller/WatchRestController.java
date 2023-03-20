package com.example.bespring2.controller;

import com.example.bespring2.service.IWatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WatchRestController {
    @Autowired
    private IWatchService watchService;
}
