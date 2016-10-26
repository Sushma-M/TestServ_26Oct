/**This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/
package com.testserv_26oct.services.currencyconvertor.controller;

import com.testserv_26oct.services.currencyconvertor.services.CurrencyConvertorService;
import com.testserv_26oct.services.currencyconvertor.ConversionRate;
import com.testserv_26oct.services.currencyconvertor.Currency;
import com.testserv_26oct.services.currencyconvertor.ConversionRateResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping(value = "/currencyConvertor")
public class CurrencyConvertorController {

    @Autowired
    private CurrencyConvertorService currencyconvertorService;

    @RequestMapping(value = "/conversionRate", method = RequestMethod.GET)
    public ConversionRateResponse conversionRate(@RequestParam(value = "fromCurrency", required = true) Currency fromCurrency, @RequestParam(value = "toCurrency", required = true) Currency toCurrency) {
        ConversionRate parameters = new ConversionRate();
        parameters.setFromCurrency(fromCurrency);
        parameters.setToCurrency(toCurrency);
        return currencyconvertorService.conversionRate(parameters);
    }
}