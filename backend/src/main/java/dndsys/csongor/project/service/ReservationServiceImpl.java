package dndsys.csongor.project.service;

import dndsys.csongor.project.model.Reservation;
import dndsys.csongor.project.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ReservationServiceImpl implements ReservationService{
    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public Reservation save(Reservation item) {
        return reservationRepository.save(item);
    }
}
