package dndsys.csongor.project.dto.request;

import java.sql.Date;

public class TwoDateDTO {
    private Date startDate;
    private Date endDate;
    private int page;

    public TwoDateDTO() {}

    public TwoDateDTO(Date startDate, Date endDate, int page){
        this.startDate = startDate;
        this.endDate = endDate;
        this.page = page;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
