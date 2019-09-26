package com.example.alphavantageclient.controller;

import com.example.alphavantageclient.domain.DailyExchangeRate;
import com.example.alphavantageclient.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CurrencyController {

    @Autowired
    CurrencyService currencyService;

    @GetMapping("/stock") String compare (@RequestParam(required = false, defaultValue = "EUR") String inputCurrency,
                                     @RequestParam(required = false, defaultValue = "USD") String outputCurrency,
                                     Model model) {

        List<DailyExchangeRate> results = currencyService.getData(inputCurrency.toUpperCase(), outputCurrency.toUpperCase());
        
        model.addAttribute("results", results);
        return "stock";

    }

    @GetMapping("/chart") String chart (@RequestParam(required = false, defaultValue = "EUR") String inputCurrency,
                                          @RequestParam(required = false, defaultValue = "USD") String outputCurrency,
                                          Model model) {

        List<DailyExchangeRate> results = currencyService.getData(inputCurrency.toUpperCase(), outputCurrency.toUpperCase());

        model.addAttribute("results", results);
        return "chart";

    }
}
