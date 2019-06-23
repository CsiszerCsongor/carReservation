package dndsys.csongor.project.controller.user;

import dndsys.csongor.project.dto.request.TwoDateDTO;
import dndsys.csongor.project.dto.response.PageableDTO;
import dndsys.csongor.project.dto.response.ResponseCarDTO;
import dndsys.csongor.project.service.CarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserCarController {
    @Autowired
    private CarServiceImpl carService;

    @PostMapping("cars")
    public PageableDTO getCarsBetweenDates(@RequestBody TwoDateDTO twoDateDTO){
        return carService.getCarsBetweenDates(twoDateDTO);
       // return null;
    }
}
