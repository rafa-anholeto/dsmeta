package com.raf.dsmeta.services;

import com.raf.dsmeta.entities.Sale;
import com.raf.dsmeta.repositories.SaleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {

    private final SaleRepository saleRepository;

    public SaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public List<Sale> findSales(){
        return saleRepository.findAll();
    }
}
