package dndsys.csongor.project.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dndsys.csongor.project.model.Currency;

public class ResponseCarDTO {
    private Long id;
    private String name;
    private int pricePerDay;
    @JsonIgnore
    private Currency currency;
    private String carCode;
    private boolean isActive;

    public ResponseCarDTO() {}

    public ResponseCarDTO(Long id, String name, int pricePerDay, Currency currency, String carCode, boolean isActive){
        this.id = id;
        this.name = name;
        this.pricePerDay = pricePerDay;
        this.currency = currency;
        this.carCode = carCode;
        this.isActive = isActive;
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

    public String getCarCode() {
        return carCode;
    }

    public void setCarCode(String carCode) {
        this.carCode = carCode;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
