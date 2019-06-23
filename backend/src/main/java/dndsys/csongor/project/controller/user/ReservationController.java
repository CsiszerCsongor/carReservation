package dndsys.csongor.project.controller.user;

import dndsys.csongor.project.dto.request.ReservationDTO;
import dndsys.csongor.project.service.ReservationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/user/reservation")
public class ReservationController {

    @Autowired
    private ReservationServiceImpl reservationService;

    @PostMapping("")
    public boolean createReservation(@RequestBody ReservationDTO reservationDTO){
        return this.reservationService.save(reservationDTO);
    }
}
