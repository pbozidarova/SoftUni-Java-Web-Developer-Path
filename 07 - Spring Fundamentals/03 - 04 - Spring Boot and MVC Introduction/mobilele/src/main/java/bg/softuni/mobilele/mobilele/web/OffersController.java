package bg.softuni.mobilele.mobilele.web;

import bg.softuni.mobilele.mobilele.service.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/offers")
public class OffersController {

    private OfferService offerService;

    public OffersController(OfferService offerService) {

        this.offerService = offerService;
    }

    @GetMapping("/all")
    public String getAllOffers(Model model){
        model.addAttribute("models", offerService.getAllOffers());

        return "offers";
    }

}
