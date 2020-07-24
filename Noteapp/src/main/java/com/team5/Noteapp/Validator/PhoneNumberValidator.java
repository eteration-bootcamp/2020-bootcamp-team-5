package com.team5.Noteapp.Validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {
	String phoneNumberRegex = "[0-9]+";
	@Override
	public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {
		return phoneNumber != null && phoneNumber.matches(phoneNumberRegex) && (phoneNumber.length() > 9) && (phoneNumber.length() < 14);
	}
}
