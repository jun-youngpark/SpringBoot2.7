package com.jyp.product.stock.service;

import com.jyp.product.stock.domain.Stock;
import com.jyp.product.stock.repository.StockRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OptimisticStockService {

    private StockRepository stockRepository;

    public OptimisticStockService(StockRepository stockRepository){
        this.stockRepository = stockRepository;
    }

    @Transactional
    public void decrease(Long id,Long quantity){
        Stock stock = stockRepository.findByIdWithOptimisticLock(id);
        stock.decrease(quantity);
        stockRepository.saveAndFlush(stock);
    }

}
