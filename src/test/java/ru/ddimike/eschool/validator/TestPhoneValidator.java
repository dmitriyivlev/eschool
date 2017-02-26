package ru.ddimike.eschool.validator;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.ddimike.eschool.validator.PhoneValidator;

@Test(groups="phone-test")
public class TestPhoneValidator {

    PhoneValidator phoneValidator;

    @BeforeClass
    public void beforeClass() {
        phoneValidator = new PhoneValidator();
    }

    @Test()
    public void checkPhoneValid() {
        Assert.assertEquals(phoneValidator.valid("8(701)985-57-36"), true);
    }

    @Test()
    public void checkPhoneNotValid1() {
        Assert.assertEquals(phoneValidator.valid("8701985-57-36"), false);
    }

    @Test()
    public void checkPhoneNotValid2() {
        Assert.assertEquals(phoneValidator.valid("8(701)9855736"), false);
    }

    @Test()
    public void checkPhoneNotValid3() {
        Assert.assertEquals(phoneValidator.valid("8(701)98-57-367"), false);
    }

    @Test()
    public void checkPhoneNotValid4() {
        Assert.assertEquals(phoneValidator.valid("87019855736"), false);
    }

    @Test()
    public void checkPhoneNotValid5() {
        Assert.assertEquals(phoneValidator.valid("abc"), false);
    }
    @Test()
    public void checkPhoneNotValid6() {
        Assert.assertEquals(phoneValidator.valid("a(bcd)985-ef-3h"), false);
    }
}
