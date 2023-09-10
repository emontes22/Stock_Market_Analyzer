package com.stock_market_analyzer.Stock_Market_Analyzer.controller;

import com.stock_market_analyzer.Stock_Market_Analyzer.service.AlphaVantageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stock")
public class StockController {
    private final AlphaVantageService alphaVantageService;

    @Autowired
    public StockController(AlphaVantageService alphaVantageService) {
        this.alphaVantageService = alphaVantageService;
    }

    @GetMapping("/data")
    public ResponseEntity<String> getStockData(@RequestParam String symbol, @RequestParam String interval) {
        ResponseEntity<String> response = alphaVantageService.getStockData(symbol, interval);
        return response;
    }
}
