package dndsys.csongor.project.dbInitializer;

import dndsys.csongor.project.model.Currency;
import dndsys.csongor.project.model.Role;
import dndsys.csongor.project.model.RoleName;
import dndsys.csongor.project.model.User;
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
}
