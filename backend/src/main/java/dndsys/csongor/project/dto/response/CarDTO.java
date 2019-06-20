package dndsys.csongor.project.dto.response;

import dndsys.csongor.project.model.Car;

public class CarDTO {
    private String name;
    private int pricePerDay;
    private boolean isActive;
    private String currency;
    private String carCode;

    public CarDTO() {}

    public CarDTO(String name, int pricePerDay, boolean isActive, String currency, String carCode) {
        this.name = name;
        this.pricePerDay = pricePerDay;
        this.isActive = isActive;
        this.currency = currency;
        this.carCode = carCode;
    }

    public CarDTO(Car car) {
        this.name = car.getName();
        this.pricePerDay = car.getPricePerDay();
        this.isActive = car.isActive();
        this.currency = car.getCurrency().getName();
        this.carCode = car.getCarCode();
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCarCode() {
        return carCode;
    }

    public void setCarCode(String carCode) {
        this.carCode = carCode;
    }
}
