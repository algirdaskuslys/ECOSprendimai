package sample.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

    public static final String LOGIN_USERNAME_PATTERN = "^[a-zA-Z0-9]{5,13}$";

    public static boolean isValidUsername(String username) {
        Pattern pattern = Pattern.compile(LOGIN_USERNAME_PATTERN); //Pagal jūsu Stringę aprašytas taisyklęs sukurią šabloną
        Matcher matcher = pattern.matcher(username); //Pagal ankščiau sukurtą šablona yra palyginima duomenys
        return matcher.find(); //Grazina true jei atitinka validacija, false jei neatitinka
    }

    public static final String REGISTER_PASSWORD_PATTERM = "^[a-zA-Z0-9!@#$%]{5,13}$";

    public static boolean isValidPassword(String password) {
        Pattern pattern = Pattern.compile(REGISTER_PASSWORD_PATTERM);
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }

    public static final String REGISTER_EMAIL_PATTERN = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,50}$";

    public static boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile(REGISTER_EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }
}
