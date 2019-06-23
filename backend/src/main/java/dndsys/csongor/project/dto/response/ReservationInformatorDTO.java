package dndsys.csongor.project.dto.response;

public class ReservationInformatorDTO {
    private long id;
    private String name;
    private String email;
    private String telephone;
    private String address;
    private int sumOfReservation;
    private String carName;
    private int pricePerDay;
    private String carCode;
    private String currency;
    private String startDate;
    private String endDate;

    public ReservationInformatorDTO(long id, String name, String email, String telephone, String address, int sumOfReservation,
                                    String carName, int pricePerDay, String carCode, String currency, String startDate,
                                    String endDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        this.address = address;
        this.sumOfReservation = sumOfReservation;
        this.carName = carName;
        this.pricePerDay = pricePerDay;
        this.carCode = carCode;
        this.currency = currency;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSumOfReservation() {
        return sumOfReservation;
    }

    public void setSumOfReservation(int sumOfReservation) {
        this.sumOfReservation = sumOfReservation;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(int pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public String getCarCode() {
        return carCode;
    }

    public void setCarCode(String carCode) {
        this.carCode = carCode;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
/*
*
* name: string;
    email: string;
    telephone: string;
    address: string;
    sumOfReservation: string;
    carName: string;
    pricePerDay: number;
    carCode: string;
    currency: string;
    startDate: string;
    endDate: string;
* */
