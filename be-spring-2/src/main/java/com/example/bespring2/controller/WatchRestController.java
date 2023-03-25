package com.example.bespring2.controller;

import com.example.bespring2.model.Image;
import com.example.bespring2.model.Watch;
import com.example.bespring2.model.WatchType;
import com.example.bespring2.service.IImageService;
import com.example.bespring2.service.IWatchService;
import com.example.bespring2.service.IWatchTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/watch")
public class WatchRestController {
    @Autowired
    private IWatchService watchService;
    @Autowired
    private IImageService iImageService;
    @Autowired
    private IWatchTypeService iWatchTypeService;


    @GetMapping("/list")
    public ResponseEntity<Page<Watch>> getListWatch(@PageableDefault(page = 0, size = 2) Pageable pageable) {
        Page<Watch> listWatch = watchService.getListWatch(pageable);
        if (listWatch.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(listWatch, HttpStatus.OK);
    }


    @GetMapping("/watch-ob/{idInput}")
    public ResponseEntity<Watch> getWatch(@PathVariable("idInput") Long idInput) {
        Watch watch = watchService.getWatch(idInput);
        if (watch == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(watch, HttpStatus.OK);
    }


    @GetMapping("/list-image/{id}")
    public ResponseEntity<List<Image>> getListImage(@PathVariable("id") Long id) {
        List<Image> imageList = iImageService.getListImage(id);
        if (imageList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(imageList, HttpStatus.OK);
    }


    @GetMapping("/watch-type")
    public ResponseEntity<List<WatchType>> getListWatchType() {
        List<WatchType> watchTypeList = iWatchTypeService.getListWatchType();
        if (watchTypeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(watchTypeList, HttpStatus.OK);
    }
}
