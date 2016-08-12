package spring.security.authentication.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spring.security.authentication.util.Constants;

@Controller
public class AccessController {
    @RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
    public String accessDeniedPageGet(ModelMap model) {
        return "accessDenied";
    }

    @RequestMapping(value = "/accessDenied", method = RequestMethod.POST)
    public String accessDeniedPagePost(ModelMap model) {
        return Constants.ACCESS_DENIED;
    }
}
