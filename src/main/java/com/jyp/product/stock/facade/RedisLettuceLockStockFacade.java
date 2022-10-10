package com.jyp.product.stock.facade;

import com.jyp.product.stock.repository.RedisLockRepository;
import com.jyp.product.stock.service.StockService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class RedisLettuceLockStockFacade {

    private RedisLockRepository redisLockRepository;

    private StockService stockService;

    public RedisLettuceLockStockFacade(RedisLockRepository lockRepository, StockService stockService) {
        this.redisLockRepository = lockRepository;
        this.stockService = stockService;
    }

    @Transactional
    public void decrease(Long id, Long quantity) throws InterruptedException{
        while (!redisLockRepository.lock(id)){
            Thread.sleep(100);
        }
        try{
            stockService.decrease(id,quantity);
        }finally {
            redisLockRepository.unlock(id);
        }
    }
}
