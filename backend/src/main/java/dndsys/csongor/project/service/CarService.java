package dndsys.csongor.project.service;

import dndsys.csongor.project.dto.request.CarStateChangeDTO;
import dndsys.csongor.project.dto.request.RequestCarDTO;
import dndsys.csongor.project.dto.request.UpdateCarDTO;
import dndsys.csongor.project.dto.response.ResponseCarDTO;
import dndsys.csongor.project.model.Car;

public interface CarService {
    Car getCar(String carCode);
    ResponseCarDTO createCar(RequestCarDTO carDTO);
    boolean carStateChange(CarStateChangeDTO carStateChangeDTO);
    ResponseCarDTO updateCar(UpdateCarDTO carDTO);
}
