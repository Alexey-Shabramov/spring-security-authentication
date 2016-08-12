package spring.security.authentication.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import spring.security.authentication.controller.form.RegistrationForm;
import spring.security.authentication.entity.Client;
import spring.security.authentication.exception.ServiceException;
import spring.security.authentication.service.ClientService;
import spring.security.authentication.service.SecurityService;
import spring.security.authentication.util.Constants;
import spring.security.authentication.util.RegistrationValidator;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RegistrationController {
    @Autowired
    protected AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ClientService clientService;
    @Autowired
    private SecurityService securityService;

    @PreAuthorize("isAnonymous()")
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView init(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("/" + Constants.REGISTRATION);
        modelAndView.addObject(Constants.REGISTRATION_FORM, new RegistrationForm());
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView registration(@ModelAttribute("registrationForm") RegistrationForm registrationForm, HttpServletRequest request) {
        List<String> errorList = RegistrationValidator.validateRegistrationFields(registrationForm, new ArrayList<>());
        try {
            Client client = clientService.getByLogin(registrationForm.getLogin());
            if (client != null) {
                errorList.add(Constants.EXIST_USER_LOGIN);
            }
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        if (!errorList.isEmpty()) {
            request.setAttribute(Constants.REGISTRATION_FORM, registrationForm);
            return addErrors(errorList);
        } else {
            Client client = new Client();
            client.setLogin(registrationForm.getLogin());
            client.setEmail(registrationForm.getEmail());
            client.setPassword(passwordEncoder.encode(registrationForm.getPassword()));
            client.setRole(Constants.ROLE_USER);
            try {
                clientService.save(client);
            } catch (ServiceException e) {
                e.printStackTrace();
            }
            securityService.autologin(client.getLogin(), registrationForm.getPassword());
            return new ModelAndView(Constants.REDIRECT_HOME + Constants.INDEX);
        }
    }

    private ModelAndView addErrors(List errorList) {
        ModelAndView model = new ModelAndView("/" + Constants.REGISTRATION);
        model.addObject(Constants.ERRORS, errorList);
        return model;
    }
}
