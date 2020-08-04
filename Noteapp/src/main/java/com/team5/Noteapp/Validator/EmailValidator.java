package com.team5.Noteapp.Validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<Email, String> {
	String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
			"[a-zA-Z0-9_+&-]+)@" +
			"(?:[a-zA-Z0-9-]+\\.)+[a-z" +
			"A-Z]{2,7}$";
	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		return email != null && email.matches(emailRegex);
	}
}
