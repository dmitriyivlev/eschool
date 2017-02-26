package ru.ddimike.eschool.validator;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ru.ddimike.eschool.model.Pupil;
import ru.ddimike.eschool.service.PupilService;

import java.util.Date;

@Component
public class PupilFormValidator implements Validator {

    @Autowired
    @Qualifier("phoneValidator")
    PhoneValidator phoneValidator;

    @Autowired
    @Qualifier("emailValidator")
    EmailValidator emailValidator;

    @Autowired
    PupilService pupilService;

    @Override
    public boolean supports(Class<?> clazz) {
        return Pupil.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        Pupil pupil = (Pupil) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotEmpty.pupilForm.firstName");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "NotEmpty.pupilForm.lastName");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sex", "NotEmpty.pupilForm.sex");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "classNumber", "NotEmpty.pupilForm.classNumber");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "classLetter", "NotEmpty.pupilForm.classLetter");

        if(pupil.getBirthday() != null && !pupil.getBirthday().before(new Date())){
            errors.rejectValue("birthday", "Valid.pupilForm.birthday");
        }

        if(pupil.getHomePhone() != null && !pupil.getHomePhone().isEmpty() && !phoneValidator.valid(pupil.getHomePhone())){
            errors.rejectValue("homePhone", "Pattern.pupilForm.homePhone");
        }

        if(pupil.getMobilePhone() != null && !pupil.getMobilePhone().isEmpty() && !phoneValidator.valid(pupil.getMobilePhone())){
            errors.rejectValue("mobilePhone", "Pattern.pupilForm.mobilePhone");
        }

        if(pupil.getEmail() != null && !pupil.getEmail().isEmpty() && !emailValidator.valid(pupil.getEmail())){
            errors.rejectValue("email", "Pattern.pupilForm.email");
        }

    }
}
