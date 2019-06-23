package dndsys.csongor.project.dbInitializer;

import dndsys.csongor.project.dto.request.RequestCarDTO;
import dndsys.csongor.project.dto.request.ReservationDTO;
import dndsys.csongor.project.model.*;
import dndsys.csongor.project.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ConditionalOnProperty(name = "app.init-db", havingValue = "true")
public class mysqlInitilizer implements CommandLineRunner {
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private RoleServiceImpl roleService;

    @Autowired
    private CurrencyServiceImpl currencyService;

    @Autowired
    private CarServiceImpl carService;

    @Autowired
    private ReservationServiceImpl reservationService;

    @Override
    public void run(String... args) throws Exception {
        if(!saveRole()) {
            System.out.println("Can't save admin role! Maybe there are initial data in database!");
        }
        if(!saveAdmin()){
            System.out.println("Can't save admin! Maybe there are admin already in database!");
        }
        if(!saveCurrency()) {
            System.out.println("Can't save currencies! Maybe there are currencies in database!");
        }

        if(!saveCars()){
            System.out.println("Can't save cars! Maybe there are cars in database!");
        }

        if(!saveReservations()){
            System.out.println("Can't save reservations! Maybe there are reservations in database!");
        }
    }

    private boolean saveRole() {
        if(!roleService.existRoleName(RoleName.ROLE_ADMIN)){        //ha nem letezik, akkor mentse el csak a role-okat
            List<Role> roles = new ArrayList<>();
            roles.add(new Role(RoleName.ROLE_ADMIN));

            return roleService.save(roles);
        }
        return false;
    }

    private boolean saveAdmin() {
        if(userService.findByUsername("admin") == null){
            User user = new User();
            user.setUsername("admin");
            user.setEmail("admin@gmail.com");
            user.setPassword("admin");
            return userService.save(user) != null;
        }
        return false;
    }

    private boolean saveCurrency() {
        if (currencyService.existsCurrency("RON")) {
            return false;
        }
        else {
            Currency currency = new Currency("RON");
            Currency currency2 = new Currency("EURO");
            Currency currency3 = new Currency("USD");
            Currency currency4 = new Currency("HUF");
            currencyService.save(currency);
            currencyService.save(currency2);
            currencyService.save(currency3);
            currencyService.save(currency4);
            return true;
        }
    }


    private boolean saveCars(){
        if(carService.existsCar("Mercedes-Benz GLK 350 CDI 4 MATIC (Automata)")){
            return false;
        }
        else{
            List<Currency> currencies = currencyService.getCurrencies();

            RequestCarDTO carDTO1 = new RequestCarDTO("Mercedes-Benz GLK 350 CDI 4 MATIC (Automata)", 500, currencies.get(2));
            RequestCarDTO carDTO2 = new RequestCarDTO("Volkswagen Golf VII Variant 2.0 TDI BMT Highline", 100, currencies.get(3));
            RequestCarDTO carDTO3 = new RequestCarDTO("Renault Scenic Scénic 1.6 16V Expression", 210, currencies.get(0));
            RequestCarDTO carDTO4 = new RequestCarDTO("AUDI A5 CABRIO 2.0 TDI clean diesel multitronic", 500, currencies.get(1));
            RequestCarDTO carDTO5 = new RequestCarDTO("PEUGEOT 206 SW 1.4 Trendy Plus", 150, currencies.get(3));
            RequestCarDTO carDTO6 = new RequestCarDTO("OPEL AMPERA E-Pioneer (Automata)", 150, currencies.get(1));
            RequestCarDTO carDTO7 = new RequestCarDTO("FORD KUGA 2.0 TDCI Titanium Plus 2WD", 200, currencies.get(1));
            RequestCarDTO carDTO8 = new RequestCarDTO("OPEL ASTRA J Sport Tourer 1.6 CDTI", 50, currencies.get(0));
            RequestCarDTO carDTO9 = new RequestCarDTO("VOLVO S60 2.3 T-5 250 Le", 100, currencies.get(1));
            RequestCarDTO carDTO10 = new RequestCarDTO("PEUGEOT 206 1.4 16V Trendy Plus", 120, currencies.get(2));
            RequestCarDTO carDTO11 = new RequestCarDTO("BMW 530xd Touring (Automata) M Sportpaket", 320, currencies.get(1));
            RequestCarDTO carDTO12 = new RequestCarDTO("HONDA CIVIC 1.6 CTDi", 200, currencies.get(2));

            carService.createCar(carDTO1);
            carService.createCar(carDTO2);
            carService.createCar(carDTO3);
            carService.createCar(carDTO4);
            carService.createCar(carDTO5);
            carService.createCar(carDTO6);
            carService.createCar(carDTO7);
            carService.createCar(carDTO8);
            carService.createCar(carDTO9);
            carService.createCar(carDTO10);
            carService.createCar(carDTO11);
            carService.createCar(carDTO12);

            return true;
        }
    }

    private boolean saveReservations(){
        if(reservationService.existsReservation("Csiszer Csongor")){
            return false;
        }

        ReservationDTO reservation1 = new ReservationDTO("Csiszer Csongor", "csongor.zeek@gmail.com", "Bld. Fratiei, nr. 14, ap. 33", "0751692366", "2019-06-21", "2019-06-22",
                                                          1000, (long)1, "USD");
        ReservationDTO reservation2 = new ReservationDTO("Kis Janos", "janos@gmail.com", "Ferihegy 14", "0651697366", "2019-06-21", "2019-06-22",
                200, (long)2, "HUF");
        ReservationDTO reservation3 = new ReservationDTO("Nagy Sandor", "nagy.sandor@gmail.com", "Kukullo utca, 35", "0751112366", "2019-06-25", "2019-06-26",
                1000, (long)1, "USD");

        reservationService.save(reservation1);
        reservationService.save(reservation2);
        reservationService.save(reservation3);

        return true;
    }
}

