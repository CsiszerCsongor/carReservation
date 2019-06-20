package dndsys.csongor.project.service;

import dndsys.csongor.project.model.Currency;
import dndsys.csongor.project.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Component
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    private CurrencyRepository currencyRepository;

    @Override
    public boolean existsCurrency(String name) {
        return currencyRepository.existsByName(name);
    }

    @Override
    public Currency save(Currency currency) {
        return currencyRepository.save(currency);
    }

    @Override
    public List<Currency> getCurrencies() {
        return currencyRepository.findAll();
    }
}
