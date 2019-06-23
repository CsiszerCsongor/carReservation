package dndsys.csongor.project.dto.request;

public class ReservationDTO {
    private String name;
    private String email;
    private String address;
    private String telephone;
    private String startDate;
    private String endDate;
    private int sumOfReservation;
    private Long carid;
    private String currency;

    public ReservationDTO() {}

    public ReservationDTO(String name, String email, String address, String telephone, String startDate, String endDate,
                          int sumOfReservation, Long carid, String currency) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.telephone = telephone;
        this.startDate = startDate;
        this.endDate = endDate;
        this.sumOfReservation = sumOfReservation;
        this.carid = carid;
        this.currency = currency;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
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

    public int getSumOfReservation() {
        return sumOfReservation;
    }

    public void setSumOfReservation(int sumOfReservation) {
        this.sumOfReservation = sumOfReservation;
    }

    public Long getCarid() {
        return carid;
    }

    public void setCarid(Long carid) {
        this.carid = carid;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
