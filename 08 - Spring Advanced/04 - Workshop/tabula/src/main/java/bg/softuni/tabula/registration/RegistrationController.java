package bg.softuni.tabula.registration;

import bg.softuni.tabula.announcement.dto.AnnouncementDTO;
import bg.softuni.tabula.registration.dto.RegistrationDTO;
import bg.softuni.tabula.user.UserService;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@AllArgsConstructor
@Controller
public class RegistrationController {

  private final UserService userService;

  @GetMapping("/registration")
  public String showRegister(Model model) {
    model.addAttribute("formData", new RegistrationDTO());
    return "registration/registration";
  }

  @PostMapping("/registration")
  public String register(@Valid @ModelAttribute("formData") RegistrationDTO registrationDTO,
      BindingResult bindingResult) {

    if (bindingResult.hasErrors()) {
      return "registration/registration";
    }

    if (userService.exists(registrationDTO.getEmail())) {
      bindingResult.rejectValue("email",
          "error.email",
          "An account already exists for this email.");
      return "registration/registration";
    }

    userService.registerAndLoginUser(registrationDTO.getEmail(), registrationDTO.getPassword());

    return "redirect:/home";

  }

}
