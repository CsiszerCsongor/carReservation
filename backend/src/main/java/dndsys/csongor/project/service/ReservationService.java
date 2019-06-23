package dndsys.csongor.project.service;

import dndsys.csongor.project.dto.request.ReservationDTO;
import dndsys.csongor.project.model.Reservation;

import java.util.Optional;

public interface ReservationService {
    Reservation save(Reservation item);

    boolean save(ReservationDTO reservationDTO);
}
