package dndsys.csongor.project.controller.admin;

import dndsys.csongor.project.dto.request.RequestCarDTO;
import dndsys.csongor.project.dto.response.CarDTO;
import dndsys.csongor.project.dto.response.CurrencyDTO;
import dndsys.csongor.project.dto.response.ResponseCarDTO;
import dndsys.csongor.project.model.Currency;
import dndsys.csongor.project.service.CarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/admin/car/")
public class CarController {

    @Autowired
    private CarServiceImpl carService;

    @GetMapping("{carcode}")
    @PreAuthorize("hasRole('ADMIN')")
    public CarDTO getCar(@PathVariable(value="carcode") String carCode){
        System.out.println("Car code : " + carCode);
        return new CarDTO(carService.getCar(carCode));
    }

    @PostMapping("")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseCarDTO createCar(@RequestBody RequestCarDTO carDTO) {
        return carService.createCar(carDTO);
    }
}
