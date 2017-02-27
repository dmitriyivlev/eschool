package ru.ddimike.eschool.validator;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class PhoneValidator {

    private Pattern pattern;
    private Matcher matcher;

    private static final String PHONE_PATTERN = "8\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}";

    public PhoneValidator() {
        pattern = Pattern.compile(PHONE_PATTERN);
    }

    public boolean valid(final String phoneNumber) {

        matcher = pattern.matcher(phoneNumber);
        return matcher.matches();

    }

}
