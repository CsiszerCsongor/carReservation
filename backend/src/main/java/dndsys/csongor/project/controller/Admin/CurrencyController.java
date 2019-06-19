package dndsys.csongor.project.controller.Admin;

import dndsys.csongor.project.dto.response.CurrencyDTO;
import dndsys.csongor.project.model.Currency;
import dndsys.csongor.project.service.CurrencyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/admin/")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CurrencyController {

    @Autowired
    private CurrencyServiceImpl currencyService;

    @GetMapping("currencies")
    @PreAuthorize("hasRole('ADMIN')")
    private List<CurrencyDTO> getCurrencies(){
        List<Currency> currencies = currencyService.getCurrencies();
        List<CurrencyDTO> currencyDTOS = new ArrayList<>();
        for(int i = 0; i < currencies.size(); ++i)
            currencyDTOS.add(new CurrencyDTO().currencyToCurrencyDTO(currencies.get(i)));

        return currencyDTOS;
    }
}
