package com.ucankucuk.AirlineBooking.util;

import org.springframework.util.StringUtils;

public class CreditCardValidator {

    public static String cardValidation(String creditCardNumber) {
        if (!StringUtils.hasText(creditCardNumber)) {
            throw new IllegalArgumentException("Empty CreditCardNumber");
        }

        creditCardNumber = creditCardNumber.replaceAll("\\D+", "");
        if (creditCardNumber.length() != 16) {
            throw new IllegalArgumentException("Wrong CreditCardNumber !");
        }
        return creditCardNumber;
    }

}
