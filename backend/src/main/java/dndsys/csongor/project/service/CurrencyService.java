package dndsys.csongor.project.service;

import dndsys.csongor.project.model.Currency;

import java.util.List;

public interface CurrencyService {
    boolean existsCurrency(String name);
    Currency save(Currency currency);
    List<Currency> getCurrencies();
}
