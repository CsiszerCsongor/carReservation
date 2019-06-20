package dndsys.csongor.project.dto.request;

import dndsys.csongor.project.model.Currency;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class RequestCarDTO {
    @NotBlank
    @Size(min=5, max=50)
    private String name;
    @Range(min=0, max=500)
    private int pricePerDay;
    private Currency currency;

    public RequestCarDTO() {}

    public RequestCarDTO(String name, int pricePerDay, Currency currency) {
        this.name = name;
        this.pricePerDay = pricePerDay;
        this.currency = currency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(int pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
