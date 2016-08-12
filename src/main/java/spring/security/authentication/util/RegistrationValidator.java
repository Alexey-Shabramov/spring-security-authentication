package spring.security.authentication.util;


import org.apache.commons.lang3.StringUtils;
import spring.security.authentication.controller.form.RegistrationForm;

import java.util.List;
import java.util.regex.Pattern;

public class RegistrationValidator {
    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private static Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    private static boolean isEmailValid(final String hex) {
        return pattern.matcher(hex).matches();
    }

    public static List<String> validateRegistrationFields(RegistrationForm registrationForm, List<String> errorList) {
        if (!StringUtils.isNotEmpty(registrationForm.getLogin())) {
            errorList.add(Constants.INCORRECT_OR_EMPTY_USER_LOGIN);
        }
        if (!StringUtils.isNotEmpty(registrationForm.getEmail()) || !isEmailValid(registrationForm.getEmail())) {
            errorList.add(Constants.INCORRECT_OR_EMPTY_USER_EMAIL);
        }
        if (!StringUtils.isNotEmpty(registrationForm.getPassword())
                || !StringUtils.isNotEmpty(registrationForm.getSecondaryPassword())) {
            errorList.add(Constants.PASSWORD_IS_INCORRECT);
        } else if (!StringUtils.equals(registrationForm.getPassword(), registrationForm.getSecondaryPassword())) {
            errorList.add(Constants.PASSWORDS_DOES_NOT_MATCH);
        }
        return errorList;
    }
}
