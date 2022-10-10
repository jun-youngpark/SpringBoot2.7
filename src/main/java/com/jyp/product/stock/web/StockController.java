package com.jyp.product.stock.web;

import com.jyp.product.stock.repository.RedisLockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private RedisLockRepository redisLockRepository;

    @GetMapping("/save")
    public ResponseEntity<?> save(@RequestParam String key, @RequestParam String value) {
        redisLockRepository.save(key,value);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
