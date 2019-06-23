package dndsys.csongor.project.dto.response;

public class ReservationBasicInformationDTO {
    private String carname;
    private String startDate;
    private String endDate;
    private int sumOfReservation;
    private long reservationid;

    public ReservationBasicInformationDTO() {}

    public ReservationBasicInformationDTO(long reservationid, String carname, String startDate, String endDate, int sumOfReservation) {
        this.carname = carname;
        this.startDate = startDate;
        this.endDate = endDate;
        this.sumOfReservation = sumOfReservation;
        this.reservationid = reservationid;
    }

    public String getCarname() {
        return carname;
    }

    public void setCarname(String carname) {
        this.carname = carname;
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

    public long getReservationid() {
        return reservationid;
    }

    public void setReservationid(long reservationid) {
        this.reservationid = reservationid;
    }
}
