package dndsys.csongor.project.dto.response;

import dndsys.csongor.project.model.Currency;

public class CurrencyDTO {
    private Long id;
    private String name;

    public CurrencyDTO() {}

    public CurrencyDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public CurrencyDTO currencyToCurrencyDTO(Currency currency) {
        return new CurrencyDTO(currency.getId(), currency.getName());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
