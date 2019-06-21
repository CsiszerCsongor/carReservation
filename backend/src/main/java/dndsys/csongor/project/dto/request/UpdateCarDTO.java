package dndsys.csongor.project.dto.request;

import dndsys.csongor.project.model.Car;
import dndsys.csongor.project.model.Currency;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UpdateCarDTO {
    private Long id;
    @NotBlank
    @Size(min=5, max=50)
    private String name;
    @Range(min=0, max=500)
    private int pricePerDay;
    @NotBlank
    private String currency;
    private String carCode;
    private boolean isActive;

    public UpdateCarDTO() {}

    public UpdateCarDTO(Long id, String name, int pricePerDay, String currency, String carCode, boolean isActive){
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
