package dndsys.csongor.project.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cars")
public class Car extends BaseEntity {
    private String name;
    private int pricePerDay;
    private boolean isActive;

    public Car() {}

    public Car(String name, int pricePerDay, boolean isActive) {
        this.name = name;
        this.pricePerDay = pricePerDay;
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
