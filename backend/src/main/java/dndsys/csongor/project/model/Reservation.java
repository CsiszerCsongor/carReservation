package dndsys.csongor.project.model;

import javax.persistence.*;

@Entity
@Table(name="reservations")
public class Reservation extends BaseEntity {
    private String firstName;
    private String lastName;
    private String email;
    private String telephone;
    private int nrOfDays;            // reservation days
    private int sumOfReservation;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="car_id", nullable = false)
    private Car car;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="currency_id", nullable = false)
    private Currency currency;

    public Reservation() {}

    public Reservation(String firstName, String lastName, String email, String telephone, int nrOfDays, int sumOfReservation,
                       Car car, Currency currency) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.telephone = telephone;
        this.nrOfDays = nrOfDays;
        this.sumOfReservation = sumOfReservation;
        this.car = car;
        this.currency = currency;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getNrOfDays() {
        return nrOfDays;
    }

    public void setNrOfDays(int nrOfDays) {
        this.nrOfDays = nrOfDays;
    }

    public int getSumOfReservation() {
        return sumOfReservation;
    }

    public void setSumOfReservation(int sumOfReservation) {
        this.sumOfReservation = sumOfReservation;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
