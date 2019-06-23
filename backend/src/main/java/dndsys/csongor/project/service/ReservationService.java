package dndsys.csongor.project.service;

import dndsys.csongor.project.dto.request.ReservationDTO;
import dndsys.csongor.project.dto.response.ReservationBasicInformationDTO;
import dndsys.csongor.project.dto.response.ReservationInformatorDTO;
import dndsys.csongor.project.model.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationService {
    Reservation save(Reservation item);

    boolean save(ReservationDTO reservationDTO);

    boolean existsReservation(String userName);

    List<ReservationBasicInformationDTO> getReservationsBasicInformations();

    ReservationInformatorDTO getReservationData(long reservationId);
}
