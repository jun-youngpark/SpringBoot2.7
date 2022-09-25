package com.jyp.product.stock.facade;

import com.jyp.product.stock.service.OptimisticStockService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OptimisticStockFacade {

    private OptimisticStockService optimisticStockService;

    public OptimisticStockFacade(OptimisticStockService optimisticStockService){
        this.optimisticStockService = optimisticStockService;
    }

    @Transactional
    public void decrease(Long id,Long quantity) throws InterruptedException{
      while (true){
          try {
              optimisticStockService.decrease(id,quantity);
              break;
          }catch (Exception e){
              Thread.sleep(50);
          }
      }
    }
}
