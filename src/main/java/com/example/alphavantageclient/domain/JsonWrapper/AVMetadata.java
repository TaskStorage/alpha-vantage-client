package com.example.alphavantageclient.domain.JsonWrapper;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AVMetadata {

    @JsonAlias("1. Information")
    private String information;
    @JsonAlias("2. From Symbol")
    private String fromSymbol;
    @JsonAlias("3. To Symbol")
    private String toSymbol;
    @JsonAlias("4. Output Size")
    private String outputSize;
    @JsonAlias("5. Last Refreshed")
    private String lastRefreshed;
    @JsonAlias("6. Time Zone")
    private String timeZone;

    public AVMetadata() {
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getFromSymbol() {
        return fromSymbol;
    }

    public void setFromSymbol(String fromSymbol) {
        this.fromSymbol = fromSymbol;
    }

    public String getToSymbol() {
        return toSymbol;
    }

    public void setToSymbol(String toSymbol) {
        this.toSymbol = toSymbol;
    }

    public String getOutputSize() {
        return outputSize;
    }

    public void setOutputSize(String outputSize) {
        this.outputSize = outputSize;
    }

    public String getLastRefreshed() {
        return lastRefreshed;
    }

    public void setLastRefreshed(String lastRefreshe) {
        this.lastRefreshed = lastRefreshe;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

}
