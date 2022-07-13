package com.raf.dsmeta.controllers;

import com.raf.dsmeta.entities.Sale;
import com.raf.dsmeta.services.SaleService;
import com.raf.dsmeta.services.SmsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    private final SaleService saleService;
    private final SmsService smsService;

    public SaleController(SaleService saleService, SmsService smsService) {
        this.saleService = saleService;
        this.smsService = smsService;
    }

    @GetMapping
    public ResponseEntity<Page<Sale>> findSales(@RequestParam(value="minDate", defaultValue = "") String minDate,
                                               @RequestParam(value="maxDate", defaultValue = "") String maxDate,
                                               Pageable pageable){
        return new ResponseEntity<>(saleService.findSales(minDate, maxDate, pageable), HttpStatus.OK);
    }
    @GetMapping("/{id}/notification")
    public void notifySms(@PathVariable Long id){
        smsService.sendSms(id);
    }
}
