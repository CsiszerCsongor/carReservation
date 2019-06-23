package dndsys.csongor.project.service;

import dndsys.csongor.project.dto.request.ReservationDTO;
import dndsys.csongor.project.model.Car;
import dndsys.csongor.project.model.Currency;
import dndsys.csongor.project.model.Reservation;
import dndsys.csongor.project.repository.CarRepository;
import dndsys.csongor.project.repository.CurrencyRepository;
import dndsys.csongor.project.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService{
    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private CurrencyRepository currencyRepository;

    @Autowired
    private CarRepository carRepository;

    @Override
    public Reservation save(Reservation item) {
        return reservationRepository.save(item);
    }

    @Override
    public boolean save(ReservationDTO reservationDTO) {

        Optional<Currency> currencyOptional = currencyRepository.getCurrencyByName(reservationDTO.getCurrency());
        Currency currency;
        if(currencyOptional.isPresent())
            currency = currencyOptional.get();
        else
            return false;

        Optional<Car> carOptional = carRepository.findById(reservationDTO.getCarid());
        Car car;
        if(carOptional.isPresent())
            car = carOptional.get();
        else
            return false;

        /**
         * String name, String email, String telephone, int sumOfReservation,
         *                        Car car, Currency currency
         *
         */
        Date startDate = Date.valueOf(reservationDTO.getStartDate());
        Date endDate = Date.valueOf(reservationDTO.getEndDate());

        Reservation reservation = new Reservation(reservationDTO.getName(), reservationDTO.getEmail(), reservationDTO.getTelephone(), reservationDTO.getAddress(), reservationDTO.getSumOfReservation(),
                                                  car, currency, startDate, endDate);

        if(reservationRepository.save(reservation) != null)
            return true;

        return false;
    }
}
