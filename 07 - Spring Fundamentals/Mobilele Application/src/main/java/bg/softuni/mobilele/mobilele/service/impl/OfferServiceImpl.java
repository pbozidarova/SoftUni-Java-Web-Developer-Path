package bg.softuni.mobilele.mobilele.service.impl;

import bg.softuni.mobilele.mobilele.model.entities.OfferEntity;
import bg.softuni.mobilele.mobilele.model.service.OfferServiceModel;
import bg.softuni.mobilele.mobilele.model.view.OfferSummeryViewModel;
import bg.softuni.mobilele.mobilele.repository.ModelRepository;
import bg.softuni.mobilele.mobilele.repository.OfferRepository;
import bg.softuni.mobilele.mobilele.repository.UserRepository;
import bg.softuni.mobilele.mobilele.security.CurrentUser;
import bg.softuni.mobilele.mobilele.service.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {

    private final CurrentUser currentUser;
    private final OfferRepository offerRepository;
    private final UserRepository userRepository;
    private final ModelRepository modelRepository;
    private ModelMapper modelMapper;

    public OfferServiceImpl(CurrentUser currentUser,
                            OfferRepository offerRepository,
                            UserRepository userRepository,
                            ModelRepository modelRepository,
                            ModelMapper modelMapper){

        this.currentUser = currentUser;
        this.offerRepository = offerRepository;
        this.userRepository = userRepository;
        this.modelRepository = modelRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<OfferSummeryViewModel> getAllOffers() {
        //TODO - implement mapping
        throw new UnsupportedOperationException("Coming soon! :)");
    }

    @Override
    public long save(OfferServiceModel model) {
        OfferEntity offerEntity = asNewEntity(model);
        OfferEntity newEntity = offerRepository.save(offerEntity);

        return newEntity.getId();
    }

    @Override
    public void deleteById(long id) {
        offerRepository.deleteById(id);
    }

    private OfferEntity asNewEntity(OfferServiceModel model){
        OfferEntity offerEntity = new OfferEntity();
        modelMapper.map(model, offerEntity);
        offerEntity.setId(null);

        offerEntity.setModel(modelRepository.findById(model.getModelId()).orElseThrow());
        offerEntity.setUser(userRepository.findByUsername(currentUser.getName()).orElseThrow());

        return offerEntity;
    }
}
