package com.team5.Noteapp.Validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<Email, String> {
	String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		return email != null && email.matches(emailRegex);
	}
}
