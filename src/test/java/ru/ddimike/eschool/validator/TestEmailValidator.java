package ru.ddimike.eschool.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test(groups="email-test")
public class TestEmailValidator {

    EmailValidator emailValidator;

    @BeforeClass
    public void beforeClass() {
        emailValidator = new EmailValidator();
    }

    @Test()
    public void checkEmailValid() {
        Assert.assertEquals(emailValidator.valid("serivanov@gmail.com"), true);
    }

    @Test()
    public void checkEmailNotValid1() {
        Assert.assertEquals(emailValidator.valid("22@22.c"), false);
    }

    @Test()
    public void checkEmailNotValid2() {
        Assert.assertEquals(emailValidator.valid("abc.def"), false);
    }

    @Test()
    public void checkEmailNotValid3() {
        Assert.assertEquals(emailValidator.valid("abc@def"), false);
    }

    @Test()
    public void checkEmailNotValid4() {
        Assert.assertEquals(emailValidator.valid("abc"), false);
    }
}
