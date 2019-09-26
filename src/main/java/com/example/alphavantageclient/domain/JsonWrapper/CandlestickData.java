package com.example.alphavantageclient.domain.JsonWrapper;

import com.fasterxml.jackson.annotation.JsonAlias;

public class CandlestickData {

    @JsonAlias("1. open")
    private String open;
    @JsonAlias("2. high")
    private String high;
    @JsonAlias("3. low")
    private String low;
    @JsonAlias("4. close")
    private String close;

    public CandlestickData() {
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    @Override
    public String toString() {
        return "CandlestickData{" +
                "open='" + open + '\'' +
                ", high='" + high + '\'' +
                ", low='" + low + '\'' +
                ", close='" + close + '\'' +
                '}';
    }
}
