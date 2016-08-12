package spring.security.authentication.util;


public class Constants {
    public static final String INDEX = "index";
    public static final String LOGIN = "login";
    public static final String REGISTRATION = "registration";
    public static final String ERRORS = "errors";
    public static final String REDIRECT_HOME = "redirect:/";
    public static final String ACCESS_DENIED = "accessDenied";
    public static final String CLIENT = "client";
    public static final String REGISTRATION_FORM = "registrationForm";

    /**
     * Security roles
     */
    public static final String ROLE_USER = "ROLE_USER";
    public static final String ROLE_ADMIN = "ROLE_ADMIN";

    /**
     * Messages
     */
    public static final String CLIENT_DOES_NOT_EXIST = "There is no client with such login.";
    public static final String EXIST_USER_LOGIN = "This login is already taken. Try something else.";
    public static final String INCORRECT_OR_EMPTY_USER_LOGIN = "Incorrect login. Field is empty or has incorrect symbols.";
    public static final String INCORRECT_OR_EMPTY_USER_EMAIL = "Incorrect email. Field is empty or has incorrect symbols.";
    public static final String PASSWORD_IS_INCORRECT = "Incorrect password. Check your password and try again.";
    public static final String PASSWORDS_DOES_NOT_MATCH = "Passwords doesn't match.";

}
