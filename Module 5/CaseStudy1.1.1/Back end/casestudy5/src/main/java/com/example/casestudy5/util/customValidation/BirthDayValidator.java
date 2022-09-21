package com.example.casestudy5.util.customValidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BirthDayValidator implements ConstraintValidator<BirthDayCustom, LocalDate> {
    @Override
    public void initialize(BirthDayCustom constraintAnnotation) {

    }

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        System.out.println(1);
        if (value == null){
            return false;
        }else {
            return true;
        }
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        String localDateString = value.format(dateTimeFormatter);
//        if (localDateString.matches("^(?:(?:1[6-9]|[2-9]\\d)?\\d{2})(?:(?:(|-|)(?:0?[13578]|1[02])\\1(?:31))|(?:(|-|)(?:0?[13-9]|1[0-2])\\2(?:29|30)))$|^(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00)))(|-|)0?2\\3(?:29)$|^(?:(?:1[6-9]|[2-9]\\d)?\\d{2})(|-|)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:0?[1-9]|1\\d|2[0-8])$"))
//        {
//            System.out.println(1);
//            return true;
//        }
//        else {
//            System.out.println(2);
//            return false;
//        }
    }

}
