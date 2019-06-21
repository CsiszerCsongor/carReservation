package dndsys.csongor.project.dto.request;

public class CarStateChangeDTO {
    private Long carid;
    private boolean state;

    public Long getCarid() {
        return carid;
    }

    public void setCarid(Long carid) {
        this.carid = carid;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
