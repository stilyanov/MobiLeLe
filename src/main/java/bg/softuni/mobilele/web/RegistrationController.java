package bg.softuni.mobilele.web;

import bg.softuni.mobilele.models.dto.UserRegisterDTO;
import bg.softuni.mobilele.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("registerDTO")
    public UserRegisterDTO registerUserDto() {
        return new UserRegisterDTO();
    }

    @GetMapping("/register")
    public String registerUser() {
        return "auth-register";
    }

    @PostMapping("/register")
    public String registerUser(UserRegisterDTO registerUserDto) {
        this.userService.registerUser(registerUserDto);

        return "redirect:/";
    }
}
