package dndsys.csongor.project.service;

import dndsys.csongor.project.dto.request.CarStateChangeDTO;
import dndsys.csongor.project.dto.request.RequestCarDTO;
import dndsys.csongor.project.dto.request.UpdateCarDTO;
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
        Optional<Currency> optionalCurrency = currencyRepository.getCurrencyByName(carDTO.getCurrency().getName());

        if(optionalCurrency.isPresent()){
            currency = optionalCurrency.get();
        }
        else{
            return null;
        }

        tmp.setCurrency(currency);
        tmp.setActive(true);

        String generatedCarCode = generateCarCode(carDTO.getName());

        while(carRepository.findCarByCarCode(generatedCarCode).isPresent()){
            generatedCarCode = generateCarCode(carDTO.getName());
        }

        tmp.setCarCode(generatedCarCode);

        Car car = carRepository.save(tmp);

        ResponseCarDTO response = new ResponseCarDTO(car.getId(), car.getName(), car.getPricePerDay(), currency, car.getCarCode(), car.isActive());

        return response;
    }

    /*
    * if return true => the update it was successful
    * if return false => the update it was unsuccessful
    * */
    @Override
    public boolean carStateChange(CarStateChangeDTO carStateChangeDTO) {
        Optional<Car> carOptional = carRepository.findById(carStateChangeDTO.getCarid());

        Car car;

        if(carOptional.isPresent()){
            car = carOptional.get();
        }
        else{
            return false;
        }

        car.setActive(carStateChangeDTO.isState());

        carRepository.save(car);
        return true;
    }

    @Override
    public ResponseCarDTO updateCar(UpdateCarDTO carDTO) {
        Optional<Car> carOptional = carRepository.findById(carDTO.getId());
        Car car;

        if(carOptional.isPresent()){
            car = carOptional.get();
        }
        else{
            return null;
        }

        car.setName(carDTO.getName());
        car.setPricePerDay(carDTO.getPricePerDay());

        Optional<Currency> currencyOptional = currencyRepository.getCurrencyByName(carDTO.getCurrency());

        Currency currency;
        if(currencyOptional.isPresent()){
            currency = currencyOptional.get();
        }
        else{
            return null;
        }

        car.setCurrency(currency);

        Car tmp = carRepository.save(car);

        return new ResponseCarDTO(tmp.getId(), tmp.getName(), tmp.getPricePerDay(), currency, car.getCarCode(), car.isActive());
    }


    private String generateCarCode(String name) {
        return name.substring(0,3) + (this.random.nextInt(90000) + 10000);
    }
}
