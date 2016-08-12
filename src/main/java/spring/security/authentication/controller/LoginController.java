package spring.security.authentication.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spring.security.authentication.util.Constants;

@Controller
public class LoginController {
    @PreAuthorize("isAnonymous()")
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {
        return Constants.LOGIN;
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String successLoginPage(Model model) {
        return Constants.INDEX;
    }
}
