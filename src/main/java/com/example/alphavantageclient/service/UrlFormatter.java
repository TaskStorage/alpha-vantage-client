package com.example.alphavantageclient.service;

import org.springframework.stereotype.Service;

@Service
public class UrlFormatter {
    private final static String BASE_URL = "https://www.alphavantage.co/query?function=FX_DAILY&from_symbol=%s&to_symbol=%s&apikey=%s";

    public String getUrl(String inputCurrency, String outputCurrency, String apiKey) {
        String url = String.format(BASE_URL, inputCurrency, outputCurrency, apiKey);
        return url;
    }
}
