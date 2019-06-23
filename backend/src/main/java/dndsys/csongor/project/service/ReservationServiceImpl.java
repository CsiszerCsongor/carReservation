package dndsys.csongor.project.service;

import dndsys.csongor.project.dto.request.ReservationDTO;
import dndsys.csongor.project.dto.response.ReservationBasicInformationDTO;
import dndsys.csongor.project.dto.response.ReservationInformatorDTO;
import dndsys.csongor.project.model.Car;
import dndsys.csongor.project.model.Currency;
import dndsys.csongor.project.model.Reservation;
import dndsys.csongor.project.repository.CarRepository;
import dndsys.csongor.project.repository.CurrencyRepository;
import dndsys.csongor.project.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
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

    @Override
    public boolean existsReservation(String userName) {
        return reservationRepository.existsByName(userName);
    }

    @Override
    public List<ReservationBasicInformationDTO> getReservationsBasicInformations() {
        List<Reservation> reservations = reservationRepository.findAll();

        List<ReservationBasicInformationDTO> reservationsDTO = new ArrayList<>();

        for(int i = 0; i < reservations.size(); ++i){
            Reservation tmp = reservations.get(i);
            String date1 = tmp.getStartDate().toString();
            String date2 = tmp.getEndDate().toString();
            reservationsDTO.add(new ReservationBasicInformationDTO(tmp.getId(), tmp.getCar().getName(), date1, date2, tmp.getSumOfReservation()));
        }

        return reservationsDTO;
    }

    @Override
    public ReservationInformatorDTO getReservationData(long reservationId) {
        Optional<Reservation> reservationOptional = reservationRepository.findById(reservationId);
        Reservation reservation;
        if(reservationOptional.isPresent()){
            reservation = reservationOptional.get();
        }
        else{
            return null;
        }

        ReservationInformatorDTO reservationInformatorDTO = new ReservationInformatorDTO(reservation.getId(), reservation.getName(),
                reservation.getEmail(), reservation.getTelephone(), reservation.getAddress(), reservation.getSumOfReservation(),
                reservation.getCar().getName(), reservation.getCar().getPricePerDay(), reservation.getCar().getCarCode(),
                reservation.getCurrency().getName(), reservation.getStartDate().toString(), reservation.getEndDate().toString());

        return reservationInformatorDTO;
    }


}
