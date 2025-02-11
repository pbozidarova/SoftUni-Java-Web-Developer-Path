package bg.softuni.mobilele.mobilele;

import bg.softuni.mobilele.mobilele.enums.EngineEnum;
import bg.softuni.mobilele.mobilele.enums.ModelCategoryEnum;
import bg.softuni.mobilele.mobilele.enums.TransmissionEnum;
import bg.softuni.mobilele.mobilele.enums.UserRoleEnum;
import bg.softuni.mobilele.mobilele.model.entities.*;
import bg.softuni.mobilele.mobilele.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Component
public class DBInit implements CommandLineRunner {

    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;
    private final OfferRepository offerRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRoleRepository userRoleRepository;

    public DBInit(ModelRepository modelRepository,
                  BrandRepository brandRepository,
                  OfferRepository offerRepository,
                  UserRepository userRepository,
                  PasswordEncoder passwordEncoder,
                  UserRoleRepository userRoleRepository) {

        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
        this.offerRepository = offerRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRoleRepository = userRoleRepository;
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        BrandEntity fordBrand = new BrandEntity();
        fordBrand.setName("Ford");


        BrandEntity hondaBrand = new BrandEntity();
        hondaBrand.setName("Honda");


        brandRepository.saveAll(List.of(fordBrand, hondaBrand));

        ModelEntity fiestaModel = initFiesta(fordBrand);
        initEscort(fordBrand);
        initNC750S(hondaBrand);

        createFiestaOffer(fiestaModel);

        initUsers();
    }

    private void initUsers (){
        UserRoleEntity adminRole = new UserRoleEntity().setRole(UserRoleEnum.ADMIN);
        UserRoleEntity userRole = new UserRoleEntity().setRole(UserRoleEnum.USER);

        userRoleRepository.saveAll(List.of(adminRole, userRole));

        UserEntity admin = new UserEntity();
        admin.setFirstName("Kiril")
             .setLastName("Dimitrov")
             .setUsername("admin")
             .setPassword(passwordEncoder.encode("topSecret"))
             .setUserRoles(List.of(adminRole, userRole));

        UserEntity pesho = new UserEntity();
        pesho.setFirstName("Petar")
                .setLastName("Ivanov")
                .setUsername("pesho")
                .setPassword(passwordEncoder.encode("topSecret"))
                .setUserRoles(List.of(userRole));

        userRepository.saveAll(List.of(admin, pesho));
    }

    private void createFiestaOffer(ModelEntity modelEntity) {
        OfferEntity fiestaOffer = new OfferEntity();

        fiestaOffer
                .setEngine(EngineEnum.GASOLINE)
                .setImageUrl("https://www.motortrend.com/uploads/sites/10/2018/10/2019-ford-fiesta-s-sedan-angular-front.png?fit=around%7C875:492.1875")
                .setMileage(80000)
                .setPrice(BigDecimal.valueOf(10000))
                .setYear(2019)
                .setDescription("Karana e ot nemska baba. Zimata v garaj")
                .setTransmission(TransmissionEnum.MANUAL)
                .setModel(modelEntity);


        offerRepository.save(fiestaOffer);
    }

    private ModelEntity initNC750S(BrandEntity brandEntity){
        ModelEntity nc750s = new ModelEntity();

        nc750s.setName("NC750S1")
                .setCategory(ModelCategoryEnum.MOTORCYCLE)
                .setImageUrl("https://www.totalmotorcycle.com/wp-content/uploads/2017/11/2018-Honda-NC750S1-1024x640.jpg")
                .setStartYear(2014)
                .setBrand(brandEntity);


        return modelRepository.save(nc750s);
    }


    private ModelEntity initEscort(BrandEntity brandEntity){
        ModelEntity escort = new ModelEntity();

        escort.setName("Escort")
                .setCategory(ModelCategoryEnum.CAR)
                .setImageUrl("https://upload.wikimedia.org/wikipedia/commons/0/0d/Ford_Escort_MK4_front_20081215.jpg")
                .setStartYear(1968)
                .setEndEYear(2002)
                .setBrand(brandEntity);


        return modelRepository.save(escort);
    }

    private ModelEntity initFiesta(BrandEntity brandEntity){
        ModelEntity fiesta = new ModelEntity();

        fiesta.setName("Fiesta")
                .setCategory(ModelCategoryEnum.CAR)
                .setImageUrl("https://upload.wikimedia.org/wikipedia/commons/7/7d/2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg")
                .setStartYear(1976)
                .setBrand(brandEntity);

        return modelRepository.save(fiesta);
    }

}