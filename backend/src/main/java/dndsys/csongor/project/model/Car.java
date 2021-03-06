package dndsys.csongor.project.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car extends BaseEntity {
    private String name;
    private int pricePerDay;
    private boolean isActive;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="currency_id", nullable = false)
    private Currency currency;
    private String carCode;

    public Car() {}

    public Car(String name, int pricePerDay, boolean isActive, Currency currency, String carCode) {
        this.name = name;
        this.pricePerDay = pricePerDay;
        this.isActive = isActive;
        this.currency = currency;
        this.carCode = carCode;
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getCarCode() {
        return carCode;
    }

    public void setCarCode(String carCode) {
        this.carCode = carCode;
    }
}
