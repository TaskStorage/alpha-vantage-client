package com.example.alphavantageclient.repository;

import com.example.alphavantageclient.domain.DailyExchangeRate;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CurrencyRepository extends CrudRepository<DailyExchangeRate, Integer> {
    List<DailyExchangeRate> findByInputCurrencyAndOutputCurrency(String input, String output);
}
