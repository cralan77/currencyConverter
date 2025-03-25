package br.com.c6bank.currencyConverter.service;

import br.com.c6bank.currencyConverter.model.entity.ExchangeRates;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// Interface de serviço para obter dados das taxas de conversão em API Externa
@FeignClient(name = "exchangerates", url = "https://api.exchangeratesapi.io/v1")
public interface ExchangeRatesService {

    @GetMapping(
        "latest?access_key=84d4c929522fe84e139630dbc88f546a&symbols={symbols}&format=1"
    )
    ExchangeRates exchangeRates(
            @PathVariable("symbols") String currency
    );
}
