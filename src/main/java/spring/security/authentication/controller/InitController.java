package spring.security.authentication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spring.security.authentication.util.Constants;

@Controller
@RequestMapping("/")
public class InitController {
    @RequestMapping(method = RequestMethod.GET)
    public String init() {
        return Constants.INDEX;
    }
}
