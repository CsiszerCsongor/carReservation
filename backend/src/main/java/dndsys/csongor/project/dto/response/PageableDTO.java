package dndsys.csongor.project.dto.response;

import java.util.List;

public class PageableDTO {
    private List<CarDTO> cars;
    private long numberOfElements;
    private int nrOfPages;

    public PageableDTO() {}

    public PageableDTO(List<CarDTO> cars, long numberOfElements, int nrOfPages){
        this.cars = cars;
        this.numberOfElements = numberOfElements;
        this.nrOfPages = nrOfPages;
    }

    public List<CarDTO> getCars() {
        return cars;
    }

    public void setCars(List<CarDTO> cars) {
        this.cars = cars;
    }

    public long getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(long numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public int getNrOfPages() {
        return nrOfPages;
    }

    public void setNrOfPages(int nrOfPages) {
        this.nrOfPages = nrOfPages;
    }
}
