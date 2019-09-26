package com.example.alphavantageclient.domain.JsonWrapper;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AVResponse {

    @JsonAlias("Meta Data")
    private AVMetadata avMetadata;

    @JsonAlias("Time Series FX (Daily)")
    private Map<String, CandlestickData> pricesMap;

    public AVResponse() {
    }

    public Map<String, CandlestickData> getPricesMap() {
        return pricesMap;
    }

    public void setPricesMap(Map<String, CandlestickData> pricesMap) {
        this.pricesMap = pricesMap;
    }

    public AVMetadata getAvMetadata() {
        return avMetadata;
    }

    public void setAvMetadata(AVMetadata avMetadata) {
        this.avMetadata = avMetadata;
    }

}
