package com.codegym.casestudyfurama.Validate;

import com.codegym.casestudyfurama.entity.Customer;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

@Component
public class CustomerValidate implements Validator {


    @Override
    public boolean supports(Class<?> aClass) {
        return Customer.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Customer customerValidate = (Customer) target;
        String date = customerValidate.getBirthday().toString();
        String[] birthdayArray = date.split("-");
        int year = Integer.parseInt(birthdayArray[0]);
        int month = Integer.parseInt(birthdayArray[1]);
        int day = Integer.parseInt(birthdayArray[2]);
        LocalDate birthdate = LocalDate.of(year, month, day);
        LocalDate now = LocalDate.now();
        long age = Period.between(birthdate, now).getYears();
        if (age < 18 || age > 125) {
            errors.rejectValue("birthday", "birthday.Value");
        }
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("ValidationMessages");
        return messageSource;
    }
}
