package dndsys.csongor.project.service;

import dndsys.csongor.project.dto.request.RequestCarDTO;
import dndsys.csongor.project.dto.response.ResponseCarDTO;
import dndsys.csongor.project.model.Car;
import dndsys.csongor.project.model.Currency;
import dndsys.csongor.project.repository.CarRepository;
import dndsys.csongor.project.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CurrencyRepository currencyRepository;

    private Random random = new Random();

    @Override
    public Car getCar(String carCode) {
        Optional<Car> tmp = carRepository.findCarByCarCode(carCode);
        if(tmp.isPresent()){
            return tmp.get();
        }
        return null;
    }

    @Override
    public ResponseCarDTO createCar(RequestCarDTO carDTO) {
        Car tmp = new Car();
        tmp.setName(carDTO.getName());
        tmp.setPricePerDay(carDTO.getPricePerDay());

        Currency currency;
        Optional<Currency> optionalCurrency = currencyRepository.getCurrencyByName(carDTO.getCurrency());

        if(optionalCurrency.isPresent()){
            currency = optionalCurrency.get();
        }
        else{
            return null;
        }

        tmp.setCurrency(currency);
        tmp.setActive(true);

        tmp.setCarCode(generateCarCode(carDTO.getName()));

        Car car = carRepository.save(tmp);

        ResponseCarDTO response = new ResponseCarDTO(car.getName(), car.getPricePerDay(), currency, car.getCarCode(), car.isActive());

        return response;
    }



    private String generateCarCode(String name) {
        return name.substring(0,3) + (this.random.nextInt(90000) + 10000);
    }
}
