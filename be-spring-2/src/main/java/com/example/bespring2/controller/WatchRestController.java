package com.example.bespring2.controller;


import com.example.bespring2.dto.IOrderDetail;
import com.example.bespring2.model.Cart;
import com.example.bespring2.model.Image;
import com.example.bespring2.model.Watch;
import com.example.bespring2.model.WatchType;
import com.example.bespring2.service.ICartService;
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
    @Autowired
    private ICartService cartService;


    @GetMapping("/list/{trademarkId}")
    public ResponseEntity<Page<Watch>> getListWatch(@PageableDefault(page = 0, size = 2) Pageable pageable,
                                                    @PathVariable("trademarkId") int trademarkId) {
        Page<Watch> listWatch = watchService.getListWatch(pageable, trademarkId);
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

    @GetMapping("/addOderDetail/{idWatch}/{idUser}")
    public ResponseEntity<?> addCart(@PathVariable("idWatch") Long idWatch, @PathVariable("idUser") Long idUser) {
        if (idUser != null && idWatch != null) {
//            watchService.addCart(idUser, idWatch);
//            Cart cart = cartService.getCartByIdUser(idUser);
//            watchService.addOrderDetail(cart.getId(), idWatch);
//
            watchService.addCart(idUser, idWatch);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/get-cart/{idUser}")
    public ResponseEntity<Cart> getCart(@PathVariable("idUser") Long idUser) {
        Cart cart = cartService.getCartByIdUser(idUser);
        if (cart == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @GetMapping("/get-watch-in-cart/{idUser}")
    public ResponseEntity<List<IOrderDetail>> getWatchInCart(@PathVariable("idUser") Long idUser) {
        List<IOrderDetail> orderDetailList = cartService.getWatchInCart(idUser);
        if (orderDetailList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(orderDetailList, HttpStatus.OK);
    }

    @GetMapping("/pay-watch/{idUser}")
    public ResponseEntity<?> payWatch(@PathVariable("idUser") Long idUser) {
        cartService.payWatch(idUser);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/change-quantity/{idUser}/{valueChange}/{idWatch}")
    public ResponseEntity<?> changeQuantity(@PathVariable("idUser") Long idUser,
                                            @PathVariable("valueChange") Long valueChange,
                                            @PathVariable("idWatch") Long idWatch) {
        watchService.changeQuantity(idUser, valueChange, idWatch);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
