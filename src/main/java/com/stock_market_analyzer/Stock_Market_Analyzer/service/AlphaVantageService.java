package com.stock_market_analyzer.Stock_Market_Analyzer.service;

import com.stock_market_analyzer.Stock_Market_Analyzer.config.AlphaVantageConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AlphaVantageService {
    private final RestTemplate restTemplate;
    private final AlphaVantageConfig alphaVantageConfig;

    @Autowired
    public AlphaVantageService(RestTemplate restTemplate, AlphaVantageConfig alphaVantageConfig) {
        this.restTemplate = restTemplate;
        this.alphaVantageConfig = alphaVantageConfig;
    }

    public ResponseEntity<String> getStockData(String symbol, String interval) {
        String apiKey = alphaVantageConfig.getApiKey();
        String apiUrl = "https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY"
                + "&symbol=" + symbol
                + "&interval=" + interval
                + "&apikey=" + apiKey;

        ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);
        return response;
    }
}
