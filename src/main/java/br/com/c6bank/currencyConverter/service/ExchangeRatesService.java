package br.com.c6bank.currencyConverter.service;

import br.com.c6bank.currencyConverter.model.entity.ExchangeRates;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "exchangerates", url = "https://api.exchangeratesapi.io/v1")
public interface ExchangeRatesService {

    @GetMapping(
        "latest?access_key=d6234911f644ef97c27d4d4ea6c85cc0&symbols={symbols}&format=1"
    )
    ExchangeRates exchangeRates(
            @PathVariable("symbols") String symbols
    );
}
