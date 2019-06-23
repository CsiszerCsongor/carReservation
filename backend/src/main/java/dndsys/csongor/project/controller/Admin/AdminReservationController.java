package dndsys.csongor.project.controller.admin;

import dndsys.csongor.project.dto.response.ReservationBasicInformationDTO;
import dndsys.csongor.project.dto.response.ReservationInformatorDTO;
import dndsys.csongor.project.model.Reservation;
import dndsys.csongor.project.repository.ReservationRepository;
import dndsys.csongor.project.service.ReservationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/admin/reservations/")
public class AdminReservationController {
    @Autowired
    private ReservationServiceImpl reservationService;

    @GetMapping("")
    @PreAuthorize("hasRole('ADMIN')")
    public List<ReservationBasicInformationDTO> getReservations(){
        return reservationService.getReservationsBasicInformations();
    }

    @GetMapping("{reservationId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ReservationInformatorDTO getReservationData(@PathVariable(value="reservationId") long reservationId){
        return reservationService.getReservationData(reservationId);
    }
}
