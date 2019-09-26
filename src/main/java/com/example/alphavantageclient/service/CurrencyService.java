package com.example.alphavantageclient.service;

import com.example.alphavantageclient.domain.DailyExchangeRate;
import com.example.alphavantageclient.domain.JsonWrapper.AVResponse;
import com.example.alphavantageclient.domain.JsonWrapper.CandlestickData;
import com.example.alphavantageclient.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;


@Service
public class CurrencyService {

    @Autowired
    CurrencyRepository currencyRepository;

    @Value("${alpha.vantage.key}")
    private String key;

    public List<DailyExchangeRate> getData(String inputCurrency, String outputCurrency) {

        Date now = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Hongkong"));
        String today = simpleDateFormat.format(now);

        List<DailyExchangeRate> results = currencyRepository.findByInputCurrencyAndOutputCurrency(inputCurrency, outputCurrency);

        DailyExchangeRate todayRate = new DailyExchangeRate(today, inputCurrency, outputCurrency);

        if (results.isEmpty()) {

            try {
                Map<String, CandlestickData> currencyIndexList = getDataFromAV(inputCurrency, outputCurrency);
                for (Map.Entry<String, CandlestickData> entry : currencyIndexList.entrySet())
                {
                    String date = entry.getKey();
                    String open = entry.getValue().getOpen();
                    String high = entry.getValue().getHigh();
                    String low = entry.getValue().getLow();
                    String close = entry.getValue().getClose();

                    DailyExchangeRate dailyExchangeRate = new DailyExchangeRate(date, inputCurrency, outputCurrency, open, high, low, close);
                    results.add(dailyExchangeRate);
                }
                currencyRepository.saveAll(results);
            } catch (NullPointerException e) {

            }
            return results;
        }
        else if (!results.isEmpty() && results.contains(todayRate)){
            return results;
        } else {

            try {

                Map<String, CandlestickData> currencyIndexList = getDataFromAV(inputCurrency, outputCurrency);

                for (Map.Entry<String, CandlestickData> entry : currencyIndexList.entrySet()) {
                    String date = entry.getKey();
                    String open = entry.getValue().getOpen();
                    String high = entry.getValue().getHigh();
                    String low = entry.getValue().getLow();
                    String close = entry.getValue().getClose();

                    DailyExchangeRate dailyExchangeRate = new DailyExchangeRate(date, inputCurrency, outputCurrency, open, high, low, close);

                    if (results.contains(dailyExchangeRate)) {
                        continue;
                    } else {
                        currencyRepository.save(dailyExchangeRate);
                    }
                }
                results = currencyRepository.findByInputCurrencyAndOutputCurrency(inputCurrency, outputCurrency);
            } catch (NullPointerException e) {

            }
            return results;
        }
    }

    private Map<String, CandlestickData> getDataFromAV(String inputCurrency, String outputCurrency) {
        RestTemplate restTemplate = new RestTemplate();
        String url = new UrlFormatter().getUrl(inputCurrency, outputCurrency, key);
        AVResponse response = restTemplate.getForObject(url, AVResponse.class);
        return response.getPricesMap();
    }
}


