package dndsys.csongor.project.dto.response;

import dndsys.csongor.project.model.Currency;

public class ResponseCarDTO {
    private String name;
    private int pricePerDay;
    private Currency currency;
    private String carCode;
    private boolean isActive;

    public ResponseCarDTO() {}

    public ResponseCarDTO(String name, int pricePerDay, Currency currency, String carCode, boolean isActive){
        this.name = name;
        this.pricePerDay = pricePerDay;
        this.currency = currency;
        this.carCode = carCode;
        this.isActive = isActive;
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
