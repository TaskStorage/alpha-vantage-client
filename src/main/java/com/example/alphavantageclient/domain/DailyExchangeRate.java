package com.example.alphavantageclient.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class DailyExchangeRate {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String date;
    private String inputCurrency;
    private String outputCurrency;

    private String open;
    private String high;
    private String low;
    private String close;

    public DailyExchangeRate() {
    }

    public DailyExchangeRate(String date, String inputCurrency, String outputCurrency) {
        this.date = date;
        this.inputCurrency = inputCurrency;
        this.outputCurrency = outputCurrency;
    }

    public DailyExchangeRate(String date, String inputCurrency, String outputCurrency, String open, String high, String low, String close) {
        this.date = date;
        this.inputCurrency = inputCurrency;
        this.outputCurrency = outputCurrency;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getInputCurrency() {
        return inputCurrency;
    }

    public void setInputCurrency(String inputCurrency) {
        this.inputCurrency = inputCurrency;
    }

    public String getOutputCurrency() {
        return outputCurrency;
    }

    public void setOutputCurrency(String outputCurrency) {
        this.outputCurrency = outputCurrency;
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
        return "DailyExchangeRate{" +
                "date='" + date + '\'' +
                ", inputCurrency='" + inputCurrency + '\'' +
                ", outputCurrency='" + outputCurrency + '\'' +
                ", open='" + open + '\'' +
                ", high='" + high + '\'' +
                ", low='" + low + '\'' +
                ", close='" + close + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DailyExchangeRate that = (DailyExchangeRate) o;
        return Objects.equals(date, that.date) &&
                Objects.equals(inputCurrency, that.inputCurrency) &&
                Objects.equals(outputCurrency, that.outputCurrency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, inputCurrency, outputCurrency, open, high, low, close);
    }
}
