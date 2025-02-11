package wpartone.web;

import org.dom4j.rule.Mode;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import wpartone.model.binding.UserAddBindingModel;
import wpartone.model.binding.UserLoginBindingModel;
import wpartone.model.service.UserServiceModel;
import wpartone.service.UserService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/login")
    public ModelAndView login(@Valid @ModelAttribute("userLoginBindingModel")
                                      UserLoginBindingModel userLoginBindingModel,
                              BindingResult bindingResult, ModelAndView modelAndView) {
        modelAndView.addObject("userLoginBindingModel", userLoginBindingModel);
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView loginConfirm(@Valid @ModelAttribute("userLoginBindingModel")
                                             UserLoginBindingModel userLoginBindingModel,
                                     BindingResult bindingResult,
                                     ModelAndView modelAndView,
                                     HttpSession httpSession, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel);
            modelAndView.setViewName("redirect:/users/login");
        } else {
            UserServiceModel user = this.userService
                    .findByUsername(userLoginBindingModel.getUsername());

            if (user == null ||
                    !user.getPassword().equals(userLoginBindingModel.getPassword())) {
                redirectAttributes.addFlashAttribute("notFound", true);
                    redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel);

                modelAndView.setViewName("redirect:/users/login");
            } else {
                httpSession.setAttribute("user", user);
                httpSession.setAttribute("id", user.getId());
                httpSession.setAttribute("role", user.getRole().getName());
                modelAndView.setViewName("redirect:/");
            }
        }
        return modelAndView;

    }

    @GetMapping("/register")
    public String register(@Valid @ModelAttribute("userAddBingingModel")
                                       UserAddBindingModel userAddBindingModel,
                           BindingResult bindingResult) {
        return "register";
    }

    @PostMapping("/register")
    public ModelAndView registerConfirm(@Valid @ModelAttribute("userAddBingingModel")
                                                UserAddBindingModel userAddBindingModel,
                                        BindingResult bindingResult,
                                        ModelAndView modelAndView,
                                        RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userAddBingingModel", userAddBindingModel);
            modelAndView.setViewName("redirect:/users/register");
        } else {
            UserServiceModel userServiceModel = this.userService
                    .registerUser(
                            this.modelMapper.map(userAddBindingModel, UserServiceModel.class));
            modelAndView.setViewName("redirect:/users/login");
        }

        return modelAndView;
    }
}
