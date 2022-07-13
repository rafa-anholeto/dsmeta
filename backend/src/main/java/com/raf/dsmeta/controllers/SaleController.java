package com.raf.dsmeta.controllers;

import com.raf.dsmeta.entities.Sale;
import com.raf.dsmeta.services.SaleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    private final SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @GetMapping
    public Page<Sale> findSales(@RequestParam(value="minDate", defaultValue = "") String minDate,
                                @RequestParam(value="maxDate", defaultValue = "") String maxDate,
                                Pageable pageable){
        return saleService.findSales(minDate, maxDate, pageable);
    }
}
